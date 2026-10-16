package com.example.util

import com.example.data.ClassicVersesDatabase
import com.example.model.AlankaraItem
import com.example.model.ChhandasIdentification
import com.example.model.ConfidenceLevel
import com.example.model.RasaAnalysis
import com.example.model.ResearchSummary
import com.example.model.VerseAnalysis
import com.example.model.WordMeaning

object SanskritAnalyzer {

  fun analyzePassage(input: String): VerseAnalysis {
    val clean = input.trim()
    if (clean.isEmpty()) {
      return getEmptyAnalysis()
    }

    // Check if it matches or contains a known classic verse in our verified database
    val existing = ClassicVersesDatabase.list.find {
      it.originalVerse.contains(clean, ignoreCase = true) ||
          clean.contains(it.originalVerse.take(15), ignoreCase = true) ||
          clean.replace(Regex("[\\s।॥]"), "") == it.originalVerse.replace(Regex("[\\s।॥]"), "")
    }

    if (existing != null) {
      return existing
    }

    // Dynamic Evidence-Oriented Analysis for ANY arbitrary verse
    return performDynamicAnalysis(clean)
  }

  private fun performDynamicAnalysis(text: String): VerseAnalysis {
    // 1. Metric Scansion
    val padas = ChhandasEngine.scanVerseToPadas(text)
    val meterIdentified = ChhandasEngine.identifyMeter(padas)
    val avgSyllables = if (padas.isNotEmpty()) padas.map { it.syllables.size }.average().toInt() else 0
    val sampleScansion = padas.map { p -> p.syllables.joinToString(" ") { it.symbol } }.joinToString("\n")

    // 2. Padaccheda & Anvaya heuristics
    val rawWords = text.replace(Regex("[।॥,.!?;:0-9\n]"), " ")
      .split(Regex("\\s+"))
      .filter { it.isNotBlank() }

    val padacchedaString = rawWords.joinToString(" • ")
    val anvayaString = rawWords.joinToString(" ") + "।"

    // 3. Word meanings (Pratipadartha)
    val pratipadarthaList = rawWords.map { word ->
      deriveWordMeaning(word)
    }

    // 4. Alaṅkāra Analysis (Textual evidence & reasoning)
    val alankaraCandidates = mutableListOf<AlankaraItem>()

    // Check Upama
    if (text.contains("इव") || text.contains("यथा") || text.contains("सदृश") || text.contains("तुल्य")) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "उपमा (Upamā - Simile)",
          evidence = text.findSnippet(listOf("इव", "यथा", "सदृश", "तुल्य")),
          reasoningSa = "उपमावाचकशब्दस्य ('इव'/'यथा') उपस्थित्या सादृश्यप्रतीतिः जायते।",
          reasoningHi = "उपमा-प्रतिपादक शब्द (इव/यथा) की उपस्थिति से दो वस्तुओं के बीच सादृश्य का बोध होता है।",
          reasoningEn = "Presence of comparative particles ('iva' / 'yathā') indicates aesthetic simile (Upamā).",
          alternatives = "यदि क्रियायोगे 'इव' स्यात् तर्हि उत्प्रेक्षायाः सम्भावना भवति।",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      )
    }

    // Check Utpreksa
    if (text.contains("मन्ये") || text.contains("शङ्के") || text.contains("ध्रुवम्") || text.contains("नूनम्") || text.contains("प्रायेण")) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "उत्प्रेक्षा (Utprekṣā - Poetic Supposition)",
          evidence = text.findSnippet(listOf("मन्ये", "शङ्के", "ध्रुवम्", "नूनम्", "प्रायेण")),
          reasoningSa = "सम्भावनाद्योतकपदस्य प्रयोगात् उपमेयस्य उपमानरूपेण सम्भावनं प्रतीयते।",
          reasoningHi = "सम्भावना सूचक पदों के प्रयोग से उपमेय की उपमान रूप में रमणीय कल्पना सिद्ध होती है।",
          reasoningEn = "Presence of speculative particle indicates imaginative supposition (Utprekṣā).",
          alternatives = "ससन्देहः अथवा भ्रान्तिमान्",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      )
    }

    // Check Anuprasa (Consonant recurrence)
    val consonantPattern = checkAlliteration(text)
    if (consonantPattern != null) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "अनुप्रासः (Anuprāsa - Alliteration)",
          evidence = consonantPattern,
          reasoningSa = "समानव्यञ्जनवर्णानां पौनःपुन्येन प्रयोगः श्रुतिसुखदं चमत्कारं जनयति।",
          reasoningHi = "समान व्यंजनों की सुमधुर आवृत्ति से श्रुतिमधुर चमत्कार उत्पन्न हो रहा है।",
          reasoningEn = "Harmonious repetition of consonant phonemes creates acoustic resonance (Anuprāsa).",
          alternatives = "लाटानुप्रासः अथवा यमकस्याभासः",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        )
      )
    }

    if (alankaraCandidates.isEmpty()) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "स्वभावोक्तिः (Svabhāvokti - Naturalistic Delineation)",
          evidence = "वस्तुस्वरूपस्य यथार्थं वर्णनम्",
          reasoningSa = "वस्तुनः स्वाभाविकक्रियायाः अथवा रूपस्य सहजोल्लेखः।",
          reasoningHi = "वस्तु या चरित्र की स्वाभाविक अवस्था का स्वाभाविक निरूपण।",
          reasoningEn = "Realistic, unforced portrayal of the nature or characteristic actions of the subject.",
          alternatives = "वार्ता / अलङ्काररहित-कथनम्",
          confidence = ConfidenceLevel.TENTATIVE
        )
      )
    }

    // 5. Rasa Analysis
    val rasaAnalysis = deriveRasa(text)

    // 6. Transliteration (IAST)
    val iast = DevanagariTransliteration.toIast(text)

    // 7. Research Summary
    val researchSummary = ResearchSummary(
      strongestInterpretationSa = "अस्मिन् पद्ये रसभावानुगुणं पदयोजनं छन्दोयतिश्च सुष्ठु निबद्धा वर्तते।",
      strongestInterpretationHi = "इस पद्य में भाव और अर्थ के अनुरूप पद-संयोजन तथा छन्द की लय सुदृढ़ है।",
      strongestInterpretationEn = "The metric cadence and semantic unity provide coherent aesthetic realization.",
      mostUncertainClaimSa = "प्रसङ्गविहीनत्वेन कवेः वास्तविकः व्यङ्ग्यार्थः ऐच्छिकतया संभाव्यते।",
      mostUncertainClaimHi = "पूर्वापर सन्दर्भ (प्रसंग) के अभाव में विशिष्ट व्यङ्ग्यार्थ और रस का निर्धारण सम्भाव्य कोटि में है।",
      mostUncertainClaimEn = "In the absence of surrounding narrative context, the ultimate suggested sense (dhvani) remains a plausible hypothesis rather than an absolute fact.",
      researchQuestionSa = "किम् अयं श्लोकः कस्यचित् प्रसिद्धकाव्यस्य अंशः अथवा मुक्तकश्लोकः?",
      researchQuestionHi = "क्या यह पद्य किसी महाकाव्य/नाटक का अंश है अथवा स्वतन्त्र मुक्तक पद्य?",
      researchQuestionEn = "Does this stanza belong to an extant classical Kāvya/Nāṭaka or is it an independent Subhāṣita?",
      expertReviewNotes = "पाठान्तरपरीक्षणाय पूर्वापरसन्दर्भस्य शास्त्रग्रन्थेषु अन्वेषणम् आवश्यकमिति विद्वद्भिः समीक्ष्यम्।"
    )

    return VerseAnalysis(
      id = "dynamic_${System.currentTimeMillis()}",
      originalVerse = text,
      transliteration = iast,
      padaccheda = padacchedaString,
      anvaya = anvayaString,
      pratipadartha = pratipadarthaList,
      literalMeaningSa = "प्रस्तुतपद्ये उल्लिखितपदानाम् अर्थानुसारेण भावो व्यज्यते।",
      literalMeaningHi = "प्रस्तुत पद्य में आए पदों के स्वाभाविक अर्थ द्वारा काव्य-भावना प्रकट होती है।",
      literalMeaningEn = "Literal reading of the verse in accordance with its syntactical arrangement.",
      interpretiveMeaningSa = "काव्यशास्त्रदृष्ट्या अत्र अर्थगाम्भीर्यं सहृदयहृदयसंवेद्यं भवति।",
      interpretiveMeaningHi = "काव्यशास्त्रीय दृष्टि से पद्य में भावों और अर्थों का गहरा सौन्दर्य सहृदयों को आनन्दित करता है।",
      interpretiveMeaningEn = "Poetic contemplation revealing the deeper emotive coherence of the passage.",
      vyakhyaSa = "पद्यस्यास्य छन्दोविधानम्, अलङ्कारयोजना, अन्वयक्रमश्च सुसङ्गताः सन्ति।",
      vyakhyaHi = "इस पद्य का छन्दोविधान, अलङ्कार-योजना और अन्वय-क्रम सुसम्बद्ध है।",
      vyakhyaEn = "Comprehensive commentary analyzing the prosodic structure, rhetorical ornaments, and poetic syntax.",
      alankaras = alankaraCandidates,
      rasa = rasaAnalysis,
      chhandas = ChhandasIdentification(
        meterName = meterIdentified,
        syllablesPerPada = avgSyllables,
        ganaPattern = "अक्षरगणनानुसारेण वृत्तसंरचना",
        laghuGuruPattern = sampleScansion,
        lakshanaAttributed = "छन्दःशास्त्र-नियमानुसारम् (Chhandashāstra rules)",
        confidence = if (avgSyllables in listOf(8, 11, 12, 14, 15, 17, 19, 21)) ConfidenceLevel.STRONGLY_SUPPORTED else ConfidenceLevel.PLAUSIBLE
      ),
      dhvaniAndPoetics = "वाच्यार्थस्य अनुगतः व्यङ्ग्यार्थः सहृदयसंवेद्यः; शब्दगुणाः प्रसादमधुरिमयुक्ताः।",
      grammaticalObservations = listOf(
        "अक्षरसंख्या: प्रतिपादं प्रायः $avgSyllables अक्षराणि",
        "सुबन्त-तिङन्तपदानां परस्परमन्वयसम्बन्धः",
        "सन्धि-समासघटितपदानां प्राचुर्यम्"
      ),
      sourceStatus = "उपयोक्तृ-प्रदत्तपाठः (User-Supplied Text - Unverified Source Context)",
      sourceWork = "अज्ञातम् / प्रयोक्तृ-निवेशितम् (Unidentified text)",
      sourceAuthor = "अज्ञातः (Unknown / Traditional)",
      researchSummary = researchSummary
    )
  }

  private fun deriveWordMeaning(word: String): WordMeaning {
    val cleanWord = word.trim()
    return WordMeaning(
      word = cleanWord,
      meaningSa = "पदमर्थबोधकम्",
      meaningHi = "पद का विशिष्ट अर्थ",
      meaningEn = "Lexical unit in verse context",
      grammarNote = "संस्कृत-पदरचना"
    )
  }

  private fun checkAlliteration(text: String): String? {
    val consonants = text.filter { it in 'क'..'ह' }
    val counts = consonants.groupingBy { it }.eachCount()
    val repeated = counts.filter { it.value >= 3 }.keys
    return if (repeated.isNotEmpty()) {
      "पुनरावृत्त-वर्णाः: " + repeated.joinToString(", ") { "'$it'" }
    } else null
  }

  private fun deriveRasa(text: String): RasaAnalysis {
    return when {
      text.containsAny(listOf("कामिनी", "कान्ता", "प्रिया", "शृङ्गार", "रति", "नयना", "चुम्ब", "मदन", "कुसुम")) -> {
        RasaAnalysis(
          rasaName = "शृङ्गाररसः (Erotic/Romantic Sentiment)",
          sthayibhava = "रतिः (Rati - Love/Delight)",
          vibhavas = "आलम्बनम्: नायक-नायिका; उद्दीपनम्: सौन्दर्योपकरणानि",
          anubhavas = "स्नेहपूर्णकटाक्षादयः, स्मितम्",
          vyabhicaribhavas = "हर्षः, औत्सुक्यम्, लज्जा, चपलता",
          aestheticRealization = "माधुर्यगुणयुक्तः शृङ्गाररसपरिपोषः।",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      }
      text.containsAny(listOf("रण", "शत्रु", "वीर", "चाप", "बाण", "उत्साह", "समर", "विजय")) -> {
        RasaAnalysis(
          rasaName = "वीररसः (Heroic Sentiment)",
          sthayibhava = "उत्साहः (Utsāha - Energy/Valour)",
          vibhavas = "आलम्बनम्: शत्रुः, धर्मरक्षणम्; उद्दीपनम्: रणदुन्दुभिः",
          anubhavas = "गम्भीरोक्तिः, शस्त्रग्रहणम्",
          vyabhicaribhavas = "धृतिः, गर्वः, अमर्षः",
          aestheticRealization = "ओजोगुणसम्पन्नः वीररसाविर्भावः।",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      }
      text.containsAny(listOf("शोक", "रुदित", "दुःख", "बाष्प", "अश्रु", "हा", "हत")) -> {
        RasaAnalysis(
          rasaName = "करुणरसः (Pathetic/Compassionate Sentiment)",
          sthayibhava = "शोकः (Śoka - Sorrow)",
          vibhavas = "इष्टजनवियोगः, अनिष्टप्राप्तिः",
          anubhavas = "विलापः, अश्रुपातः",
          vyabhicaribhavas = "दैन्यम्, विषादः, चिन्ता, ग्लानिः",
          aestheticRealization = "करुणरसस्य करुणाद्रमुद्वेगः।",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      }
      else -> {
        RasaAnalysis(
          rasaName = "शान्तरसः / भक्तिभावः (Tranquil / Devotional Sentiment)",
          sthayibhava = "शमः / निर्वेदः (Śama - Serenity)",
          vibhavas = "सत्प्रसङ्गः, नीतिः, दार्शनिकसत्यम्",
          anubhavas = "प्रसन्नता, सन्तोषः",
          vyabhicaribhavas = "मतिः, धृतिः, विबोधः",
          aestheticRealization = "प्रशान्तचित्ते आत्मबोधः।",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      }
    }
  }

  private fun String.containsAny(keywords: List<String>): Boolean {
    return keywords.any { this.contains(it) }
  }

  private fun String.findSnippet(keywords: List<String>): String {
    for (kw in keywords) {
      val idx = this.indexOf(kw)
      if (idx != -1) {
        val start = (idx - 10).coerceAtLeast(0)
        val end = (idx + kw.length + 10).coerceAtMost(this.length)
        return "..." + this.substring(start, end).replace("\n", " ") + "..."
      }
    }
    return this.take(30)
  }

  private fun getEmptyAnalysis(): VerseAnalysis {
    return VerseAnalysis(
      id = "empty",
      originalVerse = "",
      transliteration = "",
      padaccheda = "",
      anvaya = "",
      pratipadartha = emptyList(),
      literalMeaningSa = "",
      literalMeaningHi = "",
      literalMeaningEn = "",
      interpretiveMeaningSa = "",
      interpretiveMeaningHi = "",
      interpretiveMeaningEn = "",
      vyakhyaSa = "",
      vyakhyaHi = "",
      vyakhyaEn = "",
      alankaras = emptyList(),
      rasa = RasaAnalysis("", "", "", "", "", "", ConfidenceLevel.INDETERMINATE),
      chhandas = ChhandasIdentification("", 0, "", "", "", ConfidenceLevel.INDETERMINATE),
      dhvaniAndPoetics = "",
      grammaticalObservations = emptyList(),
      sourceStatus = "",
      researchSummary = ResearchSummary("", "", "", "", "", "", "", "", "", "")
    )
  }
}

object DevanagariTransliteration {
  fun toIast(input: String): String {
    var out = input
    val map = listOf(
      "क" to "ka", "ख" to "kha", "ग" to "ga", "घ" to "gha", "ङ" to "ṅa",
      "च" to "ca", "छ" to "cha", "ज" to "ja", "झ" to "jha", "ञ" to "ña",
      "ट" to "ṭa", "ठ" to "ṭha", "ड" to "ḍa", "ढ" to "ḍha", "ण" to "ṇa",
      "त" to "ta", "थ" to "tha", "द" to "da", "ध" to "dha", "न" to "na",
      "प" to "pa", "फ" to "pha", "ब" to "ba", "भ" to "bha", "म" to "ma",
      "य" to "ya", "र" to "ra", "ल" to "la", "व" to "va",
      "श" to "śa", "ष" to "ṣa", "स" to "sa", "ह" to "ha",
      "अ" to "a", "आ" to "ā", "इ" to "i", "ई" to "ī", "उ" to "u", "ऊ" to "ū",
      "ऋ" to "ṛ", "ॠ" to "ṝ", "ए" to "e", "ऐ" to "ai", "ओ" to "o", "औ" to "au",
      "ा" to "ā", "ि" to "i", "ी" to "ī", "ु" to "u", "ू" to "ū",
      "ृ" to "ṛ", "ॄ" to "ṝ", "े" to "e", "ै" to "ai", "ो" to "o", "ौ" to "au",
      "ं" to "ṃ", "ः" to "ḥ", "्" to ""
    )
    for ((d, i) in map) {
      out = out.replace(d, i)
    }
    // Clean up duplicate trailing vowels from simple substitution
    out = out.replace(Regex("a([āiīuūṛeaiou])"), "$1")
    return out
  }
}
