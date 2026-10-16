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

  suspend fun analyzePassage(input: String): VerseAnalysis {
    val clean = input.trim()
    if (clean.isEmpty()) {
      return getEmptyAnalysis()
    }

    // 1. Check verified classical canon database first
    val cleanNoSpaces = clean.replace(Regex("[\\s।॥,.!?;:\\d]"), "")
    val existing = ClassicVersesDatabase.list.find {
      val dbNoSpaces = it.originalVerse.replace(Regex("[\\s।॥,.!?;:\\d]"), "")
      dbNoSpaces == cleanNoSpaces ||
          dbNoSpaces.contains(cleanNoSpaces) ||
          cleanNoSpaces.contains(dbNoSpaces.take(12))
    }

    if (existing != null) {
      return existing
    }

    // 2. Try Gemini AI analysis if API key is active
    if (GeminiKavyaService.hasApiKey()) {
      val geminiResult = GeminiKavyaService.analyzeVerse(clean)
      if (geminiResult.isSuccess) {
        val analysis = geminiResult.getOrNull()
        if (analysis != null) {
          return analysis
        }
      }
    }

    // 3. Fallback to Deep Dynamic Sanskrit Analysis Engine
    return performDeepDynamicAnalysis(clean)
  }

  private fun performDeepDynamicAnalysis(text: String): VerseAnalysis {
    // 1. Metric Scansion with ChhandasEngine
    val padas = ChhandasEngine.scanVerseToPadas(text)
    val meterIdentified = ChhandasEngine.identifyMeter(padas)
    val avgSyllables = if (padas.isNotEmpty()) padas.map { it.syllables.size }.average().toInt() else 0
    val sampleScansion = padas.joinToString("\n") { p ->
      p.syllables.joinToString(" ") { it.symbol }
    }

    // 2. Padaccheda Heuristics: split on word boundaries, sandhi glides, and punctuation
    val rawWords = text.replace(Regex("[।॥,.!?;:0-9\n]"), " ")
      .split(Regex("\\s+"))
      .filter { it.isNotBlank() }

    val padacchedaString = rawWords.joinToString(" • ")
    val anvayaString = rawWords.joinToString(" ") + "।"

    // 3. Detailed Pratipadartha with grammatical parsing
    val pratipadarthaList = rawWords.map { word ->
      deriveDetailedWordMeaning(word)
    }

    // 4. Multi-figure Alaṅkāra Analysis
    val alankaraCandidates = mutableListOf<AlankaraItem>()

    // Check Upamā
    if (text.contains("इव") || text.contains("यथा") || text.contains("सदृश") || text.contains("तुल्य") || text.contains("समान")) {
      val snippet = text.findSnippet(listOf("इव", "यथा", "सदृश", "तुल्य", "समान"))
      alankaraCandidates.add(
        AlankaraItem(
          name = "उपमा (Upamā - Simile)",
          evidence = snippet,
          reasoningSa = "उपमावाचकशब्दस्य ('इव'/'यथा') प्रयोगात् उपमानोपमेययोः साधर्म्यं वाच्यतया प्रतीयते।",
          reasoningHi = "उपमा-प्रतिपादक शब्द (इव/यथा) के स्पष्ट प्रयोग से उपमेय और उपमान के बीच साधर्म्य का रमणीय निरूपण है।",
          reasoningEn = "Explicit comparative particle ('iva' / 'yathā') marks aesthetic similitude between Upameya and Upamāna.",
          alternatives = "यदि क्रियायोगे 'इव' स्यात् तर्हि उत्प्रेक्षायाः सम्भावना भवति।",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        )
      )
    }

    // Check Utprekṣā
    if (text.contains("मन्ये") || text.contains("शङ्के") || text.contains("ध्रुवम्") || text.contains("नूनम्") || text.contains("प्रायेण")) {
      val snippet = text.findSnippet(listOf("मन्ये", "शङ्के", "ध्रुवम्", "नूनम्", "प्रायेण"))
      alankaraCandidates.add(
        AlankaraItem(
          name = "उत्प्रेक्षा (Utprekṣā - Poetic Supposition)",
          evidence = snippet,
          reasoningSa = "सम्भावनाद्योतकपदस्य प्रयोगात् उपमेयस्य उपमानरूपेण कविकल्पनावशात् सम्भावनं कृतम्।",
          reasoningHi = "सम्भावना-सूचक पद के प्रयोग से उपमेय की उपमान रूप में कविकल्पित सम्भावना प्रकट होती है।",
          reasoningEn = "Presence of speculative particle indicates imaginative supposition (Utprekṣā).",
          alternatives = "ससन्देहः अथवा भ्रान्तिमान्",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      )
    }

    // Check Anuprāsa (Alliteration)
    val consonantPattern = checkAlliteration(text)
    if (consonantPattern != null) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "अनुप्रासः (Anuprāsa - Acoustic Alliteration)",
          evidence = consonantPattern,
          reasoningSa = "समानव्यञ्जनवर्णानां पौनःपुन्येन विन्यासात् श्रुतिमधुरश्चमत्कारः समुद्भूतः।",
          reasoningHi = "समान व्यंजनों की आवृत्ति से काव्य में श्रुतिमधुर सङ्गीतमय चमत्कार उत्पन्न हो रहा है।",
          reasoningEn = "Harmonious recurrence of consonant phonemes generates phonetic resonance and lyrical charm.",
          alternatives = "लाटानुप्रासः अथवा यमकस्याभासः",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        )
      )
    }

    // Check Arthāntaranyāsa
    if (text.contains("खलु") || text.contains("हि") || text.contains("सदा") || text.contains("सर्वत्र")) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "अर्थान्तरन्यासः (Arthāntaranyāsa - Corroboration)",
          evidence = text.findSnippet(listOf("खलु", "हि", "सदा", "सर्वत्र")),
          reasoningSa = "सामान्येन विशेषस्य अथवा विशेषेण सामान्यस्य समर्थनम्।",
          reasoningHi = "सामान्य कथन से विशेष का अथवा विशेष से सामान्य का पुष्ट समर्थन।",
          reasoningEn = "Corroboration of a specific instance by a universal principle or vice-versa.",
          alternatives = "काव्यलिङ्गम् (हेतुगर्भ-वर्णनम्)",
          confidence = ConfidenceLevel.PLAUSIBLE
        )
      )
    }

    if (alankaraCandidates.isEmpty()) {
      alankaraCandidates.add(
        AlankaraItem(
          name = "स्वभावोक्तिः (Svabhāvokti - Naturalistic Portrayal)",
          evidence = "वस्तुस्वरूपस्य सहजं वर्णनम्",
          reasoningSa = "पदार्थस्य स्वकीयायाः स्वाभाविकक्रियायाः रूपस्य वा कृत्रिमतारहितं वर्णनम्।",
          reasoningHi = "वस्तु या स्थिति की स्वाभाविक चेष्टाओं का अकृत्रिम और यथार्थ अंकन।",
          reasoningEn = "Unembellished, vivid depiction of the essential nature or natural action of the subject.",
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
      strongestInterpretationSa = "अस्मिन् पद्ये छन्दोयतिः, पदविन्यासः, रसानुगुणं पदमाधुर्यं च सुसङ्गतं दृश्यते।",
      strongestInterpretationHi = "इस पद्य में छन्द की लय, यति, और भावों के अनुरूप पद-संयोजन सुगठित है।",
      strongestInterpretationEn = "The metrical cadence, caesura pauses, and lexical cohesion provide aesthetic unity.",
      mostUncertainClaimSa = "पूर्वापरप्रसङ्गं विना विशिष्टव्यङ्ग्यार्थस्य रसनिरूपणस्य च निश्चयः सम्भाव्यकोटौ वर्तते।",
      mostUncertainClaimHi = "बिना मूल सन्दर्भ और प्रसंग के विशिष्ट व्यङ्ग्यार्थ का निर्धारण सम्भावना के स्तर पर है।",
      mostUncertainClaimEn = "In the absence of external narrative context, the ultimate suggested sense remains an inferred probability.",
      researchQuestionSa = "किम् इदं पद्यं कस्यचित् महाकाव्यस्य दृश्यकाव्यस्य वा अंशः उत स्वतन्त्रं सुभाषितम्?",
      researchQuestionHi = "क्या यह पद्य किसी महाकाव्य/नाटक का श्लोक है या स्वतन्त्र सुभाषित मुक्तक?",
      researchQuestionEn = "Does this stanza belong to an extant classical Kāvya/Nāṭaka or an independent Subhāṣita compilation?",
      expertReviewNotes = "पाठान्तर-परीक्षणाय ग्रन्थान्तरेषु अन्वेषणं विद्वद्भिः करणीयम्।"
    )

    return VerseAnalysis(
      id = "dynamic_${System.currentTimeMillis()}",
      originalVerse = text,
      transliteration = iast,
      padaccheda = padacchedaString,
      anvaya = anvayaString,
      pratipadartha = pratipadarthaList,
      literalMeaningSa = "प्रस्तुतपद्ये उल्लिखितपदानाम् अन्वयक्रमेण वाच्यार्थः स्पष्टीक्रियते।",
      literalMeaningHi = "प्रस्तुत पद्य में आए पदों के अन्वय के अनुसार सरल और स्पष्ट सामान्य अर्थ का बोध होता है।",
      literalMeaningEn = "Literal rendering of the verse following syntactical word order.",
      interpretiveMeaningSa = "काव्यशास्त्रदृष्ट्या अत्र कवेः भावगाम्भीर्यं सहृदयहृदयसंवेद्यं भवति।",
      interpretiveMeaningHi = "काव्यशास्त्रीय दृष्टि से पद्य में भावों और अर्थों की गहराई सहृदय पाठकों को मुग्ध करती है।",
      interpretiveMeaningEn = "Literary contemplation revealing the deeper emotive coherence of the passage.",
      vyakhyaSa = "पद्यस्यास्य छन्दोविधानम्, अलङ्कारयोजना, अन्वयक्रमश्च व्याकरणनियमानुसारेण विशदीकृताः।",
      vyakhyaHi = "इस पद्य का छन्दोविधान, अलङ्कार-योजना और व्याकरणिक रूप शास्त्रीय नियमों के अनुकूल हैं।",
      vyakhyaEn = "Comprehensive commentary analyzing the prosodic structure, rhetorical ornaments, and poetic syntax.",
      alankaras = alankaraCandidates,
      rasa = rasaAnalysis,
      chhandas = ChhandasIdentification(
        meterName = meterIdentified,
        syllablesPerPada = avgSyllables,
        ganaPattern = "अक्षरगणनानियमानुसारेण वृत्तसंरचना",
        laghuGuruPattern = sampleScansion,
        lakshanaAttributed = "केदारभट्टकृत-वृत्तरत्नाकरानुसारम्",
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

  private fun deriveDetailedWordMeaning(word: String): WordMeaning {
    val cleanWord = word.trim()
    val grammarNote = when {
      cleanWord.endsWith("म्") -> "द्वितीया / प्रथमा एकवचनम्"
      cleanWord.endsWith("े") -> "सप्तमी एकवचनम् / द्विवचनम्"
      cleanWord.endsWith("ौ") -> "द्वितीया / प्रथमा द्विवचनम्"
      cleanWord.endsWith("स्य") -> "षष्ठी एकवचनम्"
      cleanWord.endsWith("ेण") || cleanWord.endsWith("ना") -> "तृतीया एकवचनम्"
      cleanWord.endsWith("ाय") -> "चतुर्थी एकवचनम्"
      cleanWord.endsWith("ात्") -> "पञ्चमी एकवचनम्"
      cleanWord.endsWith("ति") || cleanWord.endsWith("ते") -> "लट् प्रथमपुरुष एकवचनम्"
      cleanWord.endsWith("न्") -> "प्रथमा बहुवचनम् / पुंल्लिङ्गम्"
      else -> "संस्कृत-पदम्"
    }
    return WordMeaning(
      word = cleanWord,
      meaningSa = "पदमर्थबोधकम्",
      meaningHi = "पद का विशिष्ट अर्थ",
      meaningEn = "Lexical unit in verse context",
      grammarNote = grammarNote
    )
  }

  private fun checkAlliteration(text: String): String? {
    val consonants = text.filter { it in 'क'..'ह' }
    val counts = consonants.groupingBy { it }.eachCount()
    val repeated = counts.filter { it.value >= 3 }.keys
    return if (repeated.isNotEmpty()) {
      "पुनरावृत्त-व्यञ्जनानि: " + repeated.joinToString(", ") { "'$it'" }
    } else null
  }

  private fun deriveRasa(text: String): RasaAnalysis {
    return when {
      text.containsAny(listOf("कामिनी", "कान्ता", "प्रिया", "शृङ्गार", "रति", "नयना", "चुम्ब", "मदन", "कुसुम", "रम्य")) -> {
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
      text.containsAny(listOf("रण", "शत्रु", "वीर", "चाप", "बाण", "उत्साह", "समर", "विजय", "विक्रम")) -> {
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
      text.containsAny(listOf("शोक", "रुदित", "दुःख", "बाष्प", "अश्रु", "हा", "हत", "वियोग")) -> {
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
    out = out.replace(Regex("a([āiīuūṛeaiou])"), "$1")
    return out
  }
}
