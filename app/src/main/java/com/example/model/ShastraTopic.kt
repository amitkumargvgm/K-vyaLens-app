package com.example.model

data class TopicDefinition(
  val text: String,
  val author: String,
  val work: String,
  val meaningSa: String,
  val meaningHi: String,
  val meaningEn: String
)

data class TopicClassification(
  val name: String,
  val descriptionSa: String,
  val descriptionHi: String,
  val descriptionEn: String,
  val example: String = ""
)

data class ShastraTopic(
  val id: String,
  val term: String,
  val termIast: String,
  val category: String,
  val vyutpatti: String, // Shabd nirmaan / root dhatu + pratyaya details
  val definitions: List<TopicDefinition>,
  val svarupaSa: String,
  val svarupaHi: String,
  val svarupaEn: String,
  val classifications: List<TopicClassification>,
  val illustrativeVerse: String = "",
  val illustrativeVerseSource: String = "",
  val illustrativeExplanationSa: String = "",
  val illustrativeExplanationHi: String = "",
  val illustrativeExplanationEn: String = ""
)
