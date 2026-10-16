package com.example.util

import android.graphics.Bitmap
import android.util.Base64
import android.util.Log
import com.example.BuildConfig
import com.example.model.AlankaraItem
import com.example.model.ChhandasIdentification
import com.example.model.ConfidenceLevel
import com.example.model.RasaAnalysis
import com.example.model.ResearchSummary
import com.example.model.VerseAnalysis
import com.example.model.WordMeaning
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.util.concurrent.TimeUnit

object GeminiKavyaService {

  private const val TAG = "GeminiKavyaService"
  private val client = OkHttpClient.Builder()
    .connectTimeout(35, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(35, TimeUnit.SECONDS)
    .build()

  private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()

  private fun getApiKey(): String {
    return try {
      val key = BuildConfig.GEMINI_API_KEY
      if (key.isNullOrBlank() || key == "MY_GEMINI_API_KEY") "" else key
    } catch (e: Exception) {
      ""
    }
  }

  fun hasApiKey(): Boolean = getApiKey().isNotEmpty()

  /**
   * Performs high-accuracy OCR on an image of a Sanskrit verse using Gemini Vision.
   */
  suspend fun extractSanskritFromImage(bitmap: Bitmap): Result<String> = withContext(Dispatchers.IO) {
    val apiKey = getApiKey()
    if (apiKey.isEmpty()) {
      return@withContext Result.failure(Exception("Gemini API key is not configured."))
    }

    try {
      val outputStream = ByteArrayOutputStream()
      bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
      val base64Image = Base64.encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)

      val prompt = """
        You are KāvyaLens, an expert Sanskrit epigraphist and scholar.
        Carefully examine this image containing Sanskrit text / shloka.
        Accurately transcribe all Devanagari Sanskrit verses in this image verbatim.
        Do not add any commentary, greeting, or English notes.
        Output ONLY the raw Devanagari Sanskrit text of the verse with appropriate danda (। / ॥) line breaks.
      """.trimIndent()

      val jsonBody = JSONObject().apply {
        put("contents", JSONArray().apply {
          put(JSONObject().apply {
            put("parts", JSONArray().apply {
              put(JSONObject().apply { put("text", prompt) })
              put(JSONObject().apply {
                put("inline_data", JSONObject().apply {
                  put("mime_type", "image/jpeg")
                  put("data", base64Image)
                })
              })
            })
          })
        })
        put("generationConfig", JSONObject().apply {
          put("temperature", 0.1)
          put("maxOutputTokens", 1024)
        })
      }

      val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey"
      val request = Request.Builder()
        .url(url)
        .post(jsonBody.toString().toRequestBody(JSON_MEDIA_TYPE))
        .build()

      val response = client.newCall(request).execute()
      val responseText = response.body?.string() ?: ""

      if (!response.isSuccessful) {
        Log.e(TAG, "Gemini OCR failed: HTTP ${response.code} $responseText")
        return@withContext Result.failure(Exception("OCR failed (HTTP ${response.code})"))
      }

      val json = JSONObject(responseText)
      val candidates = json.optJSONArray("candidates")
      val text = candidates?.optJSONObject(0)
        ?.optJSONObject("content")
        ?.optJSONArray("parts")
        ?.optJSONObject(0)
        ?.optString("text")
        ?.trim()

      if (!text.isNullOrBlank()) {
        Result.success(text)
      } else {
        Result.failure(Exception("No Sanskrit text could be recognized from the image."))
      }
    } catch (e: Exception) {
      Log.e(TAG, "Exception during Sanskrit OCR", e)
      Result.failure(e)
    }
  }

  /**
   * Performs deep evidence-oriented verse analysis via Gemini AI.
   */
  suspend fun analyzeVerse(verse: String): Result<VerseAnalysis> = withContext(Dispatchers.IO) {
    val apiKey = getApiKey()
    if (apiKey.isEmpty()) {
      return@withContext Result.failure(Exception("Gemini API key is not configured."))
    }

    try {
      val systemPrompt = """
        You are KāvyaLens, an evidence-oriented Sanskrit research assistant specializing in Sanskrit Kāvya, literary criticism, and classical Kāvyashāstra.
        Analyze the supplied Sanskrit verse thoroughly according to traditional scholarship.
        Never invent references. State uncertainty where appropriate.
        Return ONLY valid JSON matching this schema exactly (no markdown code blocks, just raw JSON):
        {
          "originalVerse": "Devanagari text",
          "transliteration": "IAST transliteration",
          "padaccheda": "Separated words with bullets or spaces",
          "anvaya": "Prose order in Devanagari",
          "pratipadartha": [
            {
              "word": "word",
              "meaningSa": "Sanskrit meaning",
              "meaningHi": "Hindi meaning",
              "meaningEn": "English meaning",
              "grammarNote": "Vibhakti/dhatu/pratyaya note"
            }
          ],
          "literalMeaningSa": "Literal meaning in Sanskrit",
          "literalMeaningHi": "Literal meaning in Hindi",
          "literalMeaningEn": "Literal meaning in English",
          "interpretiveMeaningSa": "Interpretive meaning in Sanskrit",
          "interpretiveMeaningHi": "Interpretive meaning in Hindi",
          "interpretiveMeaningEn": "Interpretive meaning in English",
          "vyakhyaSa": "Deep commentary in Sanskrit",
          "vyakhyaHi": "Deep commentary in Hindi",
          "vyakhyaEn": "Deep commentary in English",
          "alankaras": [
            {
              "name": "Alaṅkāra name",
              "evidence": "Exact textual evidence",
              "reasoningSa": "Reasoning in Sanskrit",
              "reasoningHi": "Reasoning in Hindi",
              "reasoningEn": "Reasoning in English",
              "alternatives": "Alternative reading/figure",
              "confidence": "STRONGLY_SUPPORTED" // or "PLAUSIBLE", "TENTATIVE", "INDETERMINATE"
            }
          ],
          "rasa": {
            "rasaName": "Rasa name (e.g. Śṛṅgāra, Śānta, Vīra)",
            "sthayibhava": "Sthāyībhāva",
            "vibhavas": "Ālambana and Uddīpana",
            "anubhavas": "Anubhāvas",
            "vyabhicaribhavas": "Vyabhicāribhāvas",
            "aestheticRealization": "Aesthetic realization note",
            "confidence": "STRONGLY_SUPPORTED" // or "PLAUSIBLE", "TENTATIVE"
          },
          "chhandas": {
            "meterName": "Meter name (e.g. Anuṣṭubh, Indravajrā, Vasantatilakā)",
            "syllablesPerPada": 8,
            "ganaPattern": "Gaṇa formula",
            "laghuGuruPattern": "Laghu guru pattern (। and ऽ)",
            "lakshanaAttributed": "Treatise lakṣaṇa (e.g. Vṛttaratnākara / Chhandomañjarī)",
            "confidence": "STRONGLY_SUPPORTED"
          },
          "dhvaniAndPoetics": "Dhvani, Rīti, Guṇa analysis",
          "grammaticalObservations": [
            "Grammar observation 1",
            "Grammar observation 2"
          ],
          "sourceStatus": "Verified Classical Source or Unverified User Text",
          "sourceWork": "Title of work if known",
          "sourceAuthor": "Author name if known",
          "researchSummary": {
            "strongestInterpretationSa": "Strongest interpretation in Sanskrit",
            "strongestInterpretationHi": "Strongest interpretation in Hindi",
            "strongestInterpretationEn": "Strongest interpretation in English",
            "mostUncertainClaimSa": "Most uncertain claim in Sanskrit",
            "mostUncertainClaimHi": "Most uncertain claim in Hindi",
            "mostUncertainClaimEn": "Most uncertain claim in English",
            "researchQuestionSa": "Research question in Sanskrit",
            "researchQuestionHi": "Research question in Hindi",
            "researchQuestionEn": "Research question in English",
            "expertReviewNotes": "Expert review note"
          }
        }
      """.trimIndent()

      val jsonBody = JSONObject().apply {
        put("contents", JSONArray().apply {
          put(JSONObject().apply {
            put("parts", JSONArray().apply {
              put(JSONObject().apply { put("text", "$systemPrompt\n\nVerse to analyze:\n$verse") })
            })
          })
        })
        put("generationConfig", JSONObject().apply {
          put("temperature", 0.2)
          put("responseMimeType", "application/json")
        })
      }

      val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey"
      val request = Request.Builder()
        .url(url)
        .post(jsonBody.toString().toRequestBody(JSON_MEDIA_TYPE))
        .build()

      val response = client.newCall(request).execute()
      val responseText = response.body?.string() ?: ""

      if (!response.isSuccessful) {
        Log.e(TAG, "Gemini analysis error: HTTP ${response.code} $responseText")
        return@withContext Result.failure(Exception("Gemini API error (HTTP ${response.code})"))
      }

      val json = JSONObject(responseText)
      val candidates = json.optJSONArray("candidates")
      val rawContent = candidates?.optJSONObject(0)
        ?.optJSONObject("content")
        ?.optJSONArray("parts")
        ?.optJSONObject(0)
        ?.optString("text")

      if (rawContent.isNullOrBlank()) {
        return@withContext Result.failure(Exception("Empty analysis from model."))
      }

      val cleanJson = rawContent.trim()
        .removePrefix("```json")
        .removePrefix("```")
        .removeSuffix("```")
        .trim()

      val rootObj = JSONObject(cleanJson)
      val parsed = parseVerseAnalysisJson(rootObj, verse)
      Result.success(parsed)
    } catch (e: Exception) {
      Log.e(TAG, "Exception in Gemini verse analysis", e)
      Result.failure(e)
    }
  }

  private fun parseVerseAnalysisJson(obj: JSONObject, fallbackVerse: String): VerseAnalysis {
    val origVerse = obj.optString("originalVerse", fallbackVerse)
    val transliteration = obj.optString("transliteration", "")
    val padaccheda = obj.optString("padaccheda", "")
    val anvaya = obj.optString("anvaya", "")

    val pratipadarthaList = mutableListOf<WordMeaning>()
    val pratyArray = obj.optJSONArray("pratipadartha")
    if (pratyArray != null) {
      for (i in 0 until pratyArray.length()) {
        val p = pratyArray.getJSONObject(i)
        pratipadarthaList.add(
          WordMeaning(
            word = p.optString("word", ""),
            meaningSa = p.optString("meaningSa", ""),
            meaningHi = p.optString("meaningHi", ""),
            meaningEn = p.optString("meaningEn", ""),
            grammarNote = p.optString("grammarNote", "")
          )
        )
      }
    }

    val litSa = obj.optString("literalMeaningSa", "")
    val litHi = obj.optString("literalMeaningHi", "")
    val litEn = obj.optString("literalMeaningEn", "")

    val interpSa = obj.optString("interpretiveMeaningSa", "")
    val interpHi = obj.optString("interpretiveMeaningHi", "")
    val interpEn = obj.optString("interpretiveMeaningEn", "")

    val vyakhyaSa = obj.optString("vyakhyaSa", "")
    val vyakhyaHi = obj.optString("vyakhyaHi", "")
    val vyakhyaEn = obj.optString("vyakhyaEn", "")

    val alankaraList = mutableListOf<AlankaraItem>()
    val alArray = obj.optJSONArray("alankaras")
    if (alArray != null) {
      for (i in 0 until alArray.length()) {
        val a = alArray.getJSONObject(i)
        val confStr = a.optString("confidence", "PLAUSIBLE")
        val conf = when (confStr.uppercase()) {
          "STRONGLY_SUPPORTED" -> ConfidenceLevel.STRONGLY_SUPPORTED
          "PLAUSIBLE" -> ConfidenceLevel.PLAUSIBLE
          "TENTATIVE" -> ConfidenceLevel.TENTATIVE
          else -> ConfidenceLevel.INDETERMINATE
        }
        alankaraList.add(
          AlankaraItem(
            name = a.optString("name", "अलङ्कारः"),
            evidence = a.optString("evidence", ""),
            reasoningSa = a.optString("reasoningSa", ""),
            reasoningHi = a.optString("reasoningHi", ""),
            reasoningEn = a.optString("reasoningEn", ""),
            alternatives = a.optString("alternatives", ""),
            confidence = conf
          )
        )
      }
    }

    val rasaObj = obj.optJSONObject("rasa")
    val rasa = if (rasaObj != null) {
      val confStr = rasaObj.optString("confidence", "PLAUSIBLE")
      val conf = when (confStr.uppercase()) {
        "STRONGLY_SUPPORTED" -> ConfidenceLevel.STRONGLY_SUPPORTED
        "PLAUSIBLE" -> ConfidenceLevel.PLAUSIBLE
        "TENTATIVE" -> ConfidenceLevel.TENTATIVE
        else -> ConfidenceLevel.INDETERMINATE
      }
      RasaAnalysis(
        rasaName = rasaObj.optString("rasaName", "रसः"),
        sthayibhava = rasaObj.optString("sthayibhava", ""),
        vibhavas = rasaObj.optString("vibhavas", ""),
        anubhavas = rasaObj.optString("anubhavas", ""),
        vyabhicaribhavas = rasaObj.optString("vyabhicaribhavas", ""),
        aestheticRealization = rasaObj.optString("aestheticRealization", ""),
        confidence = conf
      )
    } else {
      RasaAnalysis("शान्तरसः", "शमः", "", "", "", "", ConfidenceLevel.INDETERMINATE)
    }

    val chhandasObj = obj.optJSONObject("chhandas")
    val chhandas = if (chhandasObj != null) {
      val confStr = chhandasObj.optString("confidence", "PLAUSIBLE")
      val conf = when (confStr.uppercase()) {
        "STRONGLY_SUPPORTED" -> ConfidenceLevel.STRONGLY_SUPPORTED
        "PLAUSIBLE" -> ConfidenceLevel.PLAUSIBLE
        "TENTATIVE" -> ConfidenceLevel.TENTATIVE
        else -> ConfidenceLevel.INDETERMINATE
      }
      ChhandasIdentification(
        meterName = chhandasObj.optString("meterName", "वृत्तम्"),
        syllablesPerPada = chhandasObj.optInt("syllablesPerPada", 8),
        ganaPattern = chhandasObj.optString("ganaPattern", ""),
        laghuGuruPattern = chhandasObj.optString("laghuGuruPattern", ""),
        lakshanaAttributed = chhandasObj.optString("lakshanaAttributed", "वृत्तरत्नाकरानुसारम्"),
        confidence = conf
      )
    } else {
      ChhandasIdentification("अनुष्टुप्", 8, "", "", "", ConfidenceLevel.INDETERMINATE)
    }

    val dhvani = obj.optString("dhvaniAndPoetics", "")

    val grammarList = mutableListOf<String>()
    val gramArray = obj.optJSONArray("grammaticalObservations")
    if (gramArray != null) {
      for (i in 0 until gramArray.length()) {
        grammarList.add(gramArray.getString(i))
      }
    }

    val sourceStatus = obj.optString("sourceStatus", "प्रमाणितम् (Verified Source)")
    val sourceWork = obj.optString("sourceWork", "")
    val sourceAuthor = obj.optString("sourceAuthor", "")

    val resObj = obj.optJSONObject("researchSummary")
    val resSummary = if (resObj != null) {
      ResearchSummary(
        strongestInterpretationSa = resObj.optString("strongestInterpretationSa", ""),
        strongestInterpretationHi = resObj.optString("strongestInterpretationHi", ""),
        strongestInterpretationEn = resObj.optString("strongestInterpretationEn", ""),
        mostUncertainClaimSa = resObj.optString("mostUncertainClaimSa", ""),
        mostUncertainClaimHi = resObj.optString("mostUncertainClaimHi", ""),
        mostUncertainClaimEn = resObj.optString("mostUncertainClaimEn", ""),
        researchQuestionSa = resObj.optString("researchQuestionSa", ""),
        researchQuestionHi = resObj.optString("researchQuestionHi", ""),
        researchQuestionEn = resObj.optString("researchQuestionEn", ""),
        expertReviewNotes = resObj.optString("expertReviewNotes", "")
      )
    } else {
      ResearchSummary("", "", "", "", "", "", "", "", "", "")
    }

    return VerseAnalysis(
      id = "gemini_${System.currentTimeMillis()}",
      originalVerse = origVerse,
      transliteration = transliteration,
      padaccheda = padaccheda,
      anvaya = anvaya,
      pratipadartha = pratipadarthaList,
      literalMeaningSa = litSa,
      literalMeaningHi = litHi,
      literalMeaningEn = litEn,
      interpretiveMeaningSa = interpSa,
      interpretiveMeaningHi = interpHi,
      interpretiveMeaningEn = interpEn,
      vyakhyaSa = vyakhyaSa,
      vyakhyaHi = vyakhyaHi,
      vyakhyaEn = vyakhyaEn,
      alankaras = alankaraList,
      rasa = rasa,
      chhandas = chhandas,
      dhvaniAndPoetics = dhvani,
      grammaticalObservations = grammarList,
      sourceStatus = sourceStatus,
      sourceWork = sourceWork,
      sourceAuthor = sourceAuthor,
      researchSummary = resSummary
    )
  }
}
