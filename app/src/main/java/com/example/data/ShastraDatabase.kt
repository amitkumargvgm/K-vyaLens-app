package com.example.data

import com.example.model.ShastraTopic
import com.example.model.TopicClassification
import com.example.model.TopicDefinition

object ShastraDatabase {

  val list: List<ShastraTopic> by lazy {
    listOf(
      ShastraTopic(
        id = "rasa",
        term = "रसः",
        termIast = "Rasa",
        category = "रससिद्धान्तः / नाट्यशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'रस्यते आस्वाद्यते इति रसः' (रस् आस्वादने धातुः + अच् प्रत्ययः)। 'रसयति आनन्दयति सहृदयहृदयं स रसः'। यथा षड्रसाः (मधुराम्लादयः) जिह्वया आस्वाद्यन्ते, तथैव काव्यनाट्ययोः विभावानुभावव्यभिचारिभिः अभिव्यक्तः स्थायीभावः सहृदयहृदयेन आस्वाद्यते, तस्मात् रस इत्युच्यते।",
        definitions = listOf(
          TopicDefinition(
            text = "विभावानुभावव्यभिचारिसंयोगाद्रसनिष्पत्तिः।",
            author = "भरतमुनिः",
            work = "नाट्यशास्त्रम् (षष्ठाध्यायः - रससूत्रम्)",
            meaningSa = "विभावानाम् (कारणानाम्), अनुभावानाम् (कार्याणाम्), व्यभिचारिभावानां (सहकारिणां) च संयोगात् सहृदये स्थायीभावस्य रसत्वेन निष्पत्तिः (अभिव्यक्तिः/आस्वादः) भवति।",
            meaningHi = "विभाव (कारण), अनुभाव (कार्य) और व्यभिचारी भावों (संचारी भावों) के संयोग से सहृदय के हृदय में स्थित स्थायी भाव का रस रूप में आस्वाद (निष्पत्ति) होता है।",
            meaningEn = "Through the union of determinants (Vibhāva), consequents (Anubhāva), and transitory emotional states (Vyabhicāribhāva), the aesthetic sentiment (Rasa) is realized."
          ),
          TopicDefinition(
            text = "वाक्यं रसात्मकं काव्यम्।",
            author = "विश्वनाथकविराजः",
            work = "साहित्यदर्पणः (प्रथमपरिच्छेदः)",
            meaningSa = "रस एव आत्मा यस्य तादृशं वाक्यमेव काव्यं भवति। रसहीनं वाक्यं तु शुष्कवार्तैव।",
            meaningHi = "रसयुक्त वाक्य ही वास्तविक काव्य है; रस ही काव्य की आत्मा है।",
            meaningEn = "Poetry is a sentence whose soul is Rasa (aesthetic relish)."
          ),
          TopicDefinition(
            text = "कारणान्यथ कार्याणि सहकारीणि यानि च।\nरत्यादेः स्थायिनो लोके तानि चेन्नाट्यकाव्ययोः॥\nविभावा अनुभावास्तत्कथ्यन्ते व्यभिचारिणः।\nव्यक्तः स तैर्विभावाद्यैः स्थायी भावो रसः स्मृतः॥",
            author = "मम्मटभट्टः",
            work = "काव्यप्रकाशः (चतुर्थोल्लासः)",
            meaningSa = "लोके यानि रत्यादीनां कारणानि तानि काव्ये विभावाः, यानि कार्याणि तानि अनुभावाः, यानि सहकारिकारणानि तानि व्यभिचारिणः; तैः अभिव्यक्तः स्थायीभावः रसः।",
            meaningHi = "लोक में जो रति आदि के कारण हैं वे काव्य में विभाव, कार्य अनुभाव और सहकारी कारण व्यभिचारी कहलाते हैं; उनसे अभिव्यक्त स्थायी भाव ही रस कहलाता है।",
            meaningEn = "What in real life are causes, effects, and assisting conditions of emotions become in poetry Vibhāvas, Anubhāvas, and Vyabhicārins; the permanent state made manifest through them is Rasa."
          )
        ),
        svarupaSa = "रसः अलौकिकः आनन्दस्वरूपः, ब्रह्मानन्दसहोदरः, स्वप्रकाशानन्दचिन्मयः। अयम् अखण्डः, स्वसंवेद्यः, वेद्यान्तरसम्पर्कशून्यश्च वर्तते।",
        svarupaHi = "रस अलौकिक, स्वप्रकाश, चिन्मय और ब्रह्मानन्द सहोदर (ब्रह्मानन्द के समान आनन्दमयी अनुभूति) है। यह सांसारिक सुख-दुःख से परे विशुद्ध आनन्द की अवस्था है।",
        svarupaEn = "Rasa is transcendental, self-luminous, bliss-imbued, akin to spiritual absorption (Brahmānanda-sahodara), transcending empirical sorrow or pleasure into pure contemplation.",
        classifications = listOf(
          TopicClassification("शृङ्गाररसः", "स्थायीभावः रतिः; भेदाः—सम्भोगः विप्रलम्भश्च", "स्थायी भाव रति; दो भेद: सम्भोग और विप्रलम्भ", "Erotic/Amorous; Sthāyī: Rati; Types: Union & Separation"),
          TopicClassification("हास्यरसः", "स्थायीभावः हासः; आत्मस्थः परस्थश्च; षड्भेदाः (स्मित, हसित, विहसित, उपहसित, अपहसित, अतिहसित)", "स्थायी भाव हास; विकृत वाणी, वेष, चेष्टा से उत्पन्न", "Comic; Sthāyī: Hāsa; Six degrees of laughter"),
          TopicClassification("करुणरसः", "स्थायीभावः शोकः; इष्टजनवियोग-अनिष्टप्राप्तिभ्यां जायते", "स्थायी भाव शोक; प्रियजन का वियोग या अनिष्ट होने पर", "Pathetic/Compassionate; Sthāyī: Śoka"),
          TopicClassification("रौद्ररसः", "स्थायीभावः क्रोधः; शत्रुकृत-अपकारैः उत्पद्यते", "स्थायी भाव क्रोध; शत्रु के अपराध या अपमान से उत्पन्न", "Furious; Sthāyī: Krodha"),
          TopicClassification("वीररसः", "स्थायीभावः उत्साहः; भेदाः—दानवीरः, धर्मवीरः, युद्धवीरः, दयावीरः", "स्थायी भाव उत्साह; चार भेद: दान, धर्म, युद्ध और दयावीर", "Heroic; Sthāyī: Utsāha; 4 types: Generosity, Righteousness, War, Mercy"),
          TopicClassification("भयानकवीर-बीभत्स-अद्भुत-शान्ताः", "स्थायीभावाः—भयं, जुगुप्सा, विस्मयः, शमश्च (शान्तरसस्य)", "भय, जुगुप्सा, विस्मय और शम स्थायी भाव वाले रस", "Terrible, Odious, Marvellous, and Tranquil (Śānta with Śama)")
        ),
        illustrativeVerse = "शून्यं वासगृहं विलोक्य शयनादुत्थाय किञ्चिच्छनैः\nनिद्राव्याजमुपागतस्य सुचिरं निर्वर्ण्य पत्युर्मुखम्।\nविश्रब्धं परिचुम्ब्य जातपुलकामालोक्य गण्डस्थलीं\nलज्जानम callमुखि प्रियेण हसता बाला चिरं चुम्बिता॥",
        illustrativeVerseSource = "अम dealशतकम् (काव्यप्रकाशे शृङ्गारोदाहरणम्)",
        illustrativeExplanationSa = "अत्र मुग्धा नायिका नायकश्च आलम्बनविभावौ, शून्यं वासगृहं उद्दीपनम्, मुखनिरीक्षण-चुम्बनादयः अनुभावाः, लज्जादयः व्यभिचारिणः; एतैः सम्भोगशृङ्गारस्य पूर्णपरिपोषः।",
        illustrativeExplanationHi = "यहाँ नायिका और नायक आलम्बन विभाव हैं, सूना शयनकक्ष उद्दीपन विभाव है, मुख देखना और चुम्बन अनुभाव हैं, लज्जा व हर्ष व्यभिचारी भाव हैं; इनसे सम्भोग शृङ्गार रस की निष्पत्ति होती है।",
        illustrativeExplanationEn = "Depicts Sambhoga Śṛṅgāra (erotic sentiment in union): the lovers are the focal determinants, empty chamber the excitant, shy glances and kisses the consequents, and bashfulness the transitory emotion."
      ),

      ShastraTopic(
        id = "dhvani",
        term = "ध्वनिः",
        termIast = "Dhvani",
        category = "ध्वनिसिद्धान्तः / काव्यशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'ध्वनति व्यनक्ति गूढमर्थं स ध्वनिः', अथवा 'ध्वन्यते इति ध्वनिः' (ध्वन् शब्दे धातुः + इन्/इ प्रत्ययः)। वैयाकरणानां स्फोटप्रतिपादक-ध्वनेः सादृश्येन आनन्दवर्धनेन काव्ये वाच्यार्थापेक्षया चमत्कारिणः व्यङ्ग्यार्थस्य बोधको ध्वनिः प्रतिपादितः।",
        definitions = listOf(
          TopicDefinition(
            text = "काव्यस्यात्मा ध्वनिः।",
            author = "आनन्दवर्धनाचार्यः",
            work = "ध्वन्यालोकः (प्रथम उद्योतः)",
            meaningSa = "यथा शरीरस्य आत्मा चेतन्यं भवति, तथैव काव्यशरीरस्य (शब्दार्थयोः) मुख्यसारभूतः आभ्यन्तरोऽर्थः ध्वनिरूपो व्यङ्ग्यार्थ एव।",
            meaningHi = "ध्वनि ही काव्य की आत्मा है; शब्द और अर्थ काव्य का शरीर हैं तथा व्यङ्ग्यार्थ उसकी आत्मा है।",
            meaningEn = "Dhvani (suggestive resonance) is the soul of poetry; word and literal sense constitute only its external body."
          ),
          TopicDefinition(
            text = "यत्रार्थः शब्दो वा तमर्थमुपसर्जनीकृतस्वार्थौ।\nव्यङ्क्तः काव्यविशेषः स ध्वनिरिति सूरिभिः कथितः॥",
            author = "आनन्दवर्धनाचार्यः / मम्मटभट्टः",
            work = "ध्वन्यालोकः (१.१३) / काव्यप्रकाशः (१.४)",
            meaningSa = "यत्र वाच्यार्थः शब्दश्च स्वं गौणीकृत्य चमत्कारयुक्तं व्यङ्ग्यार्थं प्रकाशयतः, स उत्तमोत्तमः काव्यप्रभेदः ध्वनिरिति विद्वद्भिः उच्यते।",
            meaningHi = "जहाँ वाच्यार्थ अथवा वाचक शब्द अपने को गौण बनाकर किसी विशिष्ट रमणीय व्यङ्ग्यार्थ को प्रकाशित करते हैं, उस काव्य-विशेष को विद्वानों ने 'ध्वनि' कहा है।",
            meaningEn = "That exquisite poetry wherein both literal sense and primary word subordinate themselves to reveal a resonant suggested meaning is termed Dhvani by the masters."
          )
        ),
        svarupaSa = "वाच्यार्थस्य अतिक्रमणं कृत्वा व्यञ्जनाशक्त्या यः सहृदयहृदयसंवेद्यः गूढश्चमत्कारः प्रतीयते स एव ध्वनेः स्वरूपम्।",
        svarupaHi = "वाच्यार्थ को लांघकर व्यञ्जना शक्ति द्वारा जिस गूढ़ और हृदयग्राही चमत्कार की अनुभूति होती है, वही ध्वनि का स्वरूप है।",
        svarupaEn = "The subtle poetic essence unveiled through suggestion (vyañjanā) that transcends literal sense to evoke profound aesthetic delight." ,
        classifications = listOf(
          TopicClassification("अवविक्षितवाच्यध्वनिः (लक्षणाactionमूलः)", "यत्र वाच्यार्थः उपेक्षितः; द्वौ भेदौ: अर्थान्तरसङ्क्रमितवाच्यः अत्यन्ततिरस्कृतवाच्यश्च", "जहाँ वाच्यार्थ विवक्षित न हो; दो भेद: अर्थान्तरसंक्रमित और अत्यन्ततिरस्कृत", "Suggestion rooted in indicative sense (Lakṣaṇāmūla)"),
          TopicClassification("विवक्षितान्यपरवाच्यध्वनिः (अभिधामूलः)", "यत्र वाच्यार्थो विवक्षितः सन् व्यङ्ग्यार्थं प्रति पर्यवस्यति; द्वौ भेदौ: असंलक्ष्यक्रमव्यङ्ग्यः संलक्ष्यक्रमव्यङ्ग्यश्च", "जहाँ वाच्यार्थ रहते हुए भी व्यङ्ग्यार्थ प्रधान हो; असंलक्ष्यक्रम और संलक्ष्यक्रम", "Suggestion rooted in primary sense (Abhidhāmūla)"),
          TopicClassification("रसध्वनिः (असंलक्ष्यक्रमः)", "विभावादिभ्यः रसप्रतीतिः इतिक्षणमात्रेण जायते यत्र पौर्वापर्यक्रमो न लक्ष्यते; अयमेव काव्यस्य सारः", "विभाव आदि से रस की प्रतीति इतनी शीघ्र होती है कि क्रम लक्षित नहीं होता; यह काव्य का परम सार है", "Instantaneous aesthetic suggestion (Asaṃlakṣya-krama), the pinnacle of poetic art")
        ),
        illustrativeVerse = "भम धम्मिअ वीसद्धो सो सुणओ अज्ज मारिओ तेण।\nगोलाणइकच्छकुडङ्गवासिणा दप्पसीहेण॥",
        illustrativeVerseSource = "गाथासप्तशती (काव्यप्रकाशे अत्यन्ततिरस्कृत/विवक्षितान्यपर-व्यञ्जनायाः उदाहरणम्)",
        illustrativeExplanationSa = "अत्र वाच्यार्थेन भ्रमणाय आज्ञा दीयते, किन्तु व्यङ्ग्यार्थेन गोदावरीतीरे सिंहभयात् मा गच्छेति निषेधः प्रतीयते।",
        illustrativeExplanationHi = "यहाँ वाच्यार्थ में धार्मिक व्यक्ति को निर्भय होकर भ्रमण करने का उपदेश दिया गया है, परन्तु व्यङ्ग्यार्थ यह निकलता है कि गोदावरी तट पर सिंह है अतः वहाँ मत जाओ (विधि से निषेध का व्यंग्य)।",
        illustrativeExplanationEn = "Literally encouraging a monk to wander freely because the dog is killed, it subtly suggests that a fierce lion now lurks on the riverbank—prohibiting entry via apparent invitation."
      ),

      ShastraTopic(
        id = "upama",
        term = "उपमा",
        termIast = "Upama",
        category = "अर्थालङ्कारः / अलङ्कारशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'उपमीयते सादृश्यं प्रमीयते अनया इति उपमा' (उप उपसर्गपूर्वक माङ् माने धातुः + अङ् प्रत्ययः + टाप् स्त्रीप्रत्ययः)। उप = सामीप्येन, मा = मानम् (तुलना)। द्वयोः भिन्नयोः वस्तुनोः सादृश्यवर्णनमुपमा।",
        definitions = listOf(
          TopicDefinition(
            text = "साधर्म्यमुपमा भेदे।",
            author = "मम्मटभट्टः",
            work = "काव्यप्रकाशः (दशमोल्लासः)",
            meaningSa = "उपमानोपमेययोः वस्तुतः भेदे (भिन्नत्वे) सत्यपि तयोः गुणक्रियादिरूपस्य साधर्म्यस्य (समानधर्मस्य) यत् प्रतिपादनं तद् उपमा।",
            meaningHi = "उपमेय और उपमान में वस्तुतः भेद रहने पर भी जहाँ दोनों के बीच गुण या क्रिया रूपी साधर्म्य (समानता) का रमणीय वर्णन हो, वहाँ उपमा अलङ्कार होता है।",
            meaningEn = "Upamā is the similitude between two fundamentally different entities (Upameya and Upamāna) based on common attribute or action."
          ),
          TopicDefinition(
            text = "साम्यं वाच्यमवैधर्म्यं वाक्यैक्य उपमा द्वयोः।",
            author = "विश्वनाथकविराजः",
            work = "साहित्यदर्पणः (दशमपरिच्छेदः)",
            meaningSa = "द्वयोः वस्तुनोः वैधर्म्यरहितं स्पष्टं वाच्यं साम्यम् उपमा प्रोच्यते।",
            meaningHi = "एक ही वाक्य में दो भिन्न पदार्थों के स्पष्ट और वैधर्म्य-रहित सादृश्य के कथन को उपमा कहते हैं।",
            meaningEn = "Upamā is an explicitly stated likeness between two objects within a syntactically unified statement."
          )
        ),
        svarupaSa = "उपमायाः चत्वारि अङ्गानि भवन्ति—(१) उपमेयम् (प्रकृतं वस्तु), (२) उपमानम् (अप्रकृतं प्रसिद्धं वस्तु), (३) साधारणधर्मः (समानगुणः/क्रिया), (४) उपमाप्रतिपादकः शब्दः (इव, यथा, सदृशः, तुल्यः इत्यादयः)।",
        svarupaHi = "उपमा के चार प्रमुख अंग होते हैं: उपमेय (जिसकी तुलना की जाए), उपमान (जिस प्रसिद्ध वस्तु से तुलना हो), साधारण धर्म (समान गुण या क्रिया), और वाचक शब्द (इव, यथा, सम, समान)।",
        svarupaEn = "Upamā possesses four essential constituents: Upameya (subject of comparison), Upamāna (standard of comparison), Sādhāraṇa-dharma (common property), and Vācaka (comparative particle like 'iva', 'yathā').",
        classifications = listOf(
          TopicClassification("पूर्णोपमा", "यत्र चतुर्णामप्यङ्गानां (उपमेय-उपमान-धर्म-वाचकानाम्) स्पष्टमुपादानं भवति", "जहाँ चारों अंगों का स्पष्ट उल्लेख हो", "Complete Simile; all 4 elements are explicitly present"),
          TopicClassification("लुप्तोपमा", "यत्र एकस्य, द्वयोः, त्रयाणां वा अङ्गानां लोपो भवति; धर्मलुप्ता, वाचकलुप्ता, उपमानलुप्तादयः", "जहाँ एक, दो या तीन अंगों का लोप हो", "Elliptical Simile; one or more elements are omitted"),
          TopicClassification("मालोपमा", "यत्र एकस्यैव उपमेयस्य बहूनि उपमानानि भवन्ति", "जहाँ एक ही उपमेय के लिए अनेक उपमान दिए जाएँ", "Garland Simile; multiple standards for a single subject")
        ),
        illustrativeVerse = "वागर्थाविव सम्पृक्तौ वागर्थप्रतिपत्तये।\nजगतः पितरौ वन्दे पार्वतीपरमेश्वरौ॥",
        illustrativeVerseSource = "कालिदासकृत-रघुवंशम् (१.१)",
        illustrativeExplanationSa = "अत्र पार्वतीपरमेश्वरौ उपमेयं, वागर्थौ उपमानं, सम्पृक्तत्वं साधारणधर्मः, 'इव' शब्दः उपमावाचकः। अतः इयं पूर्णा श्रौती उपमा।",
        illustrativeExplanationHi = "यहाँ पार्वती-परमेश्वर उपमेय हैं, वाणी और अर्थ उपमान हैं, नित्य जुड़ा होना साधारण धर्म है और 'इव' वाचक शब्द है; चारों अंग उपस्थित होने से यह पूर्णोपमा का उत्कृष्ट उदाहरण है।",
        illustrativeExplanationEn = "Parvati and Shiva are Upameya, word and meaning are Upamāna, indivisible union is the common property, and 'iva' is the comparative particle—making it a perfect Pūrṇopamā."
      ),

      ShastraTopic(
        id = "rupaka",
        term = "रूपकम्",
        termIast = "Rupaka",
        category = "अर्थालङ्कारः / अलङ्कारशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'रूप्यते आरोप्यते रूपमस्मिन् इति रूपकम्' (रूप् धातुः + णिच् + कन्/ण्वुल् प्रत्ययः)। उपमेये उपमानस्य अभेदरोपणं रूपकम्।",
        definitions = listOf(
          TopicDefinition(
            text = "तद्रूपकमभेदो य उपमानोपमेययोः।",
            author = "मम्मटभट्टः",
            work = "काव्यप्रकाशः (दशमोल्लासः)",
            meaningSa = "यत्र उपमानस्य उपमेयस्य च मध्ये अतिसादृश्यात् भेदं तिरोधाय अभेदः प्रतिपाद्यते तत् रूपकम्।",
            meaningHi = "जहाँ अत्यधिक सादृश्य के कारण उपमेय में उपमान का अभेद (एकरूपता) आरोपित किया जाए, वहाँ रूपक अलङ्कार होता है।",
            meaningEn = "Rūpaka is the poetic superimposition of non-difference (identity) between the Upamāna and the Upameya."
          ),
          TopicDefinition(
            text = "उपमानोपमेयस्य सतोरेवानुयोगिना।\nअभेदारोपणं यत्तु रूपकं तन्निगद्यते॥",
            author = "विश्वनाथकविराजः",
            work = "साहित्यदर्पणः (दशमपरिच्छेदः)",
            meaningSa = "उपमानोपमेययोः अभेदकथनं रूपकम्।",
            meaningHi = "उपमान और उपमेय के बीच भेद को भुलाकर अभेद स्थापित करना रूपक है।",
            meaningEn = "The metaphoric projection of identical form onto the subject."
          )
        ),
        svarupaSa = "उपमायां सादृश्यं वाच्यं भवति (मुखं चन्द्र इव), रूपके तु अभेदः आरोप्यते (मुखमेव चन्द्रः)।",
        svarupaHi = "उपमा में समानता कही जाती है (मुख चन्द्रमा जैसा है), परन्तु रूपक में दोनों को एक मान लिया जाता है (मुख ही चन्द्रमा है)।",
        svarupaEn = "Unlike simile which asserts likeness ('face like the moon'), metaphor asserts identity ('face is indeed the moon').",
        classifications = listOf(
          TopicClassification("साङ्गरूपकम्", "यत्र प्रकृतस्य अङ्गानाम् अपि उपमानाङ्गेषु आरोपः क्रियते", "जहाँ मुख्य उपमेय के साथ-साथ उसके अंगों पर भी उपमान के अंगों का आरोप हो", "Composite Metaphor with subsidiary attributes"),
          TopicClassification("निरङ्गरूपकम्", "यत्र केवलस्य अङ्गशून्यस्य मुख्यवस्तुनः आरोपो भवति", "जहाँ केवल प्रधान उपमेय पर उपमान का आरोप हो बिना सहायक अंगों के", "Simple Metaphor without subsidiary attributes"),
          TopicClassification("परम्परितरूपकम्", "यत्र एकं रूपकमपरस्य रूपकस्य कारणं भवति", "जहाँ एक आरोप दूसरे आरोप का कारण बने", "Chained Metaphor wherein one projection causes another")
        ),
        illustrativeVerse = "अविदितगुणापि सत्कविभणितिः कर्णेषु वमति मधुधाराम्।\nअनधिगतपरिमलापि हि हरति दृशं मालतीमाला॥",
        illustrativeVerseSource = "काव्यकौतुकम्",
        illustrativeExplanationSa = "अत्र वाणीषु सुधाधारायाः आरोपः।",
        illustrativeExplanationHi = "यहाँ सत्कवियों की वाणी में अमृतधारा का आरोप किया गया है।",
        illustrativeExplanationEn = "Poetic utterances are directly identified with streams of nectar pouring into the ears."
      ),

      ShastraTopic(
        id = "utpreksa",
        term = "उत्प्रेक्षा",
        termIast = "Utpreksa",
        category = "अर्थालङ्कारः / अलङ्कारशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'उत्प्रेक्ष्यते तर्क्यते संभाव्यते इति उत्प्रेक्षा' (उद् उपसर्ग + प्र उपसर्ग + ईक्ष् दर्शने धातुः + अङ् प्रत्ययः + टाप्)। उद् = ऊर्ध्वं प्रकृष्टं वा, ईक्षा = विचारः सम्भावना वा। उपमेयस्य उपमानरूपेण सम्भावनमुत्प्रेक्षा।",
        definitions = listOf(
          TopicDefinition(
            text = "संभावनमथोत्प्रेक्षा प्रकृतस्य परेण यत्।",
            author = "मम्मटभट्टः",
            work = "काव्यप्रकाशः (दशमोल्लासः)",
            meaningSa = "प्रकृतस्य (उपमेयस्य) परेण (उपमानेन) सह यत् सम्भावनं (कविकल्पनावशात् सम्भावना/तर्कः) सा उत्प्रेक्षा।",
            meaningHi = "उपमेय (प्रकृत वस्तु) की उपमान (अप्रकृत वस्तु) के रूप में सम्भावना या कल्पना करना उत्प्रेक्षा अलङ्कार कहलाता है।",
            meaningEn = "Utprekṣā is the poetic supposition (sambhavanā) of the subject (Upameya) in the form of the comparison (Upamāna)."
          )
        ),
        svarupaSa = "अत्र 'मन्ये', 'शङ्के', 'ध्रुवम्', 'प्रायेण', 'नूनम्', 'इव' (क्रियायोगे) इत्यादीनि सम्भावनाद्योतकानि पदानि भवन्ति।",
        svarupaHi = "उत्प्रेक्षा में प्रायः मन्ये, शङ्के, ध्रुव, प्रायः, नूनम्, जानो, मानो जैसे सम्भावना-सूचक शब्दों का प्रयोग होता है।",
        svarupaEn = "Characterized by expressive terms indicating speculative imagination: manye, śaṅke, dhruvam, prāyeṇa, nūnam, iva.",
        classifications = listOf(
          TopicClassification("वाच्योत्प्रेक्षा", "यत्र सम्भावनाप्रतिपादकाः शब्दाः (मन्ये, शङ्के, इव) प्रयुक्ताः भवन्ति", "जहाँ सम्भावना-सूचक शब्द स्पष्ट प्रयुक्त हों", "Explicit Poetic Supposition"),
          TopicClassification("प्रतीयमानोत्प्रेक्षा", "यत्र वाचकशब्दाभावेऽपि अर्थसामर्थ्यात् सम्भावना प्रतीयते", "जहाँ बिना वाचक शब्द के केवल अर्थ से सम्भावना झलके", "Implicit Poetic Supposition"),
          TopicClassification("हेतूत्प्रेक्षा व फलोत्प्रेक्षा", "अहेतौ हेतुत्वस्य, अफले च फलत्वस्य सम्भावनम्", "अकारण में कारण और अफल में फल की कल्पना", "Supposition of cause or purpose")
        ),
        illustrativeVerse = "लिम्पतीव तमोऽङ्गानि वर्षतीवाञ्जनं नभः।\nअसत्पुरुषसेवेव दृष्टिर्विफलतां गता॥",
        illustrativeVerseSource = "मृच्छकटिकम् (१.३४) / भामह-दण्डिनौ",
        illustrativeExplanationSa = "अत्र अन्धकारस्य लेपनक्रियात्वेन सम्भावना कृता, अतः क्रियोत्प्रेक्षा।",
        illustrativeExplanationHi = "यहाँ अन्धकार मानो अंगों पर लेप कर रहा है और आकाश मानो काजल बरसा रहा है—इस प्रकार लेपन और वर्षण की सम्भावना की गई है।",
        illustrativeExplanationEn = "Darkness as though besmears the limbs, the sky as though rains collyrium—vivid poetic supposition of impossible actions."
      ),

      ShastraTopic(
        id = "vakrokti",
        term = "वक्रोक्तिः",
        termIast = "Vakrokti",
        category = "वक्रोक्तिसिद्धान्तः / काव्यशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'वक्रा उक्तिः वक्रोक्तिः' (वक्र विशेषणम् + वच् परिभाषणे धातुः + क्तिन् प्रत्ययः)। वक्र = लोकवार्तातिक्रान्तं वैदग्ध्यपूर्णं चमत्कारि, उक्ति = कथनम्। लोकव्यवहारातिक्रान्तगोचरं लोकोत्तरवर्णनमेव वक्रोक्तिः।",
        definitions = listOf(
          TopicDefinition(
            text = "वक्रोक्तिः काव्यजीवितम्।",
            author = "कुन्तकाचार्यः",
            work = "वक्रोक्तिजीवितम् (प्रथम उन्मेषः)",
            meaningSa = "वैदग्ध्यभङ्गीभणितिरूपा वक्रोक्तिरेव काव्यस्य प्राणभूता भवति।",
            meaningHi = "विद्वत्तापूर्ण चमत्कारिक विलक्षण कथन (वक्रोक्ति) ही काव्य का वास्तविक जीवन (प्राण) है।",
            meaningEn = "Vakrokti—artful, deviating, striking poetic expression—is the very life-breath of poetry."
          ),
          TopicDefinition(
            text = "सैषा सर्वैव वक्रोक्तिरनयार्थो विभाव्यते।\nयत्नोऽस्यां कविना कार्यः कोऽलङ्कारोऽनया विना॥",
            author = "भामहः",
            work = "काव्यालङ्कारः (२.८५)",
            meaningSa = "समस्तेषु अलङ्कारेषु वक्रोक्तिरेव मूलम्, अनया विना कोऽपि अलङ्कारो न सिध्यति।",
            meaningHi = "सम्पूर्ण अलङ्कारों के मूल में वक्रोक्ति ही है, इसी से अर्थ की शोभा निखरती है; इसके बिना कोई अलङ्कार सम्भव नहीं।",
            meaningEn = "All embellishments are permeated by Vakrokti, which illumines the poetic sense; what ornament can exist without it?"
          )
        ),
        svarupaSa = "कविकर्मप्रौढिनिष्पन्ना लोकोत्तरा वैदग्ध्यभङ्गीभणितिरेव वक्रोक्तिः।",
        svarupaHi = "कवि की प्रतिभा से उत्पन्न लोक-प्रचलित सामान्य भाषा से भिन्न विशिष्ट सौन्दर्यमयी उक्ति ही वक्रोक्ति है।",
        svarupaEn = "Creative aesthetic obliquity that elevates ordinary speech into transcendent art through imaginative craftsmanship.",
        classifications = listOf(
          TopicClassification("वर्णविन्यासवक्रता", "अनुप्रासादिषु वर्णानां विशिष्टा योजना", "वर्णों का चमत्कारी विन्यास", "Phonetic / alliterative artifice"),
          TopicClassification("पदपूर्वार्धवक्रता", "धातौ प्रातिपदिके वा विशिष्टा चमत्कारिणी योजना", "मूल शब्द या धातु की विलक्षणता", "Lexical root artifice"),
          TopicClassification("पदपरार्धवक्रता", "प्रत्यय-काल-वचनादीनां चमत्कारः", "प्रत्यय और व्याकरणिक रूपों का सौन्दर्य", "Grammatical inflectional artifice"),
          TopicClassification("वाक्यवक्रता", "वस्तु-अलङ्कारादीनां वाक्यगता रमणीयता", "समस्त वाक्य की भंगिमा", "Syntactic figurative artistry"),
          TopicClassification("प्रकरणवक्रता व प्रबन्धवक्रता", "कथाप्रसङ्गस्य सम्पूर्णग्रन्थस्य च नूतनरूपेण संयोजनम्", "कथानक और समग्र प्रबन्ध की मौलिकता", "Structural and holistic narrative ingenuity")
        ),
        illustrativeVerse = "किं ते वपुः सुभग! भस्मविलिप्तमङ्गं\nकिं वा कपालमथवा ननु शूलपाणिः।\nइत्थं निशम्य गिरिशं प्रति शैलपुत्र्याः\nसस्मितं वचनमुत्तरमास शम्भोः॥",
        illustrativeVerseSource = "कुमारसम्भवम् (५.८० सन्दर्भे)",
        illustrativeExplanationSa = "अत्र शैलपुत्र्याः संलापे वक्रोक्तेः अप्रतिमः चमत्कारः।",
        illustrativeExplanationHi = "यहाँ पार्वती और शिव के सम्भाषण में विलक्षण वक्रोक्ति का दर्शन होता है।",
        illustrativeExplanationEn = "Exemplifies playful conversational obliquity between Parvati and Shiva."
      ),

      ShastraTopic(
        id = "aucitya",
        term = "औचित्यम्",
        termIast = "Aucitya",
        category = "औचित्यसिद्धान्तः / काव्यशास्त्रम्",
        vyutpatti = "व्युत्पत्तिः — 'उचितस्य भावः कर्म वा औचित्यम्' (उचित शब्दः + ष्यञ् प्रत्ययः)। 'उचितं प्राहुराचार्याः सदृशं किल यस्य यत्'। यस्य वस्तुनः यत्सदृशं यदुपयुक्तं वा भवति तद् उचितम्, तस्य भावः औचित्यम्।",
        definitions = listOf(
          TopicDefinition(
            text = "औचित्यं रससिद्धस्य स्थिरं काव्यस्य जीवितम्।",
            author = "क्षेमेन्द्राचार्यः",
            work = "औचित्यविचारचर्चा (कारिका ५)",
            meaningSa = "रसयुक्तस्य काव्यस्य स्थिरः शाश्वतः प्राणः औचित्यमेव। औचित्यं विना अलङ्काराः गुणाश्च निष्फलाः भवन्ति।",
            meaningHi = "रससिद्ध काव्य का स्थायी और शाश्वत जीवन (प्राण) औचित्य ही है। औचित्य के बिना अलङ्कार और गुण व्यर्थ भार मात्र हैं।",
            meaningEn = "Propriety (Aucitya) is the abiding life-principle of poetry perfected in Rasa."
          ),
          TopicDefinition(
            text = "अनौचित्यादृते नान्यद्रसभाङ्गस्य कारणम्।\nप्रसिद्धौचित्यबन्धस्तु रसस्योपनिषत्परा॥",
            author = "आनन्दवर्धनाचार्यः",
            work = "ध्वन्यालोकः (तृतीय उद्योतः)",
            meaningSa = "रसभङ्गस्य अनौचित्याद् अतिरिक्तं किमपि अन्यत् कारणं नास्ति; औचित्यमेव रसस्य परमं रहस्यम्।",
            meaningHi = "अनौचित्य (अनुचितता) के अतिरिक्त रसभङ्ग का कोई अन्य कारण नहीं है; औचित्य का निर्वाह ही रस का परम रहस्य है।",
            meaningEn = "Nothing disrupts Rasa more fatally than impropriety; the adherence to established propriety is the supreme secret of Rasa."
          )
        ),
        svarupaSa = "काव्ये पात्र-देश-काल-भाव-रस-गुणादीनां परस्परानुरूपं सामञ्जस्यमेव औचित्यम्। यथा कण्ठे नूपुरं पादे च हारो न शोभते, तथैव अनौचित्यं काव्यं नाशयति।",
        svarupaHi = "काव्य में पात्र, देश, काल, रस और भावों के अनुरूप अनुकूल संयोजन ही औचित्य है। अनुचित स्थान पर रखा गया आभूषण भी हास्यास्पद हो जाता है।",
        svarupaEn = "Harmonious decorum and fitness of character, emotion, meter, and diction. Placing an anklet on the neck disfigures rather than adorns.",
        classifications = listOf(
          TopicClassification("पदोचित्यम् व वाक्यौचित्यम्", "पदानां वाक्यानां च रसानुकूल्यम्", "पदों और वाक्यों का रसानुकूल प्रयोग", "Verbal and syntactic propriety"),
          TopicClassification("अलङ्कारौचित्यम् व गुणौचित्यम्", "अलङ्काराणां गुणानां च अतिरेकशून्यः रसोपकारी प्रयोगः", "अलङ्कारों और गुणों का औचित्यपूर्ण विन्यास", "Propriety of figures and poetic qualities"),
          TopicClassification("रसौचित्यम् व पात्रौचित्यम्", "नायकादीनां स्वभावाऽनुरूपं रसनियोजनम्", "पात्रों के स्वभाव अनुसार रस का विकास", "Emotional and character propriety")
        ),
        illustrativeVerse = "कण्ठे मेखलया नितम्बफलके मञ्जीरनादेन वा\nहारेणापि पदाम्बुजेषु रचितो हासायैव संजायते।\nतद्वद् देशवयोऽनुरूपरहितः शृङ्गारसङ्कीर्तनं\nकाव्ये वा विदुषां सभासु विहितं लज्जाकरं जायते॥",
        illustrativeVerseSource = "क्षेमेन्द्रकृत-औचित्यविचारचर्चा",
        illustrativeExplanationSa = "यथा अनुचितस्थाने आभूषणं हास्यकरं भवति, तथैव अनौचित्ययुक्तं काव्यं लज्जावहं भवति।",
        illustrativeExplanationHi = "जैसे गले में करधनी और पैरों में हार पहनना केवल उपहास का कारण बनता है, वैसे ही अनौचित्यपूर्ण काव्य विद्वानों की सभा में लज्जा उत्पन्न करता है।",
        illustrativeExplanationEn = "Girdles worn at the throat or necklaces strapped to the feet evoke only laughter; likewise poetry shorn of propriety brings only embarrassment."
      )
    )
  }
}
