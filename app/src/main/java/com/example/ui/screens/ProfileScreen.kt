package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.strings.AppStrings

@Composable
fun ProfileScreen(
  appLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(8.dp))

      // Scholar / Developer Profile Card
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(
          modifier = Modifier.padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Box(
            modifier = Modifier
              .size(76.dp)
              .clip(CircleShape)
              .background(MaterialTheme.colorScheme.primaryContainer)
              .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.School,
              contentDescription = "Scholar",
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(42.dp)
            )
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = AppStrings.devName(appLanguage),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )

          Spacer(modifier = Modifier.height(6.dp))

          // Bio: National Sanskrit University, Tirupati Shastri 4th year student
          Text(
            text = AppStrings.devBio(appLanguage),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 22.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
          )

          Spacer(modifier = Modifier.height(14.dp))

          // Portfolio Link Button: "Check Portfolio"
          Button(
            onClick = {
              val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://AlphaTyping.com/amitkumaraks/"))
              context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("check_portfolio_button")
          ) {
            Icon(imageVector = Icons.Default.OpenInBrowser, contentDescription = "Portfolio")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = AppStrings.checkPortfolio(appLanguage),
              fontWeight = FontWeight.Bold,
              fontSize = 15.sp
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Email Contact Button
          OutlinedButton(
            onClick = {
              val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:amitkumargvgm@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Regarding KāvyaLens")
              }
              context.startActivity(intent)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("contact_email_button")
          ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email", modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = AppStrings.contactEmail(appLanguage),
              fontSize = 13.sp,
              fontWeight = FontWeight.SemiBold
            )
          }
        }
      }
    }

    // About KāvyaLens Card
    item {
      Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Info,
              contentDescription = "About",
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = when (appLanguage) {
                AppLanguage.SANSKRIT -> "काव्यलेन्स-विषये (About KāvyaLens)"
                AppLanguage.HINDI -> "काव्यलेन्स के विषय में (About KāvyaLens)"
                AppLanguage.ENGLISH -> "About KāvyaLens"
              },
              style = MaterialTheme.typography.titleMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = AppStrings.aboutKavyaLens(appLanguage),
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 22.sp
          )

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = when (appLanguage) {
              AppLanguage.SANSKRIT -> "सिद्धांन्ताः व मर्यादाः:\n• ग्रन्थाधारित-यथार्थप्रमाणानि (Never invent quotations or sources)\n• गुणात्मक-निश्चयता-स्तरः (Qualitative confidence: दृढम्, सम्भाव्यम्, ऐच्छिकम्, अनिर्णितम्)\n• त्रैभाषिक-प्रकाशनम् (संस्कृतम्, हिन्दी, English)\n• छन्दोविधान-प्रस्तार-घटनम्"
              AppLanguage.HINDI -> "सिद्धान्त एवं मर्यादा:\n• ग्रन्थाधारित यथार्थ प्रमाण (कोई मनगढ़ंत उद्धरण नहीं)\n• गुणात्मक विश्वसनीयता स्तर (दृढ़ प्रमाणित, सम्भाव्य, ऐच्छिक, अनिर्णित)\n• त्रिभाषी परिणाम (संस्कृत, हिन्दी, अंग्रेजी)\n• सूक्ष्म छन्द विधान एवं प्रस्तार घटन"
              AppLanguage.ENGLISH -> "Methodology & Principles:\n• Evidence-oriented poetics rooted in verified classical shastras\n• Qualitative confidence grading instead of arbitrary scores\n• Instant trilingual results (Sanskrit, Hindi, English)\n• Syllabic metric scansion and gaṇa analysis"
            },
            style = MaterialTheme.typography.bodySmall,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(text = "Version: 1.0.0", fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
            Text(text = "Tirupati, India", fontSize = 12.sp, color = MaterialTheme.colorScheme.outline)
          }
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}
