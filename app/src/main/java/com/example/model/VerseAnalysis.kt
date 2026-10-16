package com.example.model

data class WordMeaning(
  val word: String,
  val meaningSa: String,
  val meaningHi: String,
  val meaningEn: String,
  val grammarNote: String = ""
)

data class AlankaraItem(
  val name: String,
  val evidence: String,
  val reasoningSa: String,
  val reasoningHi: String,
  val reasoningEn: String,
  val alternatives: String,
  val confidence: ConfidenceLevel
)

data class RasaAnalysis(
  val rasaName: String,
  val sthayibhava: String,
  val vibhavas: String,
  val anubhavas: String,
  val vyabhicaribhavas: String,
  val aestheticRealization: String,
  val confidence: ConfidenceLevel
)

data class ChhandasIdentification(
  val meterName: String,
  val syllablesPerPada: Int,
  val ganaPattern: String,
  val laghuGuruPattern: String,
  val lakshanaAttributed: String,
  val confidence: ConfidenceLevel
)

data class ResearchSummary(
  val strongestInterpretationSa: String,
  val strongestInterpretationHi: String,
  val strongestInterpretationEn: String,
  val mostUncertainClaimSa: String,
  val mostUncertainClaimHi: String,
  val mostUncertainClaimEn: String,
  val researchQuestionSa: String,
  val researchQuestionHi: String,
  val researchQuestionEn: String,
  val expertReviewNotes: String
)

data class VerseAnalysis(
  val id: String,
  val originalVerse: String,
  val transliteration: String,
  val padaccheda: String,
  val anvaya: String,
  val pratipadartha: List<WordMeaning>,
  val literalMeaningSa: String,
  val literalMeaningHi: String,
  val literalMeaningEn: String,
  val interpretiveMeaningSa: String,
  val interpretiveMeaningHi: String,
  val interpretiveMeaningEn: String,
  val vyakhyaSa: String,
  val vyakhyaHi: String,
  val vyakhyaEn: String,
  val alankaras: List<AlankaraItem>,
  val rasa: RasaAnalysis,
  val chhandas: ChhandasIdentification,
  val dhvaniAndPoetics: String,
  val grammaticalObservations: List<String>,
  val sourceStatus: String,
  val sourceWork: String = "",
  val sourceAuthor: String = "",
  val researchSummary: ResearchSummary
)
