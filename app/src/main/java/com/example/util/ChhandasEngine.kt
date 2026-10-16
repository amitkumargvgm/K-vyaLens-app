package com.example.util

import com.example.model.PadaScansion
import com.example.model.SyllableUnit

object ChhandasEngine {

  private val SHORT_INDEPENDENT_VOWELS = setOf('अ', 'इ', 'उ', 'ऋ', 'ऌ')
  private val LONG_INDEPENDENT_VOWELS = setOf('आ', 'ई', 'ऊ', 'ॠ', 'ॡ', 'ए', 'ऐ', 'ओ', 'औ')

  private val SHORT_MATRAS = setOf('ि', 'ु', 'ृ', 'ॢ')
  private val LONG_MATRAS = setOf('ा', 'ी', 'ू', 'ॄ', 'ॣ', 'े', 'ै', 'ो', 'ौ')

  private val VIRAMA = '्'
  private val ANUSVARA = 'ं'
  private val VISARGA = 'ः'

  /**
   * Scans a single line or pāda into SyllableUnits with Laghu/Guru markings.
   */
  fun scanLine(line: String): List<SyllableUnit> {
    val clean = line.replace(Regex("[\\|।॥,\\.0-9\\s\\(\\)\\[\\]\\{\\}]"), "")
    if (clean.isEmpty()) return emptyList()

    // Break clean text into Devanagari grapheme / akshara units
    val rawUnits = mutableListOf<String>()
    var i = 0
    while (i < clean.length) {
      val sb = java.lang.StringBuilder()
      sb.append(clean[i])
      var j = i + 1
      while (j < clean.length) {
        val c = clean[j]
        if (c == VIRAMA) {
          sb.append(c)
          j++
          if (j < clean.length) {
            sb.append(clean[j])
            j++
          }
        } else if (c in SHORT_MATRAS || c in LONG_MATRAS || c == ANUSVARA || c == VISARGA) {
          sb.append(c)
          j++
        } else {
          break
        }
      }
      rawUnits.add(sb.toString())
      i = j
    }

    val result = mutableListOf<SyllableUnit>()
    for (k in rawUnits.indices) {
      val akshara = rawUnits[k]
      val nextAkshara = rawUnits.getOrNull(k + 1)

      var isGuru = false

      // Rule 1: Check if vowel is inherently long
      val hasLongMatra = akshara.any { it in LONG_MATRAS }
      val isLongIndependent = akshara.any { it in LONG_INDEPENDENT_VOWELS }
      val hasAnusvaraOrVisarga = akshara.any { it == ANUSVARA || it == VISARGA }

      if (hasLongMatra || isLongIndependent || hasAnusvaraOrVisarga) {
        isGuru = true
      } else {
        // Rule 2: Check if followed by conjunct (संयोग) in next akshara
        if (nextAkshara != null && nextAkshara.contains(VIRAMA)) {
          isGuru = true
        }
      }

      // Last syllable of a line can be guru ("पादगोऽपि वा")
      if (k == rawUnits.lastIndex && !isGuru) {
        isGuru = true
      }

      val symbol = if (isGuru) "ऽ" else "।"
      result.add(SyllableUnit(akshara = akshara, symbol = symbol, isGuru = isGuru))
    }

    // Assign Gana labels in groups of 3
    val labeledResult = mutableListOf<SyllableUnit>()
    for (idx in result.indices) {
      val ganaGroupIndex = idx / 3
      val posInGana = idx % 3
      val ganaName = if (posInGana == 0) {
        val g1 = result.getOrNull(idx)?.isGuru ?: false
        val g2 = result.getOrNull(idx + 1)?.isGuru ?: false
        val g3 = result.getOrNull(idx + 2)?.isGuru ?: false
        calculateGanaName(g1, g2, g3)
      } else {
        ""
      }
      labeledResult.add(result[idx].copy(ganaName = ganaName))
    }

    return labeledResult
  }

  private fun calculateGanaName(g1: Boolean, g2: Boolean, g3: Boolean): String {
    return when {
      g1 && g2 && g3 -> "म (सर्वगुरु)"
      !g1 && g2 && g3 -> "य (आदिलघु)"
      g1 && !g2 && g3 -> "र (मध्यलघु)"
      !g1 && !g2 && g3 -> "स (अन्तलघु)"
      g1 && g2 && !g3 -> "त (अन्तगुरु)"
      !g1 && g2 && !g3 -> "ज (मध्यगुरु)"
      g1 && !g2 && !g3 -> "भ (आदिगुरु)"
      !g1 && !g2 && !g3 -> "न (सर्वलघु)"
      else -> ""
    }
  }

  fun scanVerseToPadas(verse: String): List<PadaScansion> {
    val lines = verse.lines().map { it.trim() }.filter { it.isNotEmpty() }
    val padas = mutableListOf<PadaScansion>()

    lines.forEachIndexed { index, line ->
      // Split by dandas if present
      val parts = if (line.contains("।") && !line.endsWith("॥")) {
        line.split("।").map { it.trim() }.filter { it.isNotEmpty() }
      } else {
        listOf(line.replace("॥", "").replace("।", "").trim())
      }

      parts.forEach { part ->
        val scanned = scanLine(part)
        if (scanned.isNotEmpty()) {
          padas.add(PadaScansion(padaNumber = padas.size + 1, padaText = part, syllables = scanned))
        }
      }
    }
    return padas
  }

  fun identifyMeter(scannedPadas: List<PadaScansion>): String {
    if (scannedPadas.isEmpty()) return "अनिर्दिष्टम् (Undetermined)"
    val avgSyllables = scannedPadas.map { it.syllables.size }.average().toInt()

    return when (avgSyllables) {
      8 -> "अनुष्टुप् (श्लोकः / Anushtubh - 8 अक्षराणि)"
      11 -> {
        val firstGana = scannedPadas.firstOrNull()?.syllables?.take(3)?.map { it.symbol }?.joinToString("") ?: ""
        if (firstGana == "ऽऽ।") "इन्द्रवज्रा (Indravajra - 11 अक्षराणि, त-त-ज-ग-ग)"
        else if (firstGana == "।ऽ।") "उपेन्द्रवज्रा (Upendravajra - 11 अक्षराणि, ज-त-ज-ग-ग)"
        else "उपजातिः (Upajati - इन्द्रवज्रोपेन्द्रवज्रयोर्मिश्रणम्)"
      }
      12 -> {
        val firstGana = scannedPadas.firstOrNull()?.syllables?.take(3)?.map { it.symbol }?.joinToString("") ?: ""
        if (firstGana == "।ऽ।") "वंशस्थम् (Vamshastham - 12 अक्षराणि, ज-त-ज-र)"
        else if (firstGana == "ऽ।।") "द्रुतविलम्बितम् (Drutavilambitam - 12 अक्षराणि, न-भ-भ-र)"
        else "भुजङ्गप्रयातम् (Bhujangaprayatam - 12 अक्षराणि, य-य-य-य)"
      }
      13 -> "प्रहर्षिणी (Praharshini - 13 अक्षराणि, म-न-ज-र-ग)"
      14 -> "वसन्ततिलका (Vasantatilaka - 14 अक्षराणि, त-भ-ज-ज-ग-ग)"
      15 -> "मालिनी (Malini - 15 अक्षराणि, न-न-म-य-य)"
      17 -> {
        val first3 = scannedPadas.firstOrNull()?.syllables?.take(3)?.map { it.symbol }?.joinToString("") ?: ""
        if (first3 == "ऽऽऽ") "मन्दाक्रान्ता (Mandakranta - 17 अक्षराणि, म-भ-न-त-त-ग-ग)"
        else "शिखरिणी (Shikharini - 17 अक्षराणि, य-म-न-स-भ-ल-ग)"
      }
      19 -> "शार्दूलविक्रीडितम् (Shardulavikriditam - 19 अक्षराणि, म-स-ज-स-त-त-ग)"
      21 -> "स्रग्धरा (Sragdhara - 21 अक्षराणि, म-र-भ-न-य-य-य)"
      else -> "वृत्तम् (Syllable count: $avgSyllables per pada)"
    }
  }
}
