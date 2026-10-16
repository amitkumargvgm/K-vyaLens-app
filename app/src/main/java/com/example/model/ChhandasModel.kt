package com.example.model

data class ChhandasLakshana(
  val lakshanaText: String,
  val sourceAuthorOrText: String, // e.g. "गङ्गादासकृत-छन्दोमञ्जरी", "केदारभट्टकृत-वृत्तरत्नाकरः", "पिङ्गल-छन्दःसूत्रम्"
  val meaningSa: String,
  val meaningHi: String,
  val meaningEn: String
)

data class SyllableUnit(
  val akshara: String,
  val symbol: String, // "।" (Laghu) or "ऽ" (Guru)
  val isGuru: Boolean,
  val ganaName: String = "" // "म", "भ", "न", etc.
)

data class PadaScansion(
  val padaNumber: Int,
  val padaText: String,
  val syllables: List<SyllableUnit>
)

data class ChhandasItem(
  val id: String,
  val nameSa: String,
  val nameEn: String,
  val category: String, // "समवृत्तम्", "अर्धसमवृत्तम्", "विषमवृत्तम्", "मात्रावृत्तम्"
  val syllableCount: Int,
  val yati: String, // e.g. "८, ७", "४, ६, ७"
  val ganaRule: String, // e.g. "म-भ-न-य-य", "त-त-ज-ग-ग"
  val lakshanas: List<ChhandasLakshana>,
  val exampleVerse: String,
  val exampleSource: String, // e.g. "कालिदासकृत-मेघदूतम्", "रघुवंशम्", "किरातार्जुनीयम्"
  val exampleMeaningSa: String,
  val exampleMeaningHi: String,
  val exampleMeaningEn: String,
  val scansionBreakdown: List<PadaScansion>
)
