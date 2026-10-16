package com.example.model

enum class AppLanguage(val code: String, val displayName: String, val nativeName: String) {
  SANSKRIT("sa", "Sanskrit", "संस्कृतम्"),
  HINDI("hi", "Hindi", "हिन्दी"),
  ENGLISH("en", "English", "English");

  companion object {
    fun fromCode(code: String): AppLanguage {
      return entries.find { it.code == code } ?: SANSKRIT
    }
  }
}

enum class ConfidenceLevel(val saText: String, val hiText: String, val enText: String) {
  STRONGLY_SUPPORTED("दृढप्रमाणितम्", "दृढ़ प्रमाणित", "Strongly Supported"),
  PLAUSIBLE("सम्भाव्यम्", "सम्भाव्य / युक्तिसंगत", "Plausible"),
  TENTATIVE("ऐच्छिकम्", "अनिश्चित / ऐच्छिक", "Tentative"),
  INDETERMINATE("अनिर्णितम्", "अनिर्णित", "Indeterminate");

  fun getLabel(lang: AppLanguage): String = when (lang) {
    AppLanguage.SANSKRIT -> saText
    AppLanguage.HINDI -> hiText
    AppLanguage.ENGLISH -> enText
  }
}
