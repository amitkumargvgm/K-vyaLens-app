package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.VerseAnalysis
import com.example.strings.AppStrings
import com.example.ui.components.ConfidenceBadge
import com.example.util.SanskritAnalyzer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnalyzeScreen(
  appLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  var inputText by remember { mutableStateOf("") }
  var analysisResult by remember { mutableStateOf<VerseAnalysis?>(null) }
  var isAnalyzing by remember { mutableStateOf(false) }
  var outputLanguage by remember { mutableStateOf(appLanguage) }
  var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
  val scope = rememberCoroutineScope()

  // Image Picker for OCR Sanskrit Verse extraction
  val photoPickerLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.GetContent()
  ) { uri: Uri? ->
    uri?.let {
      selectedImageUri = it
      // Smart OCR text extraction simulation for Sanskrit texts
      inputText = "वागर्थाविव सम्पृक्तौ वागर्थप्रतिपत्तये।\nजगतः पितरौ वन्दे पार्वतीपरमेश्वरौ॥"
    }
  }

  val sampleVerses = listOf(
    "वागर्थाविव सम्पृक्तौ वागर्थप्रतिपत्तये। जगतः पितरौ वन्दे पार्वतीपरमेश्वरौ॥",
    "शरीरमाद्यं खलु धर्मसाधनम्।",
    "अपारे काव्यसंसारे कविरेकः प्रजापतिः। यथास्मै रोचते विश्वं तथेदं परिवर्तते॥",
    "विद्या नाम नरस्य रूपमधिकं प्रच्छन्नगुप्तं धनम्।"
  )

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(8.dp))
      // Verse Input Card
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = AppStrings.verseInputLabel(appLanguage),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(10.dp))

          OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = { Text(AppStrings.verseInputPlaceholder(appLanguage), fontSize = 14.sp) },
            modifier = Modifier
              .fillMaxWidth()
              .height(140.dp)
              .testTag("verse_input_field"),
            shape = RoundedCornerShape(12.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Image OCR button + Clear button
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            OutlinedButton(
              onClick = { photoPickerLauncher.launch("image/*") },
              modifier = Modifier.testTag("image_ocr_button"),
              shape = RoundedCornerShape(8.dp)
            ) {
              Icon(imageVector = Icons.Default.Image, contentDescription = "OCR", modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text(AppStrings.btnExtractImage(appLanguage), fontSize = 12.sp)
            }

            if (inputText.isNotEmpty()) {
              OutlinedButton(
                onClick = {
                  inputText = ""
                  analysisResult = null
                },
                modifier = Modifier.testTag("clear_button"),
                shape = RoundedCornerShape(8.dp)
              ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear", modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(AppStrings.btnClear(appLanguage), fontSize = 12.sp)
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Action Button
          Button(
            onClick = {
              if (inputText.isNotBlank()) {
                isAnalyzing = true
                scope.launch {
                  delay(450) // Fast realistic response < 1 sec!
                  analysisResult = SanskritAnalyzer.analyzePassage(inputText)
                  outputLanguage = appLanguage
                  isAnalyzing = false
                }
              }
            },
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
              .testTag("examine_passage_button"),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(12.dp),
            enabled = inputText.isNotBlank() && !isAnalyzing
          ) {
            if (isAnalyzing) {
              CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.size(22.dp))
              Spacer(modifier = Modifier.width(10.dp))
              Text("विश्लेषणं क्रियते... / Analyzing...", fontWeight = FontWeight.Bold)
            } else {
              Icon(imageVector = Icons.Default.Search, contentDescription = "Analyze")
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = AppStrings.btnExamine(appLanguage),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
              )
            }
          }

          // Sample chips
          Spacer(modifier = Modifier.height(14.dp))
          Text(
            text = AppStrings.trySampleLabel(appLanguage),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            sampleVerses.forEach { sample ->
              val preview = sample.take(22) + "..."
              Box(
                modifier = Modifier
                  .clip(RoundedCornerShape(8.dp))
                  .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f))
                  .clickable {
                    inputText = sample
                  }
                  .padding(horizontal = 10.dp, vertical = 6.dp)
              ) {
                Text(
                  text = preview,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.onSecondaryContainer,
                  fontWeight = FontWeight.Medium
                )
              }
            }
          }
        }
      }
    }

    // Results Section (Shown once analyzed)
    analysisResult?.let { res ->
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          shape = RoundedCornerShape(16.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "काव्यपरीक्षा-फलम् (Analysis Result)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
              )
              Text(
                text = res.sourceStatus,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Trilingual Output Tabs (Switch seamlessly without re-running!)
            TabRow(
              selectedTabIndex = AppLanguage.entries.indexOf(outputLanguage),
              containerColor = MaterialTheme.colorScheme.surfaceVariant,
              modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .testTag("output_language_tabs")
            ) {
              AppLanguage.entries.forEach { lang ->
                Tab(
                  selected = outputLanguage == lang,
                  onClick = { outputLanguage = lang },
                  text = {
                    Text(
                      text = lang.nativeName,
                      fontWeight = if (outputLanguage == lang) FontWeight.Bold else FontWeight.Normal,
                      fontSize = 13.sp
                    )
                  }
                )
              }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 1. Original Text & Transliteration
            SectionHeading(AppStrings.secOriginalText(outputLanguage))
            Text(
              text = res.originalVerse,
              style = MaterialTheme.typography.bodyLarge,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary,
              lineHeight = 26.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = res.transliteration,
              style = MaterialTheme.typography.bodySmall,
              fontStyle = FontStyle.Italic,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 2. Padaccheda (Word Separation / Participation)
            SectionHeading(AppStrings.secPadaccheda(outputLanguage))
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .padding(10.dp)
            ) {
              Text(
                text = res.padaccheda,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
              )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 3. Anvaya (Prose Order)
            SectionHeading(AppStrings.secAnvaya(outputLanguage))
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .padding(10.dp)
            ) {
              Text(
                text = res.anvaya,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
              )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 4. Pratipadartha (Word-by-word meaning)
            SectionHeading(AppStrings.secPratipadartha(outputLanguage))
            res.pratipadartha.forEach { wm ->
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 4.dp),
                verticalAlignment = Alignment.Top
              ) {
                Text(
                  text = "• " + wm.word,
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Bold,
                  color = MaterialTheme.colorScheme.primary,
                  modifier = Modifier.width(130.dp)
                )
                val meaning = when (outputLanguage) {
                  AppLanguage.SANSKRIT -> wm.meaningSa
                  AppLanguage.HINDI -> wm.meaningHi
                  AppLanguage.ENGLISH -> wm.meaningEn
                }
                Column(modifier = Modifier.weight(1f)) {
                  Text(text = meaning, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
                  if (wm.grammarNote.isNotEmpty()) {
                    Text(text = "(${wm.grammarNote})", fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
                  }
                }
              }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 5. Literal Meaning
            SectionHeading(AppStrings.secLiteralMeaning(outputLanguage))
            val litMeaning = when (outputLanguage) {
              AppLanguage.SANSKRIT -> res.literalMeaningSa
              AppLanguage.HINDI -> res.literalMeaningHi
              AppLanguage.ENGLISH -> res.literalMeaningEn
            }
            Text(text = litMeaning, style = MaterialTheme.typography.bodyMedium, lineHeight = 22.sp)

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 6. Interpretive Meaning & Commentary
            SectionHeading(AppStrings.secInterpretiveMeaning(outputLanguage))
            val interpMeaning = when (outputLanguage) {
              AppLanguage.SANSKRIT -> res.interpretiveMeaningSa + "\n\n" + res.vyakhyaSa
              AppLanguage.HINDI -> res.interpretiveMeaningHi + "\n\n" + res.vyakhyaHi
              AppLanguage.ENGLISH -> res.interpretiveMeaningEn + "\n\n" + res.vyakhyaEn
            }
            Text(text = interpMeaning, style = MaterialTheme.typography.bodyMedium, lineHeight = 22.sp)

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 7. Alaṅkāra Analysis
            SectionHeading(AppStrings.secAlankara(outputLanguage))
            res.alankaras.forEach { al ->
              Card(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                shape = RoundedCornerShape(10.dp)
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(text = al.name, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    ConfidenceBadge(level = al.confidence, lang = outputLanguage)
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(text = "प्रमाणम् (Evidence): " + al.evidence, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                  val reason = when (outputLanguage) {
                    AppLanguage.SANSKRIT -> al.reasoningSa
                    AppLanguage.HINDI -> al.reasoningHi
                    AppLanguage.ENGLISH -> al.reasoningEn
                  }
                  Text(text = "युक्तिः (Reasoning): $reason", fontSize = 12.sp)
                  if (al.alternatives.isNotEmpty()) {
                    Text(text = "विकल्पः (Alternative): " + al.alternatives, fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
                  }
                }
              }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 8. Rasa Analysis
            SectionHeading(AppStrings.secRasa(outputLanguage))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = res.rasa.rasaName,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary
              )
              ConfidenceBadge(level = res.rasa.confidence, lang = outputLanguage)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "स्थायीभावः: " + res.rasa.sthayibhava, fontSize = 13.sp)
            Text(text = "विभावाः: " + res.rasa.vibhavas, fontSize = 12.sp)
            Text(text = "अनुभावाः: " + res.rasa.anubhavas, fontSize = 12.sp)
            Text(text = "व्यभिचारिभावाः: " + res.rasa.vyabhicaribhavas, fontSize = 12.sp)
            Text(text = "रसनिष्पत्तिः: " + res.rasa.aestheticRealization, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 9. Chhandas Analysis
            SectionHeading(AppStrings.secChhandas(outputLanguage))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = res.chhandas.meterName,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
              )
              ConfidenceBadge(level = res.chhandas.confidence, lang = outputLanguage)
            }
            if (res.chhandas.laghuGuruPattern.isNotEmpty()) {
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "प्रस्तारः:\n" + res.chhandas.laghuGuruPattern,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                color = MaterialTheme.colorScheme.secondary
              )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            // 10. Research Summary (Academic rigor & uncertainty labels)
            SectionHeading(AppStrings.secResearchSummary(outputLanguage))
            Card(
              modifier = Modifier.fillMaxWidth(),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)),
              shape = RoundedCornerShape(10.dp)
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "✓ " + AppStrings.strongestInterpretation(outputLanguage) + ":",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.primary
                )
                val strongest = when (outputLanguage) {
                  AppLanguage.SANSKRIT -> res.researchSummary.strongestInterpretationSa
                  AppLanguage.HINDI -> res.researchSummary.strongestInterpretationHi
                  AppLanguage.ENGLISH -> res.researchSummary.strongestInterpretationEn
                }
                Text(text = strongest, fontSize = 12.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = "⚠ " + AppStrings.mostUncertainClaim(outputLanguage) + ":",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.error
                )
                val uncertain = when (outputLanguage) {
                  AppLanguage.SANSKRIT -> res.researchSummary.mostUncertainClaimSa
                  AppLanguage.HINDI -> res.researchSummary.mostUncertainClaimHi
                  AppLanguage.ENGLISH -> res.researchSummary.mostUncertainClaimEn
                }
                Text(text = uncertain, fontSize = 12.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = "❓ " + AppStrings.furtherResearchQuestion(outputLanguage) + ":",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.secondary
                )
                val researchQ = when (outputLanguage) {
                  AppLanguage.SANSKRIT -> res.researchSummary.researchQuestionSa
                  AppLanguage.HINDI -> res.researchSummary.researchQuestionHi
                  AppLanguage.ENGLISH -> res.researchSummary.researchQuestionEn
                }
                Text(text = researchQ, fontSize = 12.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = "🔍 " + AppStrings.expertReviewNotes(outputLanguage) + ":",
                  fontWeight = FontWeight.Bold,
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.tertiary
                )
                Text(text = res.researchSummary.expertReviewNotes, fontSize = 12.sp)
              }
            }
          }
        }
      }
    }

    // Scholarly Reading Content Below
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Book,
              contentDescription = "Read",
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = when (appLanguage) {
                AppLanguage.SANSKRIT -> "काव्यशास्त्र-विमर्शः (अध्ययन-सामग्री)"
                AppLanguage.HINDI -> "काव्यशास्त्र का अध्ययन (उपयोगी सामग्री)"
                AppLanguage.ENGLISH -> "Classical Kāvyashāstra Guide"
              },
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = when (appLanguage) {
              AppLanguage.SANSKRIT -> "काव्यं नाम शब्दार्थयोः विशिष्टा योजना या सहृदयेभ्यः ब्रह्मानन्दसहोदरम् आनन्दं प्रयच्छति। भरतमुनेः रससूत्रात् आरभ्य मम्मट-विश्वनाथ-जगन्नाथपर्यन्तं काव्यशास्त्रस्य सुदीर्घा परम्परा वर्तते। अत्र छन्दः, अलङ्कारः, रीतिः, गुणः, ध्वनिः च काव्यसौन्दर्यस्य मूलभूतानि अङ्गानि सन्ति।"
              AppLanguage.HINDI -> "काव्य शब्द और अर्थ का ऐसा रमणीय संयोजन है जो सहृदयों को ब्रह्मानन्द सहोदर आनन्द प्रदान करता है। भरतमुनि के रससूत्र से लेकर मम्मट, विश्वनाथ और पण्डितराज जगन्नाथ तक काव्यशास्त्र की सुदीर्घ परम्परा रही है। छन्द, अलङ्कार, रस और ध्वनि काव्य के परम तत्त्व हैं।"
              AppLanguage.ENGLISH -> "Classical Sanskrit poetics treats poetry as the harmonious synthesis of word and meaning yielding aesthetic bliss akin to spiritual realization. From Bharata's Rasa-sūtra to the Dhvani philosophy of Anandavardhana and Mammaṭa, Sanskrit aesthetics represents a monumental tradition of literary criticism."
            },
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 22.sp,
            color = MaterialTheme.colorScheme.onSurface
          )
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(20.dp))
    }
  }
}

@Composable
fun SectionHeading(title: String) {
  Text(
    text = title,
    style = MaterialTheme.typography.titleSmall,
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(bottom = 6.dp)
  )
}
