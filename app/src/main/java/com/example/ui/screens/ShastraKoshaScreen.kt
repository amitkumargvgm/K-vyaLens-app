package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ShastraDatabase
import com.example.model.AppLanguage
import com.example.model.ShastraTopic
import com.example.strings.AppStrings

@Composable
fun ShastraKoshaScreen(
  appLanguage: AppLanguage,
  modifier: Modifier = Modifier
) {
  var searchQuery by remember { mutableStateOf("") }
  var expandedTopicId by remember { mutableStateOf<String?>(ShastraDatabase.list.firstOrNull()?.id) }

  val filteredTopics = remember(searchQuery) {
    if (searchQuery.isBlank()) {
      ShastraDatabase.list
    } else {
      ShastraDatabase.list.filter {
        it.term.contains(searchQuery, ignoreCase = true) ||
            it.termIast.contains(searchQuery, ignoreCase = true) ||
            it.category.contains(searchQuery, ignoreCase = true) ||
            it.vyutpatti.contains(searchQuery, ignoreCase = true)
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
      // Search Box
      OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text(AppStrings.shastraSearchHint(appLanguage), fontSize = 13.sp) },
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
          .testTag("shastra_search_bar"),
        shape = RoundedCornerShape(14.dp)
      )

      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = when (appLanguage) {
          AppLanguage.SANSKRIT -> "काव्यशास्त्र-पारिभाषिक-पदानि: ${filteredTopics.size}"
          AppLanguage.HINDI -> "काव्यशास्त्र पारिभाषिक पद (व्युत्पत्ति एवं परिभाषा): ${filteredTopics.size}"
          AppLanguage.ENGLISH -> "Technical Poetics Terms: ${filteredTopics.size}"
        },
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary
      )
    }

    items(filteredTopics, key = { it.id }) { topic ->
      val isExpanded = expandedTopicId == topic.id
      ShastraTopicCard(
        topic = topic,
        isExpanded = isExpanded,
        onToggle = {
          expandedTopicId = if (isExpanded) null else topic.id
        },
        lang = appLanguage
      )
    }

    item {
      Spacer(modifier = Modifier.height(20.dp))
    }
  }
}

@Composable
fun ShastraTopicCard(
  topic: ShastraTopic,
  isExpanded: Boolean,
  onToggle: () -> Unit,
  lang: AppLanguage
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onToggle() }
      .testTag("shastra_item_${topic.id}"),
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
            text = topic.term,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Text(
            text = "${topic.termIast} • ${topic.category}",
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

      AnimatedVisibility(visible = isExpanded) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
          HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

          // 1. Vyutpatti (Etymology & how the word was created)
          Text(
            text = AppStrings.vyutpattiLabel(lang),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f))
              .border(0.6.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
              .padding(10.dp)
          ) {
            Text(
              text = topic.vyutpatti,
              style = MaterialTheme.typography.bodyMedium,
              fontWeight = FontWeight.Medium,
              color = MaterialTheme.colorScheme.onSurface,
              lineHeight = 22.sp
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          // 2. Classical Definitions
          Text(
            text = AppStrings.definitionsLabel(lang),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(6.dp))

          topic.definitions.forEach { def ->
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .padding(10.dp)
            ) {
              Column {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  Text(
                    text = def.author,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                  )
                  Text(
                    text = def.work,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.tertiary
                  )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = def.text,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                val meaning = when (lang) {
                  AppLanguage.SANSKRIT -> def.meaningSa
                  AppLanguage.HINDI -> def.meaningHi
                  AppLanguage.ENGLISH -> def.meaningEn
                }
                Text(
                  text = "भावः: $meaning",
                  fontSize = 12.sp,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // 3. Svarupa & Significance
          Text(
            text = "स्वरूपम् व वैशिष्ट्यम्:",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          val svarupa = when (lang) {
            AppLanguage.SANSKRIT -> topic.svarupaSa
            AppLanguage.HINDI -> topic.svarupaHi
            AppLanguage.ENGLISH -> topic.svarupaEn
          }
          Text(text = svarupa, style = MaterialTheme.typography.bodyMedium, lineHeight = 21.sp)

          Spacer(modifier = Modifier.height(10.dp))

          // 4. Classifications / Bhedas
          Text(
            text = "प्रमुखाः भेदाः (Classifications):",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(4.dp))
          topic.classifications.forEach { cls ->
            val desc = when (lang) {
              AppLanguage.SANSKRIT -> cls.descriptionSa
              AppLanguage.HINDI -> cls.descriptionHi
              AppLanguage.ENGLISH -> cls.descriptionEn
            }
            Row(modifier = Modifier.padding(vertical = 2.dp)) {
              Text(
                text = "• ${cls.name}: ",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.primary
              )
              Text(text = desc, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
            }
          }

          if (topic.illustrativeVerse.isNotEmpty()) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "उदाहरणाम् (${topic.illustrativeVerseSource}):",
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
                  text = topic.illustrativeVerse,
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Bold,
                  color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(4.dp))
                val expl = when (lang) {
                  AppLanguage.SANSKRIT -> topic.illustrativeExplanationSa
                  AppLanguage.HINDI -> topic.illustrativeExplanationHi
                  AppLanguage.ENGLISH -> topic.illustrativeExplanationEn
                }
                Text(text = expl, fontSize = 12.sp)
              }
            }
          }
        }
      }
    }
  }
}
