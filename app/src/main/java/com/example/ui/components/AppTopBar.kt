package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.strings.AppStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
  currentLanguage: AppLanguage,
  onLanguageChange: (AppLanguage) -> Unit,
  isDarkMode: Boolean,
  onToggleTheme: () -> Unit
) {
  var showLanguageMenu by remember { mutableStateOf(false) }

  TopAppBar(
    title = {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
          modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "का",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
          )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
          text = AppStrings.appTitle(currentLanguage),
          style = MaterialTheme.typography.titleLarge,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.onSurface
        )
      }
    },
    actions = {
      // Language Selector
      Box {
        IconButton(
          onClick = { showLanguageMenu = true },
          modifier = Modifier.testTag("language_selector_button")
        ) {
          Icon(
            imageVector = Icons.Default.Language,
            contentDescription = "Change Language",
            tint = MaterialTheme.colorScheme.primary
          )
        }
        DropdownMenu(
          expanded = showLanguageMenu,
          onDismissRequest = { showLanguageMenu = false }
        ) {
          AppLanguage.entries.forEach { lang ->
            DropdownMenuItem(
              text = {
                Text(
                  text = "${lang.nativeName} (${lang.displayName})",
                  fontWeight = if (lang == currentLanguage) FontWeight.Bold else FontWeight.Normal,
                  color = if (lang == currentLanguage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
              },
              onClick = {
                onLanguageChange(lang)
                showLanguageMenu = false
              }
            )
          }
        }
      }

      // Theme Toggle (Light / Dark)
      IconButton(
        onClick = onToggleTheme,
        modifier = Modifier.testTag("theme_toggle_button")
      ) {
        Icon(
          imageVector = if (isDarkMode) Icons.Default.LightMode else Icons.Default.DarkMode,
          contentDescription = if (isDarkMode) "Switch to Light Mode" else "Switch to Dark Mode",
          tint = MaterialTheme.colorScheme.primary
        )
      }
    },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.surface
    )
  )
}
