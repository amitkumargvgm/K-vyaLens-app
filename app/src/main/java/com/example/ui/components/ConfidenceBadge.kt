package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.ConfidenceLevel
import com.example.ui.theme.ConfidenceIndeterminateDark
import com.example.ui.theme.ConfidenceIndeterminateLight
import com.example.ui.theme.ConfidencePlausibleDark
import com.example.ui.theme.ConfidencePlausibleLight
import com.example.ui.theme.ConfidenceStrongDark
import com.example.ui.theme.ConfidenceStrongLight
import com.example.ui.theme.ConfidenceTentativeDark
import com.example.ui.theme.ConfidenceTentativeLight

@Composable
fun ConfidenceBadge(
  level: ConfidenceLevel,
  lang: AppLanguage,
  modifier: Modifier = Modifier
) {
  val (bgColor, textColor, dotColor) = when (level) {
    ConfidenceLevel.STRONGLY_SUPPORTED -> Triple(
      ConfidenceStrongLight.copy(alpha = 0.12f),
      ConfidenceStrongLight,
      ConfidenceStrongLight
    )
    ConfidenceLevel.PLAUSIBLE -> Triple(
      ConfidencePlausibleLight.copy(alpha = 0.12f),
      ConfidencePlausibleLight,
      ConfidencePlausibleLight
    )
    ConfidenceLevel.TENTATIVE -> Triple(
      ConfidenceTentativeLight.copy(alpha = 0.12f),
      ConfidenceTentativeLight,
      ConfidenceTentativeLight
    )
    ConfidenceLevel.INDETERMINATE -> Triple(
      ConfidenceIndeterminateLight.copy(alpha = 0.12f),
      ConfidenceIndeterminateLight,
      ConfidenceIndeterminateLight
    )
  }

  Row(
    modifier = modifier
      .clip(RoundedCornerShape(12.dp))
      .background(bgColor)
      .border(0.8.dp, textColor.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
      .padding(horizontal = 8.dp, vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(6.dp)
        .clip(CircleShape)
        .background(dotColor)
    )
    Spacer(modifier = Modifier.width(5.dp))
    Text(
      text = level.getLabel(lang),
      color = textColor,
      fontSize = 11.sp,
      fontWeight = FontWeight.SemiBold
    )
  }
}
