package com.example.strings

import com.example.model.AppLanguage

object AppStrings {

  // App Title
  fun appTitle(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "काव्यलेन्स"
    AppLanguage.HINDI -> "काव्यलेन्स"
    AppLanguage.ENGLISH -> "KāvyaLens"
  }

  fun appSubtitle(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "संस्कृतकाव्य-शास्त्र-अनुसन्धान-सहायकः"
    AppLanguage.HINDI -> "संस्कृत काव्य एवं काव्यशास्त्र अनुसंधान सहायक"
    AppLanguage.ENGLISH -> "Evidence-Oriented Sanskrit Poetics Assistant"
  }

  // Navigation Items (5 Fixed Tabs)
  fun navAnalyze(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "विश्लेषणम्"
    AppLanguage.HINDI -> "विश्लेषण"
    AppLanguage.ENGLISH -> "Analyze"
  }

  fun navChhandas(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "छन्दःशास्त्रम्"
    AppLanguage.HINDI -> "छन्दःशास्त्र"
    AppLanguage.ENGLISH -> "Chhandas"
  }

  fun navShastra(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "शास्त्रकोशः"
    AppLanguage.HINDI -> "शास्त्र कोश"
    AppLanguage.ENGLISH -> "Shāstra Kosha"
  }

  fun navTools(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "साधनानि"
    AppLanguage.HINDI -> "उपकरण"
    AppLanguage.ENGLISH -> "Tools"
  }

  fun navProfile(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "परिचयः"
    AppLanguage.HINDI -> "परिचय"
    AppLanguage.ENGLISH -> "Profile"
  }

  // Analyze Screen
  fun verseInputLabel(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "संस्कृतपद्यं / श्लोकं प्रविशतु"
    AppLanguage.HINDI -> "संस्कृत पद्य या श्लोक यहाँ लिखें"
    AppLanguage.ENGLISH -> "Enter Sanskrit Verse / Passage"
  }

  fun verseInputPlaceholder(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "अत्र श्लोकं लिखतु अथवा चित्रेण निष्कासयतु..."
    AppLanguage.HINDI -> "यहाँ श्लोक लिखें अथवा चित्र से स्कैन करें..."
    AppLanguage.ENGLISH -> "Type or paste a Sanskrit verse, or extract from image..."
  }

  fun btnExamine(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "काव्यं विश्लेषयतु"
    AppLanguage.HINDI -> "पद्य का विश्लेषण करें"
    AppLanguage.ENGLISH -> "Examine Passage"
  }

  fun btnExtractImage(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "चित्रात् श्लोकग्रहणम् (OCR)"
    AppLanguage.HINDI -> "चित्र से श्लोक निकालें (OCR)"
    AppLanguage.ENGLISH -> "Extract from Image (OCR)"
  }

  fun btnClear(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "स्वच्छं कुरु"
    AppLanguage.HINDI -> "साफ़ करें"
    AppLanguage.ENGLISH -> "Clear"
  }

  fun trySampleLabel(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "प्रसिद्धोदाहरणानि:"
    AppLanguage.HINDI -> "प्रसिद्ध उदाहरण:"
    AppLanguage.ENGLISH -> "Try Classical Examples:"
  }

  // Analysis Sections
  fun secOriginalText(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "१. मूलपाठः"
    AppLanguage.HINDI -> "१. मूल पाठ"
    AppLanguage.ENGLISH -> "1. Original Text"
  }

  fun secPadaccheda(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "२. पदच्छेदः (Participation)"
    AppLanguage.HINDI -> "२. पदच्छेद"
    AppLanguage.ENGLISH -> "2. Word Separation (Padaccheda)"
  }

  fun secAnvaya(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "३. अन्वयः"
    AppLanguage.HINDI -> "३. अन्वय"
    AppLanguage.ENGLISH -> "3. Prose Order (Anvaya)"
  }

  fun secPratipadartha(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "४. प्रतिपदार्थः"
    AppLanguage.HINDI -> "४. प्रतिपदार्थ (शब्दार्थ)"
    AppLanguage.ENGLISH -> "4. Word-by-Word Meaning"
  }

  fun secLiteralMeaning(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "५. सामान्यार्थः"
    AppLanguage.HINDI -> "५. सरलार्थ (सामान्य अर्थ)"
    AppLanguage.ENGLISH -> "5. Literal Meaning"
  }

  fun secInterpretiveMeaning(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "६. भावार्थः व व्याख्या"
    AppLanguage.HINDI -> "६. भावार्थ एवं व्याख्या"
    AppLanguage.ENGLISH -> "6. Interpretive Meaning & Commentary"
  }

  fun secAlankara(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "७. अलङ्कार-विमर्शः"
    AppLanguage.HINDI -> "७. अलङ्कार विमर्श"
    AppLanguage.ENGLISH -> "7. Alaṅkāra Analysis"
  }

  fun secRasa(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "८. रस-विमर्शः"
    AppLanguage.HINDI -> "८. रस विमर्श"
    AppLanguage.ENGLISH -> "8. Rasa & Aesthetics"
  }

  fun secChhandas(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "९. छन्दो-विधानम्"
    AppLanguage.HINDI -> "९. छन्द विधान"
    AppLanguage.ENGLISH -> "9. Metrical Analysis"
  }

  fun secResearchSummary(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "१०. शोध-विवरणम् (Research Report)"
    AppLanguage.HINDI -> "१०. शोध सारांश (Research Report)"
    AppLanguage.ENGLISH -> "10. Research Summary"
  }

  fun strongestInterpretation(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "दृढतमा व्याख्या"
    AppLanguage.HINDI -> "दृढ़तम व्याख्या"
    AppLanguage.ENGLISH -> "Strongest Interpretation"
  }

  fun mostUncertainClaim(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "अनिश्चितोऽशः"
    AppLanguage.HINDI -> "सर्वाधिक अनिश्चित दावा"
    AppLanguage.ENGLISH -> "Most Uncertain Claim"
  }

  fun furtherResearchQuestion(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "अग्रिमः शोधप्रश्नः"
    AppLanguage.HINDI -> "आगे का शोध प्रश्न"
    AppLanguage.ENGLISH -> "Further Research Question"
  }

  fun expertReviewNotes(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "विद्वत्-समीक्षा-टिप्पणी"
    AppLanguage.HINDI -> "विशेषज्ञ समीक्षा टिप्पणी"
    AppLanguage.ENGLISH -> "Expert Review Notes"
  }

  // Chhandas Screen
  fun chhandasSearchHint(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "छन्दसः नाम्ना अथवा अक्षरसंख्यया अन्विष्यताम्..."
    AppLanguage.HINDI -> "छन्द के नाम या अक्षर संख्या से खोजें..."
    AppLanguage.ENGLISH -> "Search chhandas by name or syllable count..."
  }

  fun multipleLakshanasLabel(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "लक्षणानि (ग्रन्थान्तरीयाणि):"
    AppLanguage.HINDI -> "लक्षण (आचार्यों के अनुसार):"
    AppLanguage.ENGLISH -> "Lakṣaṇas (According to Treatises):"
  }

  fun scansionGhatana(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "लघु-गुरु प्रस्तार-घटनम् (Scansion):"
    AppLanguage.HINDI -> "लघु-गुरु प्रस्तार घटाकर देखना (Scansion):"
    AppLanguage.ENGLISH -> "Syllabic Scansion Breakdown (Laghu-Guru):"
  }

  // Shastra Kosha
  fun shastraSearchHint(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "रस, ध्वनि, उपमा, वक्रोक्ति... अन्विष्यताम्"
    AppLanguage.HINDI -> "रस, ध्वनि, उपमा, वक्रोक्ति... खोजें"
    AppLanguage.ENGLISH -> "Search Rasa, Dhvani, Upamā, Vakrokti..."
  }

  fun vyutpattiLabel(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "व्युत्पत्तिः (शब्दनिर्माणम्):"
    AppLanguage.HINDI -> "व्युत्पत्ति (शब्द कैसे बना है):"
    AppLanguage.ENGLISH -> "Vyutpatti (Etymology & Word Formation):"
  }

  fun definitionsLabel(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "शास्त्रोक्त-परिभाषाः:"
    AppLanguage.HINDI -> "शास्त्रोक्त परिभाषाएँ:"
    AppLanguage.ENGLISH -> "Classical Definitions:"
  }

  // Profile / Scholar Screen
  fun developerTitle(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "अन्वेषक-परिचयः"
    AppLanguage.HINDI -> "शोधार्थी परिचय"
    AppLanguage.ENGLISH -> "Scholar & Developer"
  }

  fun devName(lang: AppLanguage) = "Amit Kumar"

  fun devBio(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "राष्ट्रिय-संस्कृत-विश्वविद्यालयः, तिरुपतिः — शास्त्री-चतुर्थवर्षस्य छात्रः।"
    AppLanguage.HINDI -> "राष्ट्रीय संस्कृत विश्वविद्यालय, तिरुपति — शास्त्री चतुर्थ वर्ष का छात्र।"
    AppLanguage.ENGLISH -> "Student of Shastri 4th Year at National Sanskrit University, Tirupati."
  }

  fun checkPortfolio(lang: AppLanguage) = "Check Portfolio"

  fun contactEmail(lang: AppLanguage) = "amitkumargvgm@gmail.com"

  fun aboutKavyaLens(lang: AppLanguage) = when (lang) {
    AppLanguage.SANSKRIT -> "काव्यलेन्स (KāvyaLens) संस्कृतकाव्यस्य, काव्यशास्त्रस्य, छन्दोविधानस्य च प्रमाणबद्धः अनुसन्धानसहायकः अस्ति।"
    AppLanguage.HINDI -> "काव्यलेन्स (KāvyaLens) संस्कृत काव्य, काव्यशास्त्र और छन्द विधान का प्रमाण-आधारित आधुनिक शोध उपकरण है।"
    AppLanguage.ENGLISH -> "KāvyaLens is an evidence-oriented research companion for Sanskrit Kāvya, Kāvyashāstra, and prosody."
  }
}
