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
            name = "पूर्णा श्रौती उपमा (Pūrṇopamā)",
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
        id = "astyuttarasyam",
        originalVerse = "अस्त्युत्तरस्यां दिशि देवतात्मा हिमालयो नाम नगाधिराजः।\nपूर्वापरौ तोयनिधी विगाह्य स्थितः पृथिव्या इव मानदण्डः॥",
        transliteration = "astyuttarasyāṃ diśi devatātmā himālayo nāma nagādhirājaḥ |\npūrvāparau toyanidhī vigāhya sthitaḥ pṛthivyā iva mānadaṇḍaḥ ||",
        padaccheda = "अस्ति उत्तरस्याम् दिशि देवता-आत्मा हिमालयः नाम नग-अधिराजः ।\nपूर्वा-अपरौ तोय-निधी विगाह्य स्थितः पृथिव्याः इव मान-दण्डः ॥",
        anvaya = "उत्तरस्यां दिशि देवतात्मा हिमालयः नाम नगाधिराजः अस्ति, यः पूर्वापरौ तोयनिधी विगाह्य पृथिव्याः मानदण्डः इव स्थितः।",
        pratipadartha = listOf(
          WordMeaning("अस्ति", "विद्यते वर्तते", "है / विद्यमान है", "Exists / stands", "अस् धातोः लट् प्रथमपुरुष एकवचनम्"),
          WordMeaning("उत्तरस्यां", "उदीच्यां दिशि", "उत्तर दिशा में", "In the northern quarter", "सप्तमी एकवचनम्"),
          WordMeaning("देवतात्मा", "देवस्वरूपः चिद्रूपः", "देवताओं के आत्मस्वरूप", "Divine-souled / of godly nature", "बहुव्रीहिसमासः"),
          WordMeaning("हिमालयो नाम", "हिमस्य आलयः इति ख्यातः", "हिमालय नामक", "Named Himalaya (abode of snow)", "षष्ठीतत्पुरुषसमासः"),
          WordMeaning("नगाधिराजः", "पर्वतानाम् अधिपतिः राजा", "पर्वतों का राजा (नगानाम् अधिराजः)", "King of mountains", "षष्ठीतत्पुरुषसमासः"),
          WordMeaning("पूर्वापरौ", "प्राच्य-प्रतीच्यावम्बुधी", "पूर्व और पश्चिम दिशा के", "Eastern and western", "द्वन्द्वसमासः"),
          WordMeaning("तोयनिधी", "समुद्रौ सागरौ", "दोनों समुद्रों में", "Two oceans (reservoirs of water)", "द्वितीया द्विवचनम्"),
          WordMeaning("विगाह्य", "प्रविश्य अवगाह्य", "अवगाहन करके / प्रवेश करके", "Having plunged / entered into", "वि + गाह् + ल्यप् प्रत्ययः"),
          WordMeaning("मानदण्डः इव", "मापनरज्जुः इव", "नापदण्ड (तराजू/पैमाना) के समान", "Like a measuring rod", "उपमावाचकः 'इव'")
        ),
        literalMeaningSa = "उत्तरस्यां दिशि देवात्मको हिमालयाख्यो भूधराणां राजा अस्ति, यः पूर्वपश्चिमसमुद्रयोः प्रवेशं कृत्वा भूमेः मानदण्ड इव शोभते।",
        literalMeaningHi = "उत्तर दिशा में देवताओं का आत्मस्वरूप हिमालय नामक पर्वतों का राजा विद्यमान है, जो पूर्व और पश्चिम दोनों महासागरों में प्रविष्ट होकर मानो पृथ्वी के नापदण्ड के समान स्थित है।",
        literalMeaningEn = "In the northern quarter stands the divine-souled king of mountains, named Himalaya, who, plunging into both the eastern and western oceans, stands as though he were the measuring rod of the earth.",
        interpretiveMeaningSa = "कालिदासः अचेतनं पाषाणमयं पर्वतमात्रं न वर्णयति, अपि तु देवतातत्त्वरूपं सजीवं विश्वस्य मापकं हिमालयं प्रतिष्ठापयति।",
        interpretiveMeaningHi = "कालिदास ने हिमालय को केवल पत्थर का पर्वत न कहकर 'देवतात्मा' और 'पृथ्वी का मानदण्ड' बताकर उसकी आध्यात्मिक दिव्यता और विराटता का अमर चित्रण किया है।",
        interpretiveMeaningEn = "Kalidasa personifies the Himalayas not as inert geological rock, but as an animate divine presence measuring the cosmic earth.",
        vyakhyaSa = "कुमारसम्भवस्य मङ्गलश्लोकोऽयम्। अत्र 'देवतात्मा' विशेषणेन साङ्ख्यवेदान्तसम्मतं चैतन्यं द्योत्यते। 'मानदण्ड इव' इत्यत्र उत्प्रेक्षा उपमा वा कल्प्यते।",
        vyakhyaHi = "कुमारसम्भव महाकाव्य का यह उद्घाटन श्लोक भारतीय संस्कृति में हिमालय की पावनता का मुकुटमणि है। यहाँ 'मानदण्ड इव' में क्रिया के योग से उत्प्रेक्षा और उपमा दोनों का सुन्दर संकर लक्षित होता है।",
        vyakhyaEn = "Celebrated opening verse of Kumārasambhava. The grand geographic metaphor depicts the mountain range connecting two vast oceans, setting the cosmic stage for the birth of Parvati.",
        alankaras = listOf(
          AlankaraItem(
            name = "उत्प्रेक्षा / उपमा (Utprekṣā / Upamā)",
            evidence = "'स्थितः पृथिव्या इव मानदण्डः'",
            reasoningSa = "अचेतने पर्वते पृथिवीमापनदण्डत्वस्य कविकल्पनावशात् सम्भावनं कृतम्।",
            reasoningHi = "विशाल पर्वत में पृथ्वी को नापने वाले दण्ड की कवित्वपूर्ण सम्भावना की गई है।",
            reasoningEn = "The vast mountain range is imaginatively envisioned as the surveyor's rod measuring the globe.",
            alternatives = "पूर्णोपमा (यथा मल्लिनाथेन व्याख्याता)",
            confidence = ConfidenceLevel.STRONGLY_SUPPORTED
          )
        ),
        rasa = RasaAnalysis(
          rasaName = "अद्भुतरसः / शान्तरसः (Marvellous / Sublime Sentiment)",
          sthayibhava = "विस्मयः (Wonder at the cosmic scale)",
          vibhavas = "आलम्बनम्: हिमालयपर्वतः; उद्दीपनम्: समुद्रविगाहनम्, गगनचुम्बी विस्तारः",
          anubhavas = "विस्मयोत्फुल्लनेत्रता, स्तवनम्",
          vyabhicaribhavas = "हर्षः, धृतिः, मतिः",
          aestheticRealization = "प्रकृतेः लोकोत्तरदिव्यरूपस्य साक्षात्कारः।",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        chhandas = ChhandasIdentification(
          meterName = "उपजातिः (Upajāti - त्रिष्टुप्)",
          syllablesPerPada = 11,
          ganaPattern = "इन्द्रवज्रोपेन्द्रवज्रयोः पादसङ्करः",
          laghuGuruPattern = "। ऽ । ऽ ऽ । । ऽ । ऽ ऽ  (उपेन्द्रवज्रा)\n। ऽ । ऽ ऽ । । ऽ । ऽ ऽ  (उपेन्द्रवज्रा)\nऽ ऽ । ऽ ऽ । । ऽ । ऽ ऽ  (इन्द्रवज्रा)\n। ऽ । ऽ ऽ । । ऽ । ऽ ऽ  (उपेन्द्रवज्रा)",
          lakshanaAttributed = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१३)",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        dhvaniAndPoetics = "माधुर्यौदार्ययुक्तः प्रसादगुणः; वैदर्भी रीतिः। वस्तुध्वनिः: पार्वतीजन्मोपयुक्तं दिव्यं स्थानम्।",
        grammaticalObservations = listOf(
          "अस्त्युत्तरस्याम् = अस्ति + उत्तरस्याम् (यण्सन्धिः)",
          "तोयनिधी = तोयस्य निधी (षष्ठीतत्पुरुषः, द्वितीया द्विवचनम्)",
          "विगाह्य = वि + गाहू विलोडने + ल्यप्"
        ),
        sourceStatus = "प्रमाणितम् (Verified Classical Source)",
        sourceWork = "कुमारसम्भवमहाकाव्यम् (सर्गः १, श्लोकः १)",
        sourceAuthor = "महाकवि-कालिदासः",
        researchSummary = ResearchSummary(
          strongestInterpretationSa = "हिमालयस्य आध्यात्मिकं भौगोलिकं च आधिपत्यं प्रतिपादितम्।",
          strongestInterpretationHi = "हिमालय की आध्यात्मिक दिव्यता और सम्पूर्ण आर्यावर्त की भौगोलिक सुरक्षा का अप्रतिम वर्णन।",
          strongestInterpretationEn = "Simultaneously asserts the spiritual divinity and geological supremacy of the Himalayas.",
          mostUncertainClaimSa = "किम् 'इव' शब्देन उपमा सिध्यति उत उत्प्रेक्षा? उभयोर्मतं शास्त्रेषु दृश्यते।",
          mostUncertainClaimHi = "क्या 'इव' से उपमा मानी जाए या उत्प्रेक्षा? टीकाकारों में दोनों पक्ष प्रमाणसहित मिलते हैं।",
          mostUncertainClaimEn = "Whether 'iva' here functions as pure simile or imaginative poetic supposition (utprekṣā).",
          researchQuestionSa = "कालिदासस्य काले समुद्रद्वयस्य (वङ्गोपसागर-अरबसागरयोः) प्रत्यक्षं ज्ञानं कीदृशमासीत्?",
          researchQuestionHi = "कालिदास के काल में दोनों समुद्रों (बंगाल की खाड़ी और अरब सागर) के विस्तार का भौगोलिक ज्ञान कितना विशद था?",
          researchQuestionEn = "How does this verse evidence classical geographical knowledge of the subcontinental coastlines?",
          expertReviewNotes = "सर्वप्राचीनटीकासु स्वीकृतः सर्वमान्यः पाठः। (Unanimously authenticated classical canon)."
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
            name = "अर्थान्तरन्यासः / सूक्तिः (Arthāntaranyāsa)",
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
      ),

      VerseAnalysis(
        id = "karmanyevadhikaraste",
        originalVerse = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
        transliteration = "karmaṇyevādhikāraste mā phaleṣu kadācana |\nmā karmaphalaheturbhūrmā te saṅgo'stvakarmaṇi ||",
        padaccheda = "कर्मणि एव अधिकारः ते मा फलेषु कदाचन ।\nमा कर्म-फल-हेतुः भूः मा ते सङ्गः अस्तु अकर्मणि ॥",
        anvaya = "ते कर्मणि एव अधिकारः (अस्ति), फलेषु कदाचन मा (अस्तु)। (त्वं) कर्मफलहेतुः मा भूः, अकर्मणि ते सङ्गः मा अस्तु।",
        pratipadartha = listOf(
          WordMeaning("कर्मणि", "कर्तव्यकर्मणि स्वधर्मे", "अपने निर्धारित कर्तव्य कर्म में", "In prescribed action/duty", "सप्तमी एकवचनम्"),
          WordMeaning("एव", "निश्चयेन केवलम्", "ही / केवल", "Alone / only", "अव्ययम्"),
          WordMeaning("अधिकारः", "योग्यता स्वातन्त्र्यं वा", "अधिकार / सामर्थ्य", "Title / right / prerogative", "प्रथमा एकवचनम्"),
          WordMeaning("ते", "तव हे अर्जुन", "तुम्हारा", "Your", "युष्मद् षष्ठी एकवचनम्"),
          WordMeaning("मा फलेषु", "कर्मफलेषु कदापि मा", "फलों में कभी नहीं", "Never in the fruits", "सप्तमी बहुवचनम्"),
          WordMeaning("कदाचन", "कदापि कस्मिंश्चिदपि काले", "कभी भी किसी काल में", "At any time / ever", "अव्ययम्"),
          WordMeaning("कर्मफलहेतुः", "कर्मफलस्य कारणम्", "कर्मफल की प्राप्ति का कारण", "Motivated by fruits of work", "बहुव्रीहिसमासः"),
          WordMeaning("मा भूः", "मा भव", "मत बनो", "Do not become", "भू धातुः लुङ् मध्यमपुरुष एकवचनम्"),
          WordMeaning("सङ्गः अकर्मणि", "आलस्ये कर्मत्यागे वा आसक्तिः", "कर्म न करने (अकर्म) में आसक्ति", "Attachment to inaction", "सप्तमी एकवचनम्")
        ),
        literalMeaningSa = "तव केवलं कर्तव्यकर्मणि एव अधिकारः अस्ति, तत्फलेषु तु कदापि नास्ति। त्वं कर्मफलस्य हेतुः मा भव, तथा च अकर्मणि (कर्मत्यागे) तव आसक्तिः मा भवतु।",
        literalMeaningHi = "तुम्हारा केवल कर्तव्य कर्म करने में ही अधिकार है, उसके फलों में कभी नहीं। तुम कर्मफल की तृष्णा वाले मत बनो और तुम्हारी अकर्मण्यता (कर्म न करने) में भी आसक्ति न हो।",
        literalMeaningEn = "Your right is to action alone, never to its fruits. Let not the fruit of action be your motive, nor let your attachment be to inaction.",
        interpretiveMeaningSa = "भगवद्गीतायाः निष्कामकर्मयोगस्य परमं रहस्यम्। फलतृष्णाविहीनं क्रियमाणं कर्मैव मोक्षसाधनं चित्तशुद्धिकरं च भवति।",
        interpretiveMeaningHi = "श्रीमद्भगवद्गीता का निष्काम कर्मयोग दर्शन: कर्म करना मनुष्य का कर्तव्य है, फल की चिन्ता त्याग कर किया गया कार्य ही मनुष्य को बन्धनमुक्त करता है।",
        interpretiveMeaningEn = "The bedrock of Karma Yoga: selfless action performed without egoistic thirst for results frees the mind from psychological bondage.",
        vyakhyaSa = "अयं श्लोकः भारतीयदर्शनस्य मेरुदण्डः। चतुर्षु पादेषु चत्वारि मूलतत्त्वानि सन्ति—(१) कर्मकर्तव्यता, (२) फलविरागः, (३) अकर्तृत्वभावः, (४) अकर्मत्यागः।",
        vyakhyaHi = "गीता के द्वितीय अध्याय का यह श्लोक निष्काम कर्मयोग का सारभूत महावाक्य है। इसमें चार स्पष्ट चरण हैं: कर्म में अधिकार, फल की आसक्ति का निषेध, फलहेतु न बनना, और अकर्मण्यता का सर्वथा त्याग।",
        vyakhyaEn = "The philosophical core of the Bhagavad Gita expounding detachment from results while maintaining energetic commitment to duty.",
        alankaras = listOf(
          AlankaraItem(
            name = "छेकानुप्रासः / उल्लेखः / आक्षेपः (Akṣepa)",
            evidence = "'मा... मा... मा...'",
            reasoningSa = "निषेधवाचकस्य 'मा' शब्दस्य त्रिवारं प्रयोगात् विधिमुखेन कर्तव्यस्थापनम्।",
            reasoningHi = "निषेधवाचक 'मा' के तीन बार प्रयोग द्वारा कर्तव्यपरायणता का दृढ़ीकरण।",
            reasoningEn = "Triple emphatic negation reinforcing positive resolve for duty.",
            alternatives = "काव्यलिङ्गम्",
            confidence = ConfidenceLevel.STRONGLY_SUPPORTED
          )
        ),
        rasa = RasaAnalysis(
          rasaName = "शान्तरसः / धर्मवीरः",
          sthayibhava = "धैर्यम् / उत्साहः",
          vibhavas = "कुरुक्षेत्रयुद्धभूमिः, श्रीकृष्णार्जुनसंवादः",
          anubhavas = "उपदेशप्रदानम्, शोकनिवारणम्",
          vyabhicaribhavas = "धृतिः, मतिः, विबोधः, निर्वेदः",
          aestheticRealization = "अलौकिककर्तव्यबोधः।",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        chhandas = ChhandasIdentification(
          meterName = "अनुष्टुप् (श्लोकः / Anustubh)",
          syllablesPerPada = 8,
          ganaPattern = "पञ्चमं लघु सर्वत्र, षष्ठं गुरु",
          laghuGuruPattern = "ऽ । ऽ ऽ । ऽ ऽ ऽ  ।  ऽ । । । ऽ । ऽ\nऽ ऽ । । । ऽ ऽ ऽ  ।  ऽ ऽ । । ऽ । ऽ",
          lakshanaAttributed = "केदारभट्टकृत-वृत्तरत्नाकरः (२.२)",
          confidence = ConfidenceLevel.STRONGLY_SUPPORTED
        ),
        dhvaniAndPoetics = "आर्ष-प्रासादिका वाणी; वस्तुध्वनिः: कर्तृत्वं भगवदर्पितं कृत्वा कर्म कर्तव्यमिति।",
        grammaticalObservations = listOf(
          "कर्मण्येवाधिकारस्ते = कर्मणि + एव + अधिकारः + ते (यण्सन्धिः, विसर्गसन्धिः)",
          "सङ्गोऽस्त्वकर्मणि = सङ्गः + अस्तु + अकर्मणि (उत्वसन्धिः, पूर्वरूपसन्धिः, यण्सन्धिः)"
        ),
        sourceStatus = "प्रमाणितम् (Verified Classical Source)",
        sourceWork = "श्रीमद्भगवद्गीता (अध्यायः २, श्लोकः ४७)",
        sourceAuthor = "महर्षि-वेदव्यासः",
        researchSummary = ResearchSummary(
          strongestInterpretationSa = "फलसङ्गरहितं कर्तव्यपालनमेव योगः।",
          strongestInterpretationHi = "फल की आसक्ति से रहित होकर केवल कर्तव्य भाव से कार्य करना ही योग है।",
          strongestInterpretationEn = "Action performed purely as unselfish dedication without anxiety for personal return.",
          mostUncertainClaimSa = "किम् अकर्मणि फलत्यागः अकर्मण्यतां पोषयति? नहि, 'मा ते सङ्गोऽस्त्वकर्मणि' इत्यनेन स्पष्टं वारितम्।",
          mostUncertainClaimHi = "क्या फल की इच्छा न करने से निष्क्रियता आती है? नहीं, 'अकर्मणि सङ्ग मा अस्तु' से निष्क्रियता का स्पष्ट खण्डन है।",
          mostUncertainClaimEn = "Whether disinterest in outcomes breeds complacency; categorically refuted by the final pada prohibiting inaction.",
          researchQuestionSa = "शङ्कराचार्य-रामानुजाचार्य-मध्वाचार्याणां भाष्येषु अस्य श्लोकस्य अर्थवैविध्यं कीदृशम्?",
          researchQuestionHi = "शङ्कर, रामानुज और मध्व के भाष्यों में इस श्लोक की व्याख्या में क्या विशिष्ट भेद हैं?",
          researchQuestionEn = "How do the classical Vedantic commentaries differ on the synthesis of jñāna and karma here?",
          expertReviewNotes = "विश्वविश्रुतोऽयं श्लोकः। (Universally accepted sacred scripture)."
        )
      )
    )
  }
}
