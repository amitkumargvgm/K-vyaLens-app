package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("KāvyaLens", appName)
  }

  @Test
  fun `test ChhandasEngine scans laghu and guru correctly`() {
    val syllables = com.example.util.ChhandasEngine.scanLine("वागर्थाविव सम्पृक्तौ")
    org.junit.Assert.assertTrue(syllables.isNotEmpty())
    org.junit.Assert.assertEquals(8, syllables.size)
  }

  @Test
  fun `test SanskritAnalyzer analyzes classic verse`() {
    val analysis = com.example.util.SanskritAnalyzer.analyzePassage("वागर्थाविव सम्पृक्तौ")
    org.junit.Assert.assertEquals("vagarthaviva", analysis.id)
    org.junit.Assert.assertTrue(analysis.alankaras.isNotEmpty())
  }
}
