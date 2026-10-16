package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
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
    AppLanguage.SANSKRIT -> listOf("प्रस्तार-गणकः", "सन्धि-कोशः", "समास-दर्पणः", "काव्य-दोषाः", "सुभाषित-रत्नकोशः", "आचार्य-परम्परा")
    AppLanguage.HINDI -> listOf("प्रस्तार गणक", "सन्धि कोश", "समास दर्पण", "काव्य दोष", "सुभाषित रत्नकोश", "आचार्य परम्परा")
    AppLanguage.ENGLISH -> listOf("Meter Scanner", "Sandhi Guide", "Samāsa Guide", "Poetic Defects", "Subhāṣita Treasury", "Scholars Timeline")
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 14.dp)
  ) {
    Spacer(modifier = Modifier.height(8.dp))

    // Scrollable Tool Tabs
    ScrollableTabRow(
      selectedTabIndex = selectedToolTab,
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
      edgePadding = 8.dp,
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

    Spacer(modifier = Modifier.height(12.dp))

    when (selectedToolTab) {
      0 -> MeterScannerTool(lang = appLanguage)
      1 -> SandhiGuideTool(lang = appLanguage)
      2 -> SamasaGuideTool(lang = appLanguage)
      3 -> KavyaDoshaTool(lang = appLanguage)
      4 -> SubhashitaTreasuryTool(lang = appLanguage)
      5 -> AcharyaTimelineTool(lang = appLanguage)
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

          Spacer(modifier = Modifier.height(10.dp))

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

    item {
      // Theoretical Gana Table Reference (यमाताराजभानसलगाम्)
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(14.dp)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "पिङ्गल-अष्टगण-तालिका (सूत्रम्: य-मा-ता-रा-ज-भा-न-स-ल-गम्)",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(8.dp))

          val ganas = listOf(
            Triple("यगणः (य)", "। ऽ ऽ (आदिलघु)", "यमाता (उदा. मयूरः)"),
            Triple("मगणः (म)", "ऽ ऽ ऽ (सर्वगुरु)", "मातारा (उदा. गङ्गायाः)"),
            Triple("तगणः (त)", "ऽ ऽ । (अन्तलघु)", "ताराज (उदा. संसारः)"),
            Triple("रगणः (र)", "ऽ । ऽ (मध्यलघु)", "राजभा (उदा. पावकः)"),
            Triple("जगणः (ज)", "। ऽ । (मध्यगुरु)", "जभान (उदा. रमेशः)"),
            Triple("भगणः (भ)", "ऽ । । (आदिगुरु)", "भानस (उदा. भारतम्)"),
            Triple("नगणः (न)", "। । । (सर्वलघु)", "नसला (उदा. नयनम्)"),
            Triple("सगणः (स)", "। । ऽ (अन्तगुरु)", "सलगा (उदा. करुणा)")
          )

          ganas.forEach { (name, pattern, mnemonic) ->
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Text(text = name, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
              Text(text = pattern, fontSize = 12.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.SemiBold)
              Text(text = mnemonic, fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
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
    verticalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    item {
      Text(
        text = "संस्कृत-सन्धि-नियमावली (सविस्तरम्)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
      )
    }

    item {
      SandhiCategoryCard(
        categoryTitle = "१. अच्-सन्धिः (स्वर-सन्धिः)",
        rules = listOf(
          Triple("दीर्घसन्धिः (अकः सवर्णे दीर्घः)", "अ/आ + अ/आ = आ; इ/ई + इ/ई = ई; उ/ऊ + उ/ऊ = ऊ", "विद्या + आलयः = विद्यालयः; गिरि + ईशः = गिरीशः; भानु + उदयः = भानूदयः"),
          Triple("गुणसन्धिः (आद्गुणः)", "अ/आ + इ/ई = ए; अ/आ + उ/ऊ = ओ; अ/आ + ऋ = अर्", "नर + ईशः = नरेशः; सूर्य + उदयः = सूर्योदयः; महा + ऋषिः = महर्षिः"),
          Triple("वृद्धिसन्धिः (वृद्धिरेचि)", "अ/आ + ए/ऐ = ऐ; अ/आ + ओ/औ = औ", "सदा + एव = सदैव; जल + ओघः = जलौघः; महा + औषधम् = महौषधम्"),
          Triple("यण्सन्धिः (इको यणचि)", "इ/ई + स्वर = य्; उ/ऊ + स्वर = व्; ऋ + स्वर = र्", "यदि + अपि = यद्यपि; सु + आगतम् = स्वागतम्; पितृ + आज्ञा = पित्राज्ञा"),
          Triple("अयादिसन्धिः (एचोऽयवायावः)", "ए = अय्, ऐ = आय्, ओ = अव्, औ = आव्", "ने + अनम् = नयनम्; गै + अकः = गायकः; पो + अनः = पवनः; पौ + अकः = पावकः"),
          Triple("पूर्वरूपसन्धिः (एङः पदान्तादति)", "पदान्त-ए/ओ + अ = एऽ / ओऽ (अवग्रहः)", "हरे + अव = हरेऽव; प्रभो + अनुगृह्ण = प्रभोऽनुगृह्ण")
        )
      )
    }

    item {
      SandhiCategoryCard(
        categoryTitle = "२. हल्-सन्धिः (व्यञ्जन-सन्धिः)",
        rules = listOf(
          Triple("श्चुत्वसन्धिः (स्तोः श्चुना श्चुः)", "स्/त्-वर्ग + श्/च्-वर्ग = श्/च्-वर्ग", "सत् + चित् = सच्चित्; रामस् + शेते = रामश्शेते; कश्चित् = कस् + चित्"),
          Triple("ष्टुत्वसन्धिः (ष्टुना ष्टुः)", "स्/त्-वर्ग + ष्/ट्-वर्ग = ष्/ट्-वर्ग", "रामस् + टीकते = रामष्टीकते; तत् + टीका = तट्टीका"),
          Triple("जश्त्वसन्धिः (झलां जशोऽन्ते)", "झल् (१, २, ३, ४ व्यञ्जन) = तृतीयवर्ण (ज्, ब्, ग्, ड्, द्)", "वाक् + ईशः = वागीशः; जगत् + ईशः = जगदीशः; अच् + अन्तः = अजन्तः"),
          Triple("चर्वसन्धिः (खरि च)", "झल् + खर् (कर्कशव्यञ्जन) = प्रथमवर्ण (क्, च्, ट्, त्, प्)", "सद् + कारः = सत्कारः; उद् + पन्नः = उत्पन्नः"),
          Triple("अनुस्वारसन्धिः (मोऽनुस्वारः)", "पदान्त-म् + व्यञ्जन = अनुस्वारः (ं)", "हरिम् + वन्दे = हरिं वन्दे; सत्यम् + वद = सत्यं वद")
        )
      )
    }

    item {
      SandhiCategoryCard(
        categoryTitle = "३. विसर्ग-सन्धिः",
        rules = listOf(
          Triple("सत्वसन्धिः (विसर्जनीयस्य सः)", "विसर्ग + च्/छ् = श्; ट्/ठ् = ष्; त्/थ् = स्", "कः + चित् = कश्चित्; धनुः + टङ्कारः = धनुष्टङ्कारः; इतः + ततः = इतस्ततः"),
          Triple("उत्वसन्धिः (अतो रोरप्लुतादप्लुते)", "अ + ः + अ = ओऽ; अ + ः + मृदुव्यञ्जन = ओ", "शिवः + अर्च्यः = शिवोऽर्च्यः; रामः + गच्छति = रामो गच्छति; मनः + हरः = मनोहरः"),
          Triple("रुत्वसन्धिः (ससजुषो रुः)", "अ/आ विहाय स्वर + ः + स्वर/मृदु = र्", "मुनिः + अयम् = मुनिरयम्; गुरुः + आज्ञा = गुरुराज्ञा; हरिः + गच्छति = हरिर्गच्छति"),
          Triple("विसर्गलोपः (भोभगोअघोअपूर्वस्य...)", "आ + ः + स्वर/मृदु = लोपः", "देवाः + नमन्ति = देवा नमन्ति; सूर्यः + उदेति = सूर्य उदेति")
        )
      )
    }

    item {
      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

@Composable
fun SandhiCategoryCard(categoryTitle: String, rules: List<Triple<String, String, String>>) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    shape = RoundedCornerShape(12.dp)
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Text(text = categoryTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
      Spacer(modifier = Modifier.height(8.dp))
      rules.forEach { (name, formula, example) ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
            .padding(8.dp)
        ) {
          Column {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = "नियमः: $formula", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface)
            Text(text = "उदा.: $example", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.secondary)
          }
        }
      }
    }
  }
}

@Composable
fun SamasaGuideTool(lang: AppLanguage) {
  val samasas = listOf(
    Pair("अव्ययीभावः (पूर्वपदार्थप्रधानः)", "यत्र प्रथमं पदम् अव्ययं प्रधानं च भवति। उदा.: उपगङ्गम् (गङ्गायाः समीपे), प्रतिदिनम् (दिनं दिनं प्रति), यथाशक्ति (शक्तिम् अनतिक्रम्य)।"),
    Pair("तत्पुरुषः (उत्तरपदार्थप्रधानः)", "यत्र द्वितीयं पदं प्रधानं भवति। भेदाः: द्वितीयादि-सप्तमी-तत्पुरुषाः, नञ्-तत्पुरुषः (अब्राह्मणः), उपपद-तत्पुरुषः (कुम्भकारः)। उदा.: राजपुरुषः (राज्ञः पुरुषः), विद्यालयः (विद्यायाः आलयः)।"),
    Pair("कर्मधारयः (समानाधिकरण-तत्पुरुषः)", "यत्र विशेषण-विशेष्ययोः अथवा उपमान-उपमेययोः समासः। उदा.: नीलोत्पलम् (नीलं च तत् उत्पलम्), मुखकमलम् (मुखम् एव कमलम्), घनश्यामः (घन इव श्यामः)।"),
    Pair("द्विगुः (सङ्ख्यापूर्वो द्विगुः)", "यत्र पूर्वपदं सङ्ख्यावाचकं समाहारं च बोधयति। उदा.: पञ्चवटी (पञ्चानां वटानां समाहारः), त्रिभुवनम् (त्रयाणां भुवनानां समाहारः), त्रिफला।"),
    Pair("द्वन्द्वः (उभयपदार्थप्रधानः)", "यत्र सर्वेषां पदानाम् अर्थः समः प्रधानश्च भवति ('चार्थे द्वन्द्वः')। भेदाः: इतरेतरः (मातापितरौ, पार्वतीपरमेश्वरौ), समाहारः (पाणिपादम्), एकशेषः (पितरौ)।"),
    Pair("बहुव्रीहिः (अन्यपदार्थप्रधानः)", "यत्र पदद्वयं विहाय तृतीयस्य अन्यस्य पदार्थस्य प्राधान्यं भवति। उदा.: पीताम्बरः (पीतमम्बरं यस्य सः विष्णुः), दशाननः (दश आननानि यस्य सः रावणः), लम्बोधरः (गणेशः)।")
  )

  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    item {
      Text(
        text = "षट्-समास-मार्गदर्शिका (Classical Sanskrit Compounds)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
      )
    }

    items(samasas) { (name, desc) ->
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(text = name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = desc, fontSize = 12.sp, lineHeight = 20.sp, color = MaterialTheme.colorScheme.onSurface)
        }
      }
    }
  }
}

@Composable
fun KavyaDoshaTool(lang: AppLanguage) {
  val doshas = listOf(
    Pair("पददोषाः (Word Defects)", "१. श्रुतिकटु (कर्णकटु वर्णसंयोगः), २. च्युतसंस्कृति (व्याकरणभ्रष्टता), ३. अप्रयुक्त (कोशमात्रगतः), ४. असमर्थ (अर्थासमर्थः), ५. निहतार्थ (प्रसिद्धार्थत्यागः), ६. अश्लील (लज्जाजुगुप्साजनकः)।"),
    Pair("वाक्यदोषाः (Sentence Defects)", "१. प्रतिकूलवर्ण (रसाविपरीतवर्णरचना), २. हतवृत्त (छन्दोलक्षणभङ्गः), ३. पतत्प्रकर्ष (उत्साहस्य ह्रासः), ४. समाप्तपुनरात्त (समाप्तवाक्ये पुनः विशेषणयोजनम्)।"),
    Pair("अर्थदोषाः (Meaning Defects)", "१. अपुष्टार्थ (व्यर्थविशेषणम्), २. कष्टार्थ (दुर्बोधार्थः), ३. व्याहत (परस्परविरोधी), ४. पुनरुक्त (व्यर्था पुनरुक्तिः), ५. सहचरभिन्न (अनुचितसंयोगः)।"),
    Pair("रसदोषाः (Aesthetic Defects)", "व्यभिचारिरसस्थायिभावानां शब्दवाच्यता; अनौचित्यप्रवर्तनम्; रसस्य अकारणविच्छेदः; अप्रकृतस्य रसस्य अङ्गत्वम्।")
  )

  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    item {
      Text(
        text = "काव्यप्रकाशोक्ताः काव्यदोषाः (Mammaṭa's Poetic Defects)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
      )
    }

    items(doshas) { (name, desc) ->
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Text(text = name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MaterialTheme.colorScheme.error)
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = desc, fontSize = 12.sp, lineHeight = 20.sp, color = MaterialTheme.colorScheme.onSurface)
        }
      }
    }
  }
}

@Composable
fun SubhashitaTreasuryTool(lang: AppLanguage) {
  val subhashitas = listOf(
    SubhashitaItem(
      verse = "उद्यमेन हि सिध्यन्ति कार्याणि न मनोरथैः।\nन हि सुप्तस्य सिंहस्य प्रविशन्ति मुखे मृगाः॥",
      source = "हितोपदेशे (मित्रलाभः)",
      meaningSa = "परिश्रमेणैव कार्याणां सिद्धिर्भवति, केवलसङ्कल्पेन नहि; सुप्तस्य सिंहस्य मुखे मृगाः स्वयं न प्रविशन्ति।",
      meaningHi = "परिश्रम से ही कार्य सिद्ध होते हैं, केवल इच्छा करने से नहीं; सोये हुए सिंह के मुख में हिरण स्वयं प्रवेश नहीं करते।",
      meaningEn = "Tasks are accomplished by exertion, not mere wishful thinking; prey does not walk of its own accord into the mouth of a slumbering lion."
    ),
    SubhashitaItem(
      verse = "पृथिव्यां त्रीणि रत्नानि जलमन्नं सुभाषितम्।\nमूढैः पाषाणखण्डेषु रत्नसंज्ञा विधीयते॥",
      source = "सुभाषितरत्नभाण्डागारम्",
      meaningSa = "पृथिव्यां जलम्, अन्नं, सुभाषितं चेति त्रीण्येव यथार्थरत्नानि सन्ति; अज्ञानात् पाषाणखण्डेषु रत्नशब्दः प्रयुज्यते।",
      meaningHi = "पृथ्वी पर जल, अन्न और सुभाषित—ये तीन ही सच्चे रत्न हैं; मूर्ख लोग पत्थर के टुकड़ों (हीरे आदि) को रत्न कहते हैं।",
      meaningEn = "There are only three true jewels upon this earth: water, grain, and wise counsel. Fools bestow the name of gem upon mere fragments of rock."
    ),
    SubhashitaItem(
      verse = "यथा ह्येकेन चक्रेण न रथस्य गतिर्भवेत्।\nएवं पुरुषकारेण विना दैवं न सिध्यति॥",
      source = "हितोपदेशे / पञ्चतन्त्रे",
      meaningSa = "यथा एकेन चक्रेण रथः न चलति, तथैव मानुषपरिश्रमं विना केवलभाग्येन किमपि न सिध्यति।",
      meaningHi = "जैसे एक पहिये से रथ नहीं चल सकता, उसी प्रकार बिना पुरुषार्थ (परिश्रम) के केवल भाग्य से सफलता नहीं मिलती।",
      meaningEn = "Just as a chariot cannot move on a single wheel, so fate achieves nothing without human exertion."
    ),
    SubhashitaItem(
      verse = "अयं निजः परो वेत्ति गणना लघुचेतसाम्।\nउदारचरितानां तु वसुधैव कुटुम्बकम्॥",
      source = "हितोपदेशे / महोपनिषदि",
      meaningSa = "इदं मम, इदं परस्येति भेदबुद्धिः सङ्कुचितचित्तानां भवति; उदारहृदयानां तु निखिलं विश्वमेव स्वपरिवारः।",
      meaningHi = "यह मेरा है, यह पराया है—ऐसी गणना क्षुद्र बुद्धि वाले करते हैं; उदार चरित्र वालों के लिए तो सम्पूर्ण पृथ्वी ही एक परिवार है।",
      meaningEn = "'This is mine, that belongs to another' is the calculation of petty minds. For those of noble character, the entire earth is a single family."
    )
  )

  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(12.dp),
    modifier = Modifier.fillMaxSize()
  ) {
    items(subhashitas) { item ->
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(text = "सुभाषितम्", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = item.source, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary)
          }
          Spacer(modifier = Modifier.height(6.dp))
          Text(text = item.verse, fontWeight = FontWeight.Bold, fontSize = 14.sp, lineHeight = 22.sp, color = MaterialTheme.colorScheme.primary)
          Spacer(modifier = Modifier.height(6.dp))
          val meaning = when (lang) {
            AppLanguage.SANSKRIT -> item.meaningSa
            AppLanguage.HINDI -> item.meaningHi
            AppLanguage.ENGLISH -> item.meaningEn
          }
          Text(text = "अर्थः: $meaning", fontSize = 12.sp, lineHeight = 19.sp, color = MaterialTheme.colorScheme.onSurface)
        }
      }
    }
  }
}

data class SubhashitaItem(
  val verse: String,
  val source: String,
  val meaningSa: String,
  val meaningHi: String,
  val meaningEn: String
)

@Composable
fun AcharyaTimelineTool(lang: AppLanguage) {
  val acharyas = listOf(
    Triple("भरतमुनिः (ई० पूर्व २ शता०)", "नाट्यशास्त्रम्", "रससिद्धान्तस्य मूलप्रवर्तकः, अष्टरसानां प्रतिपादकः, रससूत्रस्य प्रणेता"),
    Triple("भामहः (६ शता०)", "काव्यालङ्कारः", "अलङ्कारसम्प्रदायस्य संस्थापकः ('शब्दार्थौ सहितौ काव्यम्'), वक्रोक्तेः प्रतिष्ठापकः"),
    Triple("दण्डी (७ शता०)", "काव्यादर्शः", "दशगुणानां विशदं प्रतिपादनम्, वैदर्भी-गौडीरीत्योः स्पष्टनिरूपणम्"),
    Triple("वामनः (८ शता०)", "काव्यालङ्कारसूत्रवृत्तिः", "रीतिसम्प्रदायस्य संस्थापकः ('रीतिरात्मा काव्यस्य', 'विशेषो गुणात्मा')"),
    Triple("उद्भटः (८ शता०)", "काव्यालङ्कारसारसङ्ग्रहः", "षड्विधानाम् अलङ्कारवर्गाणां व्यवस्थितं निरूपणम्"),
    Triple("रुद्रटः (९ शता०)", "काव्यालङ्कारः", "अलङ्काराणां वैज्ञानिकं वर्गीकरणम् (वास्तव, औपम्य, अतिशय, श्लेष)"),
    Triple("आनन्दवर्धनः (९ शता०)", "ध्वन्यालोकः", "ध्वनिसिद्धान्तस्य प्रवर्तकः ('काव्यस्यात्मा ध्वनिः'), रसध्वनेः स्थापकः"),
    Triple("अभिनवगुप्तः (१० शता०)", "लोचनटीका व अभिनवभारती", "रसध्वनेः रसनिष्पत्तेश्च (अभिव्यक्तिवादस्य) मूर्धन्यव्याख्याकारः"),
    Triple("कुन्तकः (१० शता०)", "वक्रोक्तिजीवितम्", "वक्रोक्तिसम्प्रदायस्य प्रवर्तकः ('वक्रोक्तिः काव्यजीवितम्')"),
    Triple("महिमभट्टः (११ शता०)", "व्यक्तिविवेकः", "ध्वनेः अनुमाने अन्तर्भाववादस्य प्रबलः प्रतिपादकः"),
    Triple("क्षेमेन्द्रः (११ शता०)", "औचित्यविचारचर्चा", "औचित्यसम्प्रदायस्य प्रतिष्ठापकः ('औचित्यं रससिद्धस्य स्थिरं काव्यस्य जीवितम्')"),
    Triple("मम्मटभट्टः (११ शता०)", "काव्यप्रकाशः", "काव्यशास्त्रस्य प्रामाणिकसमन्वयकः, ध्वनिप्रतिष्ठापकः, दोषगुणालङ्कारविमर्शकः"),
    Triple("रुय्यकः (१२ शता०)", "अलङ्कारसर्वस्वम्", "अलङ्काराणां सूक्ष्मभेदप्रभेदानां दार्शनिकः विवेचकः"),
    Triple("विश्वनाथकविराजः (१४ शता०)", "साहित्यदर्पणः", "रसध्वनेः महाव्याख्याकारः ('वाक्यं रसात्मकं काव्यम्')"),
    Triple("पण्डितराज-जगन्नाथः (१७ शता०)", "रसगङ्गाधरः", "प्रौढनैयायिकालङ्कारिकः ('रमणीयार्थप्रतिपादकः शब्दः काव्यम्')")
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
