package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.strings.AppStrings
import com.example.ui.components.AppTopBar
import com.example.ui.screens.AnalyzeScreen
import com.example.ui.screens.ChhandasScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.ShastraKoshaScreen
import com.example.ui.screens.ToolsScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      var isDarkMode by remember { mutableStateOf(false) } // Default light as requested!
      var appLanguage by remember { mutableStateOf(AppLanguage.SANSKRIT) } // Default Sanskrit!
      var currentTab by remember { mutableIntStateOf(0) }

      // Handle back button: return to Home (Tab 0) if on secondary tabs
      BackHandler(enabled = currentTab != 0) {
        currentTab = 0
      }

      MyApplicationTheme(darkTheme = isDarkMode) {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = {
            AppTopBar(
              currentLanguage = appLanguage,
              onLanguageChange = { appLanguage = it },
              isDarkMode = isDarkMode,
              onToggleTheme = { isDarkMode = !isDarkMode }
            )
          },
          bottomBar = {
            // Fixed Bottom Navigation with 5 tabs as requested
            NavigationBar(
              containerColor = MaterialTheme.colorScheme.surface,
              contentColor = MaterialTheme.colorScheme.onSurface,
              modifier = Modifier.testTag("main_bottom_nav_bar")
            ) {
              // Tab 0: Analyze
              NavigationBarItem(
                selected = currentTab == 0,
                onClick = { currentTab = 0 },
                icon = { Icon(Icons.Default.Search, contentDescription = "Analyze") },
                label = {
                  Text(
                    text = AppStrings.navAnalyze(appLanguage),
                    fontSize = 11.sp,
                    fontWeight = if (currentTab == 0) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.testTag("nav_analyze_button"),
                colors = NavigationBarItemDefaults.colors(
                  selectedIconColor = MaterialTheme.colorScheme.primary,
                  selectedTextColor = MaterialTheme.colorScheme.primary,
                  indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
              )

              // Tab 1: Chhandas
              NavigationBarItem(
                selected = currentTab == 1,
                onClick = { currentTab = 1 },
                icon = { Icon(Icons.Default.LibraryBooks, contentDescription = "Chhandas") },
                label = {
                  Text(
                    text = AppStrings.navChhandas(appLanguage),
                    fontSize = 11.sp,
                    fontWeight = if (currentTab == 1) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.testTag("nav_chhandas_button"),
                colors = NavigationBarItemDefaults.colors(
                  selectedIconColor = MaterialTheme.colorScheme.primary,
                  selectedTextColor = MaterialTheme.colorScheme.primary,
                  indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
              )

              // Tab 2: Shastra Kosha
              NavigationBarItem(
                selected = currentTab == 2,
                onClick = { currentTab = 2 },
                icon = { Icon(Icons.Default.AutoAwesome, contentDescription = "Shastra") },
                label = {
                  Text(
                    text = AppStrings.navShastra(appLanguage),
                    fontSize = 11.sp,
                    fontWeight = if (currentTab == 2) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.testTag("nav_shastra_button"),
                colors = NavigationBarItemDefaults.colors(
                  selectedIconColor = MaterialTheme.colorScheme.primary,
                  selectedTextColor = MaterialTheme.colorScheme.primary,
                  indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
              )

              // Tab 3: Tools
              NavigationBarItem(
                selected = currentTab == 3,
                onClick = { currentTab = 3 },
                icon = { Icon(Icons.Default.Build, contentDescription = "Tools") },
                label = {
                  Text(
                    text = AppStrings.navTools(appLanguage),
                    fontSize = 11.sp,
                    fontWeight = if (currentTab == 3) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.testTag("nav_tools_button"),
                colors = NavigationBarItemDefaults.colors(
                  selectedIconColor = MaterialTheme.colorScheme.primary,
                  selectedTextColor = MaterialTheme.colorScheme.primary,
                  indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
              )

              // Tab 4: Profile / Scholar
              NavigationBarItem(
                selected = currentTab == 4,
                onClick = { currentTab = 4 },
                icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                label = {
                  Text(
                    text = AppStrings.navProfile(appLanguage),
                    fontSize = 11.sp,
                    fontWeight = if (currentTab == 4) FontWeight.Bold else FontWeight.Normal
                  )
                },
                modifier = Modifier.testTag("nav_profile_button"),
                colors = NavigationBarItemDefaults.colors(
                  selectedIconColor = MaterialTheme.colorScheme.primary,
                  selectedTextColor = MaterialTheme.colorScheme.primary,
                  indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
              )
            }
          }
        ) { innerPadding ->
          Box(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          ) {
            when (currentTab) {
              0 -> AnalyzeScreen(appLanguage = appLanguage)
              1 -> ChhandasScreen(appLanguage = appLanguage)
              2 -> ShastraKoshaScreen(appLanguage = appLanguage)
              3 -> ToolsScreen(appLanguage = appLanguage)
              4 -> ProfileScreen(appLanguage = appLanguage)
            }
          }
        }
      }
    }
  }
}
