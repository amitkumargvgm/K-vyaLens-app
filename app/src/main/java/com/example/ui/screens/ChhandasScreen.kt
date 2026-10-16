package com.example.ui.screens

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.data.ChhandasDatabase
import com.example.model.AppLanguage
import com.example.model.ChhandasItem
import com.example.strings.AppStrings

@Composable
fun ChhandasScreen(
  appLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  var searchQuery by remember { mutableStateOf("") }
  var expandedItemId by remember { mutableStateOf<String?>(null) }

  val filteredList = remember(searchQuery) {
    if (searchQuery.isBlank()) {
      ChhandasDatabase.list
    } else {
      ChhandasDatabase.list.filter {
        it.nameSa.contains(searchQuery, ignoreCase = true) ||
            it.nameEn.contains(searchQuery, ignoreCase = true) ||
            it.syllableCount.toString() == searchQuery.trim() ||
            it.ganaRule.contains(searchQuery, ignoreCase = true)
      }
    }
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(8.dp))
      // Search Bar
      OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text(AppStrings.chhandasSearchHint(appLanguage), fontSize = 13.sp) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
              Icon(Icons.Default.Clear, contentDescription = "Clear")
            }
          }
        },
        modifier = Modifier
          .fillMaxWidth()
          .testTag("chhandas_search_bar"),
        shape = RoundedCornerShape(14.dp)
      )

      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = when (appLanguage) {
          AppLanguage.SANSKRIT -> "कुल-छन्दांसि: ${filteredList.size} (लक्षण-घटन-सहितानि)"
          AppLanguage.HINDI -> "कुल छन्द: ${filteredList.size} (लक्षण एवं प्रस्तार-घटन सहित)"
          AppLanguage.ENGLISH -> "Total Meters: ${filteredList.size} (with multi-lakshanas & scansion)"
        },
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary
      )
    }

    items(filteredList, key = { it.id }) { item ->
      val isExpanded = expandedItemId == item.id
      ChhandasCard(
        item = item,
        isExpanded = isExpanded,
        onToggle = {
          expandedItemId = if (isExpanded) null else item.id
        },
        lang = appLanguage
      )
    }

    item {
      Spacer(modifier = Modifier.height(20.dp))
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChhandasCard(
  item: ChhandasItem,
  isExpanded: Boolean,
  onToggle: () -> Unit,
  lang: AppLanguage
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onToggle() }
      .testTag("chhandas_item_${item.id}"),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    shape = RoundedCornerShape(14.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Column(modifier = Modifier.padding(14.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = item.nameSa,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Text(
            text = "${item.nameEn} • ${item.category} • ${if (item.syllableCount > 0) "${item.syllableCount} अक्षराणि" else "मात्रावृत्तम्"}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        IconButton(onClick = onToggle) {
          Icon(
            imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = if (isExpanded) "Collapse" else "Expand",
            tint = MaterialTheme.colorScheme.primary
          )
        }
      }

      // Quick summary preview
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = "गणनियमः: ${item.ganaRule}",
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.secondary
      )

      AnimatedVisibility(visible = isExpanded) {
        Column(modifier = Modifier.padding(top = 12.dp)) {
          HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

          // Yati info
          Text(
            text = "यतिः: ${item.yati}",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.tertiary
          )

          Spacer(modifier = Modifier.height(10.dp))

          // Multiple Lakshanas with Authority Attribution
          Text(
            text = AppStrings.multipleLakshanasLabel(lang),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(6.dp))

          item.lakshanas.forEachIndexed { idx, lakshana ->
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .border(0.6.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                .padding(10.dp)
            ) {
              Column {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Text(
                    text = "लक्षणम् ${idx + 1}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                  )
                  Text(
                    text = "आचार्यः: ${lakshana.sourceAuthorOrText}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.tertiary
                  )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = lakshana.lakshanaText,
                  fontWeight = FontWeight.SemiBold,
                  fontSize = 13.sp,
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                val meaning = when (lang) {
                  AppLanguage.SANSKRIT -> lakshana.meaningSa
                  AppLanguage.HINDI -> lakshana.meaningHi
                  AppLanguage.ENGLISH -> lakshana.meaningEn
                }
                Text(
                  text = "अर्थः: $meaning",
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Classical Example
          Text(
            text = "उदाहरणाम् (${item.exampleSource}):",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f))
              .padding(10.dp)
          ) {
            Column {
              Text(
                text = item.exampleVerse,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                lineHeight = 22.sp
              )
              Spacer(modifier = Modifier.height(6.dp))
              val exMeaning = when (lang) {
                AppLanguage.SANSKRIT -> item.exampleMeaningSa
                AppLanguage.HINDI -> item.exampleMeaningHi
                AppLanguage.ENGLISH -> item.exampleMeaningEn
              }
              Text(
                text = "भावार्थः: $exMeaning",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Syllable Scansion Breakdown (Ghatakar Dikhana!)
          Text(
            text = AppStrings.scansionGhatana(lang),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(6.dp))

          item.scansionBreakdown.forEach { pada ->
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                .padding(8.dp)
            ) {
              Text(
                text = "चरणम् ${pada.padaNumber}: ${pada.padaText}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.height(6.dp))

              // Syllables Chips Row
              FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
              ) {
                pada.syllables.forEach { syl ->
                  Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                      .clip(RoundedCornerShape(6.dp))
                      .background(
                        if (syl.isGuru) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                        else MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f)
                      )
                      .border(
                        0.5.dp,
                        if (syl.isGuru) MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                        else MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f),
                        RoundedCornerShape(6.dp)
                      )
                      .padding(horizontal = 6.dp, vertical = 2.dp)
                  ) {
                    Text(
                      text = syl.symbol,
                      fontSize = 13.sp,
                      fontWeight = FontWeight.Bold,
                      color = if (syl.isGuru) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                      fontFamily = FontFamily.Monospace
                    )
                    Text(
                      text = syl.akshara,
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Medium
                    )
                    if (syl.ganaName.isNotEmpty()) {
                      Text(
                        text = syl.ganaName.take(1),
                        fontSize = 9.sp,
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
  }
}
