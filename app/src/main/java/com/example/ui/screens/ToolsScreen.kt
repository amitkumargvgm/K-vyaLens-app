package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.util.ChhandasEngine

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToolsScreen(
  appLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  var selectedToolTab by remember { mutableIntStateOf(0) }

  val toolTabs = when (appLanguage) {
    AppLanguage.SANSKRIT -> listOf("प्रस्तार-गणकः", "सन्धि-सहायकः", "आचार्य-परम्परा", "सुभाषितम्")
    AppLanguage.HINDI -> listOf("प्रस्तार गणक", "सन्धि सहायक", "आचार्य परम्परा", "सुभाषित")
    AppLanguage.ENGLISH -> listOf("Meter Scanner", "Sandhi Guide", "Scholars Timeline", "Subhāṣita")
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
  ) {
    Spacer(modifier = Modifier.height(8.dp))

    // Tool Selector Tabs
    TabRow(
      selectedTabIndex = selectedToolTab,
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
      modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .testTag("tools_tab_row")
    ) {
      toolTabs.forEachIndexed { index, title ->
        Tab(
          selected = selectedToolTab == index,
          onClick = { selectedToolTab = index },
          text = {
            Text(
              text = title,
              fontSize = 12.sp,
              fontWeight = if (selectedToolTab == index) FontWeight.Bold else FontWeight.Normal
            )
          }
        )
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    when (selectedToolTab) {
      0 -> MeterScannerTool(lang = appLanguage)
      1 -> SandhiGuideTool(lang = appLanguage)
      2 -> AcharyaTimelineTool(lang = appLanguage)
      3 -> DailySubhashitaTool(lang = appLanguage)
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MeterScannerTool(lang: AppLanguage) {
  var scanInput by remember { mutableStateOf("वागर्थाविव सम्पृक्तौ") }
  val scannedResult = remember(scanInput) {
    ChhandasEngine.scanLine(scanInput)
  }
  val detectedMeter = remember(scanInput) {
    val padas = ChhandasEngine.scanVerseToPadas(scanInput)
    ChhandasEngine.identifyMeter(padas)
  }

  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(14.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Calculate, contentDescription = "Scan", tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = when (lang) {
                AppLanguage.SANSKRIT -> "लघु-गुरु प्रस्तार-गणकः (Live Meter Scanner)"
                AppLanguage.HINDI -> "लघु-गुरु प्रस्तार गणक (लाइव छन्द स्कैनर)"
                AppLanguage.ENGLISH -> "Live Laghu-Guru Scansion & Meter Scanner"
              },
              fontWeight = FontWeight.Bold,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          OutlinedTextField(
            value = scanInput,
            onValueChange = { scanInput = it },
            placeholder = { Text("अत्र पादं लिखतु (उदा. कश्चित्कान्ताविरहगुरुणा)") },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("meter_scanner_input"),
            shape = RoundedCornerShape(10.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "कुल-अक्षराणि: ${scannedResult.size}",
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp,
              color = MaterialTheme.colorScheme.secondary
            )
            Text(
              text = "अनुमानित-छन्दः: $detectedMeter",
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              color = MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Scanned Units Visualizer
          Text(
            text = "प्रस्तार-खण्डानि (Laghu | / Guru ऽ Breakdown):",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(8.dp))

          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            scannedResult.forEachIndexed { i, syl ->
              Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                  .clip(RoundedCornerShape(8.dp))
                  .background(
                    if (syl.isGuru) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                    else MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f)
                  )
                  .border(
                    0.8.dp,
                    if (syl.isGuru) MaterialTheme.colorScheme.primary.copy(alpha = 0.45f)
                    else MaterialTheme.colorScheme.secondary.copy(alpha = 0.45f),
                    RoundedCornerShape(8.dp)
                  )
                  .padding(horizontal = 8.dp, vertical = 4.dp)
              ) {
                Text(
                  text = syl.symbol,
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Bold,
                  color = if (syl.isGuru) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                  fontFamily = FontFamily.Monospace
                )
                Text(
                  text = syl.akshara,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.SemiBold
                )
                Text(
                  text = if (syl.isGuru) "गुरु (२)" else "लघु (१)",
                  fontSize = 9.sp,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (syl.ganaName.isNotEmpty()) {
                  Text(
                    text = syl.ganaName,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary
                  )
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun SandhiGuideTool(lang: AppLanguage) {
  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(12.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(14.dp)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "संस्कृत-सन्धि-नियमावली (Sandhi Guide)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(10.dp))

          SandhiRuleItem(
            ruleName = "दीर्घसन्धिः (अकः सवर्णे दीर्घः)",
            formula = "अ/आ + अ/आ = आ; इ/ई + इ/ई = ई; उ/ऊ + उ/ऊ = ऊ",
            example = "विद्या + आलयः = विद्यालयः; गिरि + ईशः = गिरीशः"
          )
          SandhiRuleItem(
            ruleName = "गुणसन्धिः (आद्गुणः)",
            formula = "अ/आ + इ/ई = ए; अ/आ + उ/ऊ = ओ; अ/आ + ऋ = अर्",
            example = "नर + ईशः = नरेशः; सूर्य + उदयः = सूर्योदयः; महा + ऋषिः = महर्षिः"
          )
          SandhiRuleItem(
            ruleName = "वृद्धिसन्धिः (वृद्धिरेचि)",
            formula = "अ/आ + ए/ऐ = ऐ; अ/आ + ओ/औ = औ",
            example = "सदा + एव = सदैव; जल + ओघः = जलौघः"
          )
          SandhiRuleItem(
            ruleName = "यण्सन्धिः (इको यणचि)",
            formula = "इ/ई + स्वर = य्; उ/ऊ + स्वर = व्; ऋ + स्वर = र्",
            example = "यदि + अपि = यद्यपि; सु + आगतम् = स्वागतम्"
          )
          SandhiRuleItem(
            ruleName = "अयादिसन्धिः (एचोऽयवायावः)",
            formula = "ए = अय्, ऐ = आय्, ओ = अव्, औ = आव्",
            example = "ने + अनम् = नयनम्; पौ + अकः = पावकः"
          )
        }
      }
    }
  }
}

@Composable
fun SandhiRuleItem(ruleName: String, formula: String, example: String) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp)
      .clip(RoundedCornerShape(8.dp))
      .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
      .padding(10.dp)
  ) {
    Column {
      Text(text = ruleName, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
      Spacer(modifier = Modifier.height(2.dp))
      Text(text = "नियमः: $formula", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
      Text(text = "उदाहरणम्: $example", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.secondary)
    }
  }
}

@Composable
fun AcharyaTimelineTool(lang: AppLanguage) {
  val acharyas = listOf(
    Triple("भरतमुनिः (ई० पूर्व २ शता०)", "नाट्यशास्त्रम्", "रससिद्धान्तस्य मूलप्रवर्तकः, रससूत्रस्य प्रणेता"),
    Triple("भामहः (६ शता०)", "काव्यालङ्कारः", "अलङ्कारसम्प्रदायस्य संस्थापकः ('शब्दार्थौ सहितौ काव्यम्')"),
    Triple("दण्डी (७ शता०)", "काव्यादर्शः", "रीति-अलङ्कारयोः विशदं प्रतिपादनम्"),
    Triple("वामनः (८ शता०)", "काव्यालङ्कारसूत्रवृत्तिः", "रीतिसम्प्रदायस्य प्रणेता ('रीतिरात्मा काव्यस्य')"),
    Triple("आनन्दवर्धनः (९ शता०)", "ध्वन्यालोकः", "ध्वनिसिद्धान्तस्य प्रवर्तकः ('काव्यस्यात्मा ध्वनिः')"),
    Triple("अभिनवगुप्तः (१० शता०)", "लोचनटीका व अभिनवभारती", "रसध्वनेः रसनिष्पत्तेश्च (अभिव्यक्तिवादस्य) परमव्याख्याकारः"),
    Triple("कुन्तकः (१० शता०)", "वक्रोक्तिजीवितम्", "वक्रोक्तिसिद्धान्तस्य प्रतिष्ठापकः ('वक्रोक्तिः काव्यजीवितम्')"),
    Triple("क्षेमेन्द्रः (११ शता०)", "औचित्यविचारचर्चा", "औचित्यसिद्धान्तस्य उद्भावकः ('औचित्यं रससिद्धस्य स्थिरं काव्यस्य जीवितम्')"),
    Triple("मम्मटभट्टः (११ शता०)", "काव्यप्रकाशः", "काव्यशास्त्रस्य प्रामाणिकः समन्वयकः, ध्वनिप्रतिष्ठापकः"),
    Triple("विश्वनाथकविराजः (१४ शता०)", "साहित्यदर्पणः", "रसध्वनेः मूर्धन्यव्याख्याकारः ('वाक्यं रसात्मकं काव्यम्')"),
    Triple("पण्डितराज-जगन्नाथः (१७ शता०)", "रसगङ्गाधरः", "प्रौढालङ्कारिकः ('रमणीयार्थप्रतिपादकः शब्दः काव्यम्')")
  )

  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    items(acharyas.size) { i ->
      val (name, work, contribution) = acharyas[i]
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = work, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary)
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = contribution, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
      }
    }
  }
}

@Composable
fun DailySubhashitaTool(lang: AppLanguage) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    shape = RoundedCornerShape(14.dp)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.FormatQuote, contentDescription = "Subhashita", tint = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "दैनिक-सुभाषितम् (Verse of Wisdom)",
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.primary
        )
      }
      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "क्षणशः कणशश्चैव विद्यामर्थं च साधयेत्।\nक्षणत्यागे कुतो विद्या कणत्यागे कुतो धनम्॥",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        lineHeight = 24.sp
      )

      HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

      Text(
        text = "अन्वयः: क्षणशः एव विद्यां, कणशः एव च अर्थं साधयेत्; क्षणत्यागे विद्या कुतः? कणत्यागे धनं कुतः?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = when (lang) {
          AppLanguage.SANSKRIT -> "भावार्थः: प्रत्येकं क्षणस्य सदुपयोगेन विद्या, प्रत्येकं कणस्य सञ्चयेन च धनं सिध्यति। समयनाशे विद्या न लभ्यते, कणनाशे च धनं न तिष्ठति।"
          AppLanguage.HINDI -> "भावार्थ: एक-एक क्षण से विद्या और एक-एक कण के संचय से धन प्राप्त होता है। क्षण गँवाने पर विद्या कहाँ और कण नष्ट करने पर धन कहाँ?"
          AppLanguage.ENGLISH -> "Meaning: Knowledge must be acquired moment by moment, and wealth accumulated particle by particle. If you squander moments, where is learning? If you waste particles, where is wealth?"
        },
        fontSize = 13.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        lineHeight = 20.sp
      )
    }
  }
}
