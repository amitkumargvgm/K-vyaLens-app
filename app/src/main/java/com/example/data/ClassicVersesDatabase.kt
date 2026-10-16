package com.example.data

import com.example.model.AlankaraItem
import com.example.model.ChhandasIdentification
import com.example.model.ConfidenceLevel
import com.example.model.RasaAnalysis
import com.example.model.ResearchSummary
import com.example.model.VerseAnalysis
import com.example.model.WordMeaning

object ClassicVersesDatabase {

  val list: List<VerseAnalysis> by lazy {
    listOf(
      VerseAnalysis(
        id = "vagarthaviva",
        originalVerse = "वागर्थाविव सम्पृक्तौ वागर्थप्रतिपत्तये।\nजगतः पितरौ वन्दे पार्वतीपरमेश्वरौ॥",
        transliteration = "vāgarthāviva sampṛktau vāgarthapratipattaye |\njagataḥ pitarau vande pārvatīparameśvarau ||",
        padaccheda = "वाक्-अर्थौ इव सम्पृक्तौ वाक्-अर्थ-प्रतिपत्तये ।\nजगतः पितरौ वन्दे पार्वती-परमेश्वरौ ॥",
        anvaya = "वागर्थप्रतिपत्तये वागर्थाविव सम्पृक्तौ जगतः पितरौ पार्वतीपरमेश्वरौ वन्दे।",
        pratipadartha = listOf(
          WordMeaning("वागर्थप्रतिपत्तये", "वाचः अर्थस्य च सम्यक् ज्ञानाय", "वाणी और अर्थ की यथार्थ प्रतीति (ज्ञान) के लिए", "For the true realization of word and its meaning", "चतुर्थी एकवचनम् (प्रतिपत्ति + ङे)"),
          WordMeaning("वागर्थाविव", "शब्दार्थौ इव नित्यसम्बद्धौ", "वाणी और अर्थ के समान नित्य मिले हुए", "Inseparably united like speech and meaning", "द्वितीया द्विवचनम्, उपमावाचकः 'इव'"),
          WordMeaning("सम्पृक्तौ", "परस्परं संयुक्तौ संश्लिष्टौ", "एक-दूसरे से सदा अभिन्न रूप से मिले हुए", "Ever intertwined / indivisibly joined", "सम् + पृच् धातोः क्त प्रत्ययः"),
          WordMeaning("जगतः", "विश्वस्य निखिलप्रपञ्चस्य", "सम्पूर्ण संसार के", "Of the entire cosmos / universe", "षष्ठी एकवचनम्"),
          WordMeaning("पितरौ", "मातापितरौ जननीजनकौ", "माता और पिता", "The parents (mother and father)", "एकशेष-द्वन्द्वसमासः"),
          WordMeaning("वन्दे", "प्रणमामि नमस्करोमि", "मैं वन्दना करता हूँ / प्रणाम करता हूँ", "I bow in reverent devotion", "वन्द् धातोः लट् लकारः उत्तमपुरुष एकवचनम्"),
          WordMeaning("पार्वतीपरमेश्वरौ", "शिवाशङ्करौ", "पार्वती और परमेश्वर (शिव) को", "To Parvati and Supreme Lord Shiva", "द्वन्द्वसमासः, द्वितीया द्विवचनम्")
        ),
        literalMeaningSa = "वाचः अर्थस्य च सम्यग्ज्ञानाय वाक्-अर्थौ इव परस्परं नित्यसंयुक्तौ जगतः मातापितरौ पार्वतीपरमेश्वरौ अहम् अभिवादये।",
        literalMeaningHi = "वाणी और अर्थ के सम्यक् ज्ञान के लिए, वाणी और अर्थ के समान नित्य संश्लिष्ट जगत् के माता-पिता पार्वती और शिव को मैं प्रणाम करता हूँ।",
        literalMeaningEn = "For the proper comprehension of word and meaning, I bow unto Parvati and Supreme Lord Shiva, the parents of the universe, who are eternally united like speech and its sense.",
        interpretiveMeaningSa = "कालिदासः स्वमहाकाव्यस्य मङ्गलार्थं शब्दार्थयोः नित्यसम्बन्धवत् शिवपार्वत्योः अभिन्नत्वं वर्णयति। काव्ये शब्दार्थौ शरीरम्, अतस्तदधिष्ठात्रोः वन्दना कृता।",
        interpretiveMeaningHi = "कालिदास ने रघुवंश के मङ्गलाचरण में शब्द और अर्थ की अद्वैतता के माध्यम से जगन्माता-पिता शिव-पार्वती की अभिन्नता और काव्य के मर्म का शिलान्यास किया है।",
        interpretiveMeaningEn = "Kalidasa inaugurates the Raghuvamsha with an auspicious invocation where the semantic inseparability of word and meaning mirrors the cosmic divine unity of Shiva and Parvati.",
        vyakhyaSa = "अयं रघुवंशमहाकाव्यस्य मङ्गलश्लोकः। अत्र 'सम्पृक्तौ' पदेन शब्दार्थयोः नित्यः सम्बन्धः ध्वन्यते। व्याकरणमते शब्दार्थयोः तादात्म्यं वर्तते। कवेः मुख्योद्देश्यः रघुवंशस्य यशः कीर्तनम्, तदर्थं वाक्पटुत्वं च शिवपार्वत्योः अनुग्रहादेव लभ्यते।",
        vyakhyaHi = "यह रघुवंश महाकाव्य का प्रसिद्ध मङ्गलाचरण है। यहाँ शब्द और अर्थ के तादात्म्य सम्बन्ध की उपमा देकर शिव और पार्वती की अर्धनारीश्वर-सुलभ अभिन्नता का निरूपण किया गया है। काव्य का शरीर शब्द और अर्थ ही है, अतः कवि का यह प्रणाम काव्य की निष्पत्ति का मङ्गल हेतु है।",
        vyakhyaEn = "The opening benediction of the Raghuvamsha. The compound 'pitarau' utilizes ekashesha dvandva indicating both mother and father. The inseparability of sound and sense establishes the foundation of Sanskrit aesthetics.",
        alankaras = listOf(
          AlankaraItem(
            name = "पूर्णा श्रौती उपमा (Purnopama)",
            evidence = "'वागर्थाविव सम्पृक्तौ'",
            reasoningSa = "अत्र उपमेयम् (पार्वतीपरमेश्वरौ), उपमानम् (वागर्थौ), साधारणधर्मः (सम्पृक्तत्वम्), उपमावाचकः (इव) चत्वार्यपि स्पष्टानि।",
            reasoningHi = "यहाँ चारों अंग—उपमेय (पार्वती-परमेश्वर), उपमान (वाणी-अर्थ), साधारण धर्म (सम्पृक्त होना), और वाचक (इव) उपस्थित हैं।",
            reasoningEn = "All four components of simile are explicitly present: Upameya (Parvati-Shiva), Upamāna (speech and meaning), common property (inseparable cohesion), and particle 'iva'.",
            alternatives = "नित्यसम्बन्ध-द्योतकत्वेन अर्थान्तरन्यास-प्रतीतिः",
            confidence = ConfidenceLevel.STRONGLY_SUPPORTED
          )
        ),
        rasa = RasaAnalysis(
          rasaName = "शान्तरसः / भक्तिभावः (Devotional Sentiment)",
          sthayibhava = "शमः / देवविषया रतिः",
          vibhavas = "आलम्बनम्: जगत्पितरौ पार्वतीपरमेश्वरौ; उद्दीपनम्: काव्यरचनासङ्कल्पः",
          anubhavas = "शिरसा प्रणिपातः, काव्यमङ्गलाचरणम्",
          vyabhicaribhavas = "मतिः, धृतिः, हर्षः, दैन्यम्",
          aestheticRealization = "मङ्गलाचरणे सहृदयहृदये भक्तिरसाविर्भावः।",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        chhandas = ChhandasIdentification(
          meterName = "अनुष्टुप् (श्लोकः / Anustubh)",
          syllablesPerPada = 8,
          ganaPattern = "पञ्चमं लघु सर्वत्र, षष्ठं गुरु, सप्तमं द्विचतुर्थयोर्ह्रस्वम्",
          laghuGuruPattern = "ऽ । ऽ । । ऽ ऽ ऽ  ।  ऽ ऽ । । ऽ । ऽ\n। । ऽ  । । ऽ ऽ ऽ  ।  ऽ ऽ । । ऽ । ऽ",
          lakshanaAttributed = "केदारभट्टकृत-वृत्तरत्नाकरः (२.२)",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        dhvaniAndPoetics = "काव्यस्यारम्भे शब्दार्थयोः नित्यत्वं द्योत्यते। वस्तुध्वनिः: पार्वतीपरमेश्वरावनुग्रहेण काव्यसिद्धिः सुलभैवेति।",
        grammaticalObservations = listOf(
          "वागर्थौ = वाक् च अर्थश्च (इतरेतरद्वन्द्वसमासः), तौ इव = वागर्थाविव",
          "प्रतिपत्तये = प्रति + पद् धातोः क्तिन् प्रत्ययः (प्रतिपत्तिः), तस्यै (चतुर्थी एकवचनम्)",
          "पितरौ = माता च पिता च (एकशेषद्वन्द्वसमासः)"
        ),
        sourceStatus = "प्रमाणितम् (Verified Classical Source)",
        sourceWork = "रघुवंशमहाकाव्यम् (सर्गः १, श्लोकः १)",
        sourceAuthor = "महाकवि-कालिदासः",
        researchSummary = ResearchSummary(
          strongestInterpretationSa = "शब्दार्थयोः अद्वैतं पार्वतीपरमेश्वरयोः तादात्म्यं च एकमेव नित्यं तत्त्वम्।",
          strongestInterpretationHi = "वाणी और अर्थ का नित्य सम्बन्ध ही पार्वती और परमेश्वर के तादात्म्य का परम प्रमाण है।",
          strongestInterpretationEn = "The inseparable union of speech and sense mirrors the non-dual cosmic reality of Shiva and Parvati.",
          mostUncertainClaimSa = "केचन अत्र एकशेषे मातृप्राधान्यं कल्पयन्ति, यद्यपि उभयोः साम्यमेव साधीयः।",
          mostUncertainClaimHi = "कुछ टीकाकार एकशेष में माता की प्राथमिकता का दावा करते हैं, यद्यपि दोनों का समत्व ही मान्य है।",
          mostUncertainClaimEn = "Whether the ekashesha compound prioritizes the divine mother or absolute symmetry between the two deities.",
          researchQuestionSa = "किम् अत्र शब्दब्रह्मवादस्य (भर्तृहरि-स्फोटवादस्य) प्रभावो वर्तते?",
          researchQuestionHi = "क्या इस श्लोक में भर्तृहरि के शब्दब्रह्मवाद और स्फोट सिद्धान्त की दार्शनिक छाया विद्यमान है?",
          researchQuestionEn = "To what extent does this invocation reflect early Grammarian Sphota philosophy regarding eternal word-sense cohesion?",
          expertReviewNotes = "पारम्परिकमल्लिनाथसञ्जीवनीटीकया दृढसमर्थितम्। (Thoroughly verified via Mallinatha's Sanjivani commentary)."
        )
      ),

      VerseAnalysis(
        id = "sariramadhyam",
        originalVerse = "शरीरमाद्यं खलु धर्मसाधनम्।",
        transliteration = "śarīramādyaṃ khalu dharmasādhanam |",
        padaccheda = "शरीरम् आद्यम् खलु धर्म-साधनम् ।",
        anvaya = "शरीरं खलु धर्मसाधनम् आद्यम् (भवति)।",
        pratipadartha = listOf(
          WordMeaning("शरीरम्", "स्थूलदेहः कायः", "यह भौतिक देह / शरीर", "The physical body", "प्रथमा एकवचनम्"),
          WordMeaning("आद्यम्", "प्रथमं प्रधानं मुख्यम्", "पहला और सर्वप्रमुख", "The primary / foundational", "विशेषणम्"),
          WordMeaning("खलु", "निश्चयेन वस्तुतः", "निश्चय ही / वास्तव में", "Verily / indeed", "निश्चयार्थकमव्ययम्"),
          WordMeaning("धर्मसाधनम्", "धर्मस्य आचरणस्य साधनम्", "धर्म के पालन का प्रमुख साधन", "The instrument for practicing righteousness", "षष्ठीतत्पुरुषसमासः")
        ),
        literalMeaningSa = "शरीरमेव हि धर्मस्य सर्वविधस्यानुष्ठानस्य प्रथमं प्रधानं च साधनं वर्तते।",
        literalMeaningHi = "सम्पूर्ण धर्म का पालन करने के लिए निश्चय ही यह शरीर ही पहला और प्रधान साधन है।",
        literalMeaningEn = "The physical body is indeed the foremost instrument for the accomplishment of righteousness and spiritual duties.",
        interpretiveMeaningSa = "कालिदासेन तपोरतायाः पार्वत्याः शरीरातिपीडनं वारयितुं ब्रह्मचारिवेषिणा शिवेन शरीरायोग्यकठोरतपसः औचित्यं प्रतिपाद्यते।",
        interpretiveMeaningHi = "पार्वती की कठोर तपस्या के समय ब्रह्मचारी वेशधारी शिव ने यह उद्घोष करके देहरक्षा और स्वास्थ्य की प्राथमिकता का अमर सन्देश दिया।",
        interpretiveMeaningEn = "Uttered by Lord Shiva in the guise of a celibate youth to Parvati, emphasizing that preservation of life and bodily wellbeing is prerequisite to all spiritual striving.",
        vyakhyaSa = "कुमारसम्भवे पञ्चमसर्गे ब्रह्मचारिरूपी शिवः पार्वतीं प्रति वदति यत् धर्मानुष्ठानाय शरीरमेव मूलम्, तस्य विनाशे धर्मोऽपि विनश्यति।",
        vyakhyaHi = "कुमारसम्भव के पाँचवें सर्ग का यह प्रसिद्ध सूक्तिवाक्य है। तपस्या में शरीर का क्षय देखकर ब्रह्मचारी शिव पार्वती से कहते हैं कि यदि शरीर ही नष्ट हो गया तो धर्म की सिद्धि कैसे होगी?",
        vyakhyaEn = "Celebrated maxims of classical Indian thought; spiritual attainment presupposes physical fitness and organic integrity.",
        alankaras = listOf(
          AlankaraItem(
            name = "अर्थान्तरन्यासः / सूक्तिः (Arthanantaranyasa / Aphoristic Maxim)",
            evidence = "'शरीरमाद्यं खलु धर्मसाधनम्'",
            reasoningSa = "सामान्येन विशेषस्य अथवा सूक्तिरूपेण सार्वभौमसत्यस्य प्रतिपादनम्।",
            reasoningHi = "एक सार्वभौमिक सत्य सूक्ति का सामान्य कथन के रूप में समर्थन।",
            reasoningEn = "Corroboration of a universal moral truth through an aphoristic principle.",
            alternatives = "काव्यलिङ्गम् (कारणोपपत्तेः)",
            confidence = ConfidenceLevel.STRONGLY_SUPPORTED
          )
        ),
        rasa = RasaAnalysis(
          rasaName = "शान्तरसः / धर्मवीरः",
          sthayibhava = "धैर्यम् / उत्साहः",
          vibhavas = "पार्वत्याः तपोवनम्, ब्रह्मचारिप्रवेशः",
          anubhavas = "उपदेशवचनम्, विचारमन्थनम्",
          vyabhicaribhavas = "मतिः, वितर्कः, चिन्ता",
          aestheticRealization = "गम्भीरधर्मबोधः।",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        chhandas = ChhandasIdentification(
          meterName = "वंशस्थम् (अंशः / Vamshastham quarter)",
          syllablesPerPada = 12,
          ganaPattern = "ज-त-ज-र",
          laghuGuruPattern = "। ऽ । ऽ ऽ । । ऽ । ऽ । ऽ",
          lakshanaAttributed = "केदारभट्टकृत-वृत्तरत्नाकरः (३.२६)",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        dhvaniAndPoetics = "सूक्तिध्वनिः; पार्वत्याः अङ्गरक्षायां शिवस्य गूढानुरागस्य द्योतनम्।",
        grammaticalObservations = listOf(
          "धर्मसाधनम् = धर्मस्य साधनम् (षष्ठीतत्पुरुषसमासः)",
          "खलु = निश्चयार्थकम् अव्ययम्"
        ),
        sourceStatus = "प्रमाणितम् (Verified Classical Source)",
        sourceWork = "कुमारसम्भवमहाकाव्यम् (सर्गः ५, श्लोकः ३३)",
        sourceAuthor = "महाकवि-कालिदासः",
        researchSummary = ResearchSummary(
          strongestInterpretationSa = "देहस्य स्वास्थ्यं विना धर्माचरणम् असम्भवम्।",
          strongestInterpretationHi = "शरीर के स्वस्थ रहे बिना किसी भी धर्म या कर्तव्य का पालन असम्भव है।",
          strongestInterpretationEn = "Bodily preservation is the non-negotiable prerequisite to any ethical or spiritual discipline.",
          mostUncertainClaimSa = "किम् अत्र तपसो निन्दा कृता? नहि, केवलम् अतिरेकस्य वारकम्।",
          mostUncertainClaimHi = "क्या यहाँ तप की निन्दा है? नहीं, केवल अतिवादी देहपीडन का निषेध है।",
          mostUncertainClaimEn = "Whether it criticizes asceticism; consensus holds it merely rejects reckless self-mortification.",
          researchQuestionSa = "आयुर्वेदशास्त्रस्य सह अस्य सूक्तेः साक्षात् सम्बन्धः कीदृशः?",
          researchQuestionHi = "आयुर्वेद के स्वास्थ्य सिद्धान्तों से इस सूक्ति का क्या दार्शनिक सामंजस्य है?",
          researchQuestionEn = "How does this poetic aphorism interface with classical Ayurvedic principles of bodily preservation?",
          expertReviewNotes = "कालिदासीयकविप्रतिभायाः अप्रतिमं निदर्शनम्। (Unanimously acclaimed across commentaries)."
        )
      )
    )
  }
}
