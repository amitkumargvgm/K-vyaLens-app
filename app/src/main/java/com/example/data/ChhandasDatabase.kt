package com.example.data

import com.example.model.ChhandasItem
import com.example.model.ChhandasLakshana
import com.example.util.ChhandasEngine

object ChhandasDatabase {

  val list: List<ChhandasItem> by lazy {
    listOf(
      createItem(
        id = "anustubh",
        nameSa = "अनुष्टुप् (श्लोकः)",
        nameEn = "Anustubh (Shloka)",
        category = "समवृत्तम् / वर्णवृत्तम्",
        syllableCount = 8,
        yati = "पादान्ते (प्रति ८ अक्षरे)",
        ganaRule = "पञ्चमं लघु सर्वत्र सप्तमं द्विचतुर्थयोः। गुरु षष्ठं च पादानां",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "श्लोके षष्ठं गुरु ज्ञेयं सर्वत्र लघु पञ्चमम्।\nद्विचतुःपादयोर्ह्रस्वं सप्तमं दीर्घमन्ययोः॥",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (अ० २, श्लो० २)",
            meaningSa = "श्लोकस्य सर्वेषु पादेषु पञ्चममक्षरं लघु, षष्ठं च गुरु स्यात्। द्वितीये चतुर्थे च पादे सप्तमं ह्रस्वं (लघु), प्रथमे तृतीये च सप्तमं दीर्घं (गुरु) भवति।",
            meaningHi = "श्लोक के चारों चरणों में पाँचवाँ अक्षर लघु तथा छठा अक्षर गुरु होना चाहिए। दूसरे और चौथे चरण में सातवाँ अक्षर लघु तथा पहले और तीसरे में सातवाँ गुरु होता है।",
            meaningEn = "In the Shloka (Anustubh), the 5th syllable is light (laghu) and 6th is heavy (guru) in all quarters. The 7th is light in the 2nd and 4th, and heavy in the 1st and 3rd."
          ),
          ChhandasLakshana(
            lakshanaText = "पञ्चमं लघु सर्वत्र सप्तमं द्विचतुर्थयोः।\nगुरु षष्ठं च पादानां शेषेष्वनियमो मतः॥",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "चतुर्ष्वपि पादेषु पञ्चमं लघु, द्विचतुर्थयोः सप्तमं लघु, षष्ठं च गुरु स्यात्।",
            meaningHi = "चारों चरणों में 5वाँ वर्ण लघु, 2रे व 4थे में 7वाँ लघु, और 6ठा वर्ण गुरु होता है।",
            meaningEn = "The 5th syllable is always light, the 7th is light in even padas, and the 6th is heavy everywhere."
          )
        ),
        exampleVerse = "वागर्थाविव सम्पृक्तौ वागर्थप्रतिपत्तये।\nजगतः पितरौ वन्दे पार्वतीपरमेश्वरौ॥",
        exampleSource = "कालिदासकृत-रघुवंशम् (१.१)",
        exampleMeaningSa = "वागर्थयोः सम्यक् ज्ञानार्थं वागर्थाविव नित्यसम्बद्धौ जगतः मातापितरौ पार्वतीपरमेश्वरौ नमस्करोमि।",
        exampleMeaningHi = "वाणी और अर्थ की सम्यक् प्रतीति के लिए वाणी और अर्थ के समान नित्य मिले हुए जगत् के माता-पिता पार्वती-परमेश्वर की मैं वन्दना करता हूँ।",
        exampleMeaningEn = "For the proper understanding of word and meaning, I bow to Parvati and Parameshvara, the parents of the universe, who are united like speech and its meaning."
      ),

      createItem(
        id = "indravajra",
        nameSa = "इन्द्रवज्रा",
        nameEn = "Indravajra",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "त, त, ज, ग, ग (ऽऽ।  ऽऽ।  ।ऽ।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "स्यादिन्द्रवज्रा यदि तौ जगौ गः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.११)",
            meaningSa = "यस्य वृत्तस्य पादे क्रमेण तगणद्वयम्, जगणः, गुरुद्वयं च भवेत् तद् इन्द्रवज्रा नाम।",
            meaningHi = "जिस वृत्त के प्रत्येक चरण में क्रमशः दो तगण (त, त), एक जगण (ज) और दो गुरु वर्ण हों, वह इन्द्रवज्रा कहलाता है।",
            meaningEn = "Indravajra has two Ta-ganas, one Ja-gana, followed by two heavy syllables (Guru) in each quarter."
          ),
          ChhandasLakshana(
            lakshanaText = "तौ चेज्जगौ गो भवतीन्द्रवज्रा।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "तगणौ जगणः गुरुद्वयं चेत् सा इन्द्रवज्रा प्रोक्ता।",
            meaningHi = "यदि चरण में दो तगण, एक जगण और दो गुरु वर्ण हों तो वह इन्द्रवज्रा कही जाती है।",
            meaningEn = "When a pada contains two Ta-ganas, one Ja-gana, and two gurus, it is Indravajra."
          )
        ),
        exampleVerse = "अर्थो हि कन्या परकीय एव\nतामद्य सम्प्रेष्य परिग्रहीतुः।\nजातो ममायं विशदः प्रकामं\nप्रत्यर्पितन्यास इवान्तरात्मा॥",
        exampleSource = "कालिदासकृत-अभिज्ञानशाकुन्तलम् (४.२२)",
        exampleMeaningSa = "कन्या वस्तुतः परधनमेव, तामद्य पत्युः पार्श्वं प्रेषयित्वा मे चित्तं न्याससमर्पणवत् शान्तं जातम्।",
        exampleMeaningHi = "कन्या वस्तुतः पराया ही धन है, आज उसे पति के पास भेजकर मेरी अन्तरात्मा ऐसी प्रसन्न व शान्त हो गई है जैसे किसी की धरोहर लौटा दी गई हो।",
        exampleMeaningEn = "A daughter is truly another's property; having sent her today to her husband, my inner soul has become as tranquil as returning a deposited trust."
      ),

      createItem(
        id = "upendravajra",
        nameSa = "उपेन्द्रवज्रा",
        nameEn = "Upendravajra",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "ज, त, ज, ग, ग (।ऽ।  ऽऽ।  ।ऽ।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "उपेन्द्रवज्रा जतजास्ततो गौ।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१२)",
            meaningSa = "यत्र पादे क्रमेण जगण-तगण-जगण-गुरुद्वयं भवति तद् उपेन्द्रवज्रा।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः जगण, तगण, जगण और दो गुरु वर्ण हों, वह उपेन्द्रवज्रा छन्द होता है।",
            meaningEn = "Upendravajra consists of a Ja-gana, a Ta-gana, a Ja-gana, and two Guru syllables."
          ),
          ChhandasLakshana(
            lakshanaText = "उपेन्द्रवज्रा प्रथमे लघौ सा।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "इन्द्रवज्रायाः प्रथमाक्षरं यदि लघु भवति तदा सा उपेन्द्रवज्रा भवति।",
            meaningHi = "इन्द्रवज्रा के प्रथम वर्ण के लघु हो जाने पर वह उपेन्द्रवज्रा बन जाती है।",
            meaningEn = "If the first syllable of Indravajra becomes light, it forms Upendravajra."
          )
        ),
        exampleVerse = "त्वमेव माता च पिता त्वमेव\nत्वमेव बन्धुश्च सखा त्वमेव।\nत्वमेव विद्या द्रविणं त्वमेव\nत्वमेव सर्वं मम देवदेव॥",
        exampleSource = "प्रसिद्ध-स्तोत्रपरम्परा / पाण्डवगीता",
        exampleMeaningSa = "हे देवाधिदेव! त्वमेव मम जननी, जनकः, बान्धवः, मित्रं, विद्या, धनं सर्वं च वर्तसे।",
        exampleMeaningHi = "हे देवों के देव! तुम्हीं माता हो, तुम्हीं पिता हो, तुम्हीं बन्धु और सखा हो, तुम्हीं विद्या और तुम्हीं धन हो, तुम्हीं मेरे सब कुछ हो।",
        exampleMeaningEn = "You alone are my mother, father, kinsman, and friend. You alone are wisdom, wealth, and all that I possess, O Lord of lords."
      ),

      createItem(
        id = "upajati",
        nameSa = "उपजातिः",
        nameEn = "Upajati",
        category = "मिश्रवृत्तम् / सम-मिश्रणम्",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "इन्द्रवज्रोपेन्द्रवज्रयोः पादमिश्रणम् (१४ भेदाः)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "अनन्तरोदीरितलक्ष्मभाजौ पादौ यदीयावुपजातयस्ताः।\nइत्थं किलास्यान्यसु मध्यगेषु विशेषयन्तीह वदन्ति नाम॥",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१३)",
            meaningSa = "यत्र इन्द्रवज्रा-उपेन्द्रवज्रयोः पादाः परस्परं मिश्रिताः स्युः, सा उपजातिरिति कथ्यते।",
            meaningHi = "जिस पद्य में इन्द्रवज्रा और उपेन्द्रवज्रा के चरण मिश्रित हों, उसे उपजाति छन्द कहते हैं। इसके १४ भेद होते हैं।",
            meaningEn = "Upajati is formed by mixing quarters of Indravajra and Upendravajra in a four-line stanza (14 combinations)."
          ),
          ChhandasLakshana(
            lakshanaText = "इन्द्रवज्रोपेन्द्रवज्रापादसंमिश्रणादुपजातयः।",
            sourceAuthorOrText = "पिङ्गलच्छन्दःसूत्रम्",
            meaningSa = "उभयोर्वृत्तयोः पादसङ्कराद् उपजातिनिष्पत्तिः।",
            meaningHi = "दोनों वृत्तों के चरणों के संमिश्रण से उपजाति की रचना होती है।",
            meaningEn = "Upajati arises from blending the quarters of Indravajra and Upendravajra."
          )
        ),
        exampleVerse = "अस्त्युत्तरस्यां दिशि देवतात्मा\nहिमालयो नाम नगाधिराजः।\nपूर्वापरौ तोयनिधी विगाह्य\nस्थितः पृथिव्या इव मानदण्डः॥",
        exampleSource = "कालिदासकृत-कुमारसम्भवम् (१.१)",
        exampleMeaningSa = "उत्तरस्यां दिशि देवात्मको हिमालयाख्यो पर्वतानाम् अधिराजः वर्तते, यः पूर्वपश्चिमसमुद्रौ प्रविश्य पृथिव्याः मानदण्ड इव स्थितः।",
        exampleMeaningHi = "उत्तर दिशा में देवताओं का आत्मस्वरूप हिमालय नाम का पर्वतों का राजा विद्यमान है, जो पूर्व और पश्चिम दोनों समुद्रों में अवगाहन कर मानो पृथ्वी के नापदण्ड के समान स्थित है।",
        exampleMeaningEn = "In the northern quarter stands the divine-souled king of mountains, named Himalaya, spanning both eastern and western oceans like the measuring rod of the earth."
      ),

      createItem(
        id = "vamshastham",
        nameSa = "वंशस्थम्",
        nameEn = "Vamshastham",
        category = "समवृत्तम् (जगती)",
        syllableCount = 12,
        yati = "पादान्ते (१२ अक्षरे)",
        ganaRule = "ज, त, ज, र (।ऽ।  ऽऽ।  ।ऽ।  ऽ।ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "जतौ तु वंशस्थमुदीरितं जरौ।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.२६)",
            meaningSa = "यस्य पादे क्रमेण जगणः, तगणः, जगणः, रगणश्च भवन्ति तद् वंशस्थं नाम वृत्तम्।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः जगण, तगण, जगण और रगण (ज-त-ज-र) हों, वह वंशस्थ छन्द कहलाता है।",
            meaningEn = "Vamshastham has the sequence of Ja-gana, Ta-gana, Ja-gana, and Ra-gana in each 12-syllable quarter."
          ),
          ChhandasLakshana(
            lakshanaText = "वदन्ति वंशस्थविलं जतौ जरौ।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "ज-त-ज-र गणयुक्तं वंशस्थम्।",
            meaningHi = "जगण, तगण, जगण, रगण से युक्त वृत्त वंशस्थ है।",
            meaningEn = "Vamshastham consists of the Ja, Ta, Ja, and Ra ganas."
          )
        ),
        exampleVerse = "किरातसेनापतिमन्वगच्छन्\nप्रभञ्जनान्दोलितपिञ्छकेतुम।\nरणोत्सुकं भूरिशिलीमुखाढ्यं\nकरालचापाहितबाणदण्डम्॥",
        exampleSource = "भारविकृत-किरातार्जुनीयम्",
        exampleMeaningSa = "किरातसेनापतिं ते अनुगताः।",
        exampleMeaningHi = "किरात सेनापति के पीछे वे चले।",
        exampleMeaningEn = "They followed the commander of the Kirata army, eager for heroic battle."
      ),

      createItem(
        id = "drutavilambitam",
        nameSa = "द्रुतविलम्बितम्",
        nameEn = "Drutavilambitam",
        category = "समवृत्तम् (जगती)",
        syllableCount = 12,
        yati = "पादान्ते (१२ अक्षरे)",
        ganaRule = "न, भ, भ, र (।।।  ऽ।।  ऽ।।  ऽ।ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "द्रुतविलम्बितमाह नभौ भरौ।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.३०)",
            meaningSa = "यत्र पादे नगणः, भगणद्वयम्, रगणश्च भवेयुः तद् द्रुतविलम्बितम्।",
            meaningHi = "जिसके प्रत्येक चरण में नगण, दो भगण और एक रगण (न-भ-भ-र) हों, उसे द्रुतविलम्बित कहते हैं।",
            meaningEn = "Drutavilambitam consists of Na-gana, two Bha-ganas, and Ra-gana (12 syllables)."
          ),
          ChhandasLakshana(
            lakshanaText = "नभौ भरौ द्रुतविलम्बितं मतम्।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "न-भ-भ-र गणयुक्तं द्रुतविलम्बितम्।",
            meaningHi = "नगण, दो भगण और रगण से द्रुतविलम्बित छन्द बनता है।",
            meaningEn = "When Na, Bha, Bha, and Ra ganas combine, it is Drutavilambitam."
          )
        ),
        exampleVerse = "अभिमुखे मयि संहृतमीक्षितं\nहसितमन्यनिमित्तकृतोदयम्।\nविनयवारितवृत्तिरतस्तया\nन विवृतो मदनो न च संवृतः॥",
        exampleSource = "कालिदासकृत-अभिज्ञानशाकुन्तलम् (२.११)",
        exampleMeaningSa = "मया दृष्टे सति तया दृष्टिः संहृता, अन्यापदेशेन च हसितम्; लज्जया कामो न प्रकटितो नापि पूर्णतया गोपितः।",
        exampleMeaningHi = "मेरे सामने होने पर उसने दृष्टि हटा ली, किसी अन्य कारण से हँसने का बहाना किया; लज्जा के कारण उसने प्रेम न तो प्रकट ही किया और न छिपाया ही।",
        exampleMeaningEn = "When I looked, her glance was withdrawn; her smile was attributed to some other cause; restrained by modesty, her love was neither revealed nor entirely concealed."
      ),

      createItem(
        id = "vasantatilaka",
        nameSa = "वसन्ततिलका",
        nameEn = "Vasantatilaka",
        category = "समवृत्तम् (शक्वरी)",
        syllableCount = 14,
        yati = "८ तथा ६ अक्षरे",
        ganaRule = "त, भ, ज, ज, ग, ग (ऽऽ।  ऽ।।  ।ऽ।  ।ऽ।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "उक्ता वसन्ततिलका तभजा जगौ गः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.४१)",
            meaningSa = "यत्र क्रमेण तगणः, भगणः, जगणद्वयं, गुरुद्वयं च भवेत् सा वसन्ततिलका।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः तगण, भगण, दो जगण तथा दो गुरु वर्ण (त-भ-ज-ज-ग-ग) हों, वह वसन्ततिलका कहलाती है।",
            meaningEn = "Vasantatilaka is defined by Ta, Bha, Ja, Ja ganas, followed by two Gurus (14 syllables per line)."
          ),
          ChhandasLakshana(
            lakshanaText = "ज्ञेया वसन्ततिलका तभजा जगौ गः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "त-भ-ज-ज-ग-ग गणैर्युता वसन्ततिलका।",
            meaningHi = "तगण, भगण, दो जगण और दो गुरु से वसन्ततिलका की पहचान होती है।",
            meaningEn = "Identified by Ta, Bha, two Jas, and two heavy syllables."
          )
        ),
        exampleVerse = "पापान्निवारयति योजयते हिताय\nगुह्यं निगूहति गुणान् प्रकटीकरोति।\nआपद्गतं च न जहाति ददाति काले\nसन्मित्रलक्षणमिदं प्रवदन्ति सन्तः॥",
        exampleSource = "भर्तृहरिकृत-नीतिशतकम् (७२)",
        exampleMeaningSa = "सज्जनाः सन्मित्रस्यैतानि लक्षणानि वदन्ति—यः पापाद् वारयति, हिते प्रेरयति, गोप्यं गोपयति, गुणान् प्रकाशयति, आपत्काले सहायं करोति।",
        exampleMeaningHi = "सत्पुरुष सच्चे मित्र के ये लक्षण बताते हैं—जो पाप से रोकता है, हितकारी कार्यों में लगाता है, गोपनीय बातों को छिपाता है, गुणों को प्रकट करता है और विपत्ति में साथ नहीं छोड़ता।",
        exampleMeaningEn = "The wise define a true friend by these signs: he turns one away from sin, engages one in good, conceals confidences, reveals virtues, and does not desert in calamity."
      ),

      createItem(
        id = "malini",
        nameSa = "मालिनी",
        nameEn = "Malini",
        category = "समवृत्तम् (अतिशक्वरी)",
        syllableCount = 15,
        yati = "८ तथा ७ अक्षरे (भोगि-लोकैः)",
        ganaRule = "न, न, म, य, य (।।।  ।।।  ऽऽऽ  ।ऽऽ  ।ऽऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "ननमयययुतेयं मालिनी भोगिलोकैः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.४५)",
            meaningSa = "यत्र नगणद्वयं, मगणः, यगणद्वयं च क्रमेण भवेयुः, तथा भोगि (८) लोकैः (७) यतिर्भवति सा मालिनी।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः दो नगण, एक मगण और दो यगण (न-न-म-य-य) हों तथा आठवें और सातवें वर्ण पर यति हो, वह मालिनी छन्द है।",
            meaningEn = "Malini has two Na-ganas, one Ma-gana, two Ya-ganas, with caesura (yati) after 8 and 7 syllables."
          ),
          ChhandasLakshana(
            lakshanaText = "ननमयययुता स्यान्मालिनी भोगिलोकैः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "८ तथा ७ अक्षरेषु यतिर्भवति।",
            meaningHi = "८ और ७ वर्णों पर यति वाली मालिनी होती है।",
            meaningEn = "Defined with yati at 8 and 7 syllables with Na-Na-Ma-Ya-Ya."
          )
        ),
        exampleVerse = "सरसिजमनुविद्धं शैवलेनापि रम्यं\nमलिनमपि हिमांशोर्लक्ष्म लक्ष्मीं तनोति।\nइयमधिकमनोज्ञा वल्कलेनापि तन्वी\nकिमिव हि मधुराणां मण्डनं नाकृतीनाम्॥",
        exampleSource = "कालिदासकृत-अभिज्ञानशाकुन्तलम् (१.२०)",
        exampleMeaningSa = "शैवलावृतमपि कमलं शोभते, शशिनः कलङ्कोऽपि शोभां वर्धयति, वल्कलेनापि इयं शकुन्तला सुन्दरी वर्तते; मधुराकृतीनां किं वस्तु भूषणं न भवति?",
        exampleMeaningHi = "काई से घिरा होने पर भी कमल सुन्दर लगता है, चन्द्रमा का कलंक भी उसकी शोभा बढ़ाता है, यह सुकुमारी शकुन्तला वल्कल वस्त्र में भी अत्यधिक मनोहर लग रही है; सुन्दर आकृतियों के लिए क्या वस्तु आभूषण नहीं बन जाती?",
        exampleMeaningEn = "A lotus entwined in moss is still lovely; the spot on the moon enhances its splendour; this slender maiden is captivating even in bark garments—what indeed is not an ornament to naturally graceful forms?"
      ),

      createItem(
        id = "mandakranta",
        nameSa = "मन्दाक्रान्ता",
        nameEn = "Mandakranta",
        category = "समवृत्तम् (अत्यष्टिः)",
        syllableCount = 17,
        yati = "४, ६ तथा ७ अक्षरे (जलधि-षड्-अगैः)",
        ganaRule = "म, भ, न, त, त, ग, ग (ऽऽऽ  ऽ।।  ।।।  ऽऽ।  ऽऽ।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "मन्दाक्रान्ता जलधिषडगैर्म्भौ नतौ ताद्गुरू चेत्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५०)",
            meaningSa = "यत्र मगण-भगण-नगण-तगणद्वयं गुरुद्वयं च भवन्ति, तथा जलधि (४), षट् (६), अग (७) अक्षरेषु यतिर्भवति सा मन्दाक्रान्ता।",
            meaningHi = "जिसके प्रत्येक चरण में मगण, भगण, नगण, दो तगण और दो गुरु वर्ण हों तथा ४, ६ और ७ वर्णों पर यति हो, वह मन्दाक्रान्ता छन्द है।",
            meaningEn = "Mandakranta contains Ma, Bha, Na, Ta, Ta ganas and two Gurus, with pauses at 4th, 10th (4+6), and 17th syllables."
          ),
          ChhandasLakshana(
            lakshanaText = "मन्दाक्रान्ता मभनततगा गोऽम्बुधिषड्यतिश्च।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "म-भ-न-त-त-ग-ग गणैर्युता ४, ६, ७ अक्षरेषु यतिः।",
            meaningHi = "मगण, भगण, नगण, दो तगण और दो गुरुओं से युक्त तथा ४, ६, ७ पर यति वाली मन्दाक्रान्ता।",
            meaningEn = "Defined by Gadasa with pauses at 4, 6, and 7."
          )
        ),
        exampleVerse = "कश्चित्कान्ताविरहगुरुणा स्वाधिकारात्प्रमत्तः\nशापेनास्तङ्गमितमहिमा वर्षभोग्येन भर्तुः।\nयक्षश्चक्रे जनकतनयास्नानपुण्योदकेषु\nस्निग्धच्छायातरुषु वसतिं रामगिर्याश्रमेशु॥",
        exampleSource = "कालिदासकृत-मेघदूतम् (१.१)",
        exampleMeaningSa = "कर्तव्यभ्रष्टः कश्चन यक्षः स्वामिनः कुबेरस्य शापेन वर्षमात्रभोग्येन विरहपीडितः रामगिरौ न्यवसत्।",
        exampleMeaningHi = "अपने कर्तव्य में प्रमादी हुआ कोई यक्ष, स्वामी कुबेर के एक वर्ष के विरह रूपी भारी शाप से रामगिरि के आश्रमों में निवास करने लगा, जहाँ सीताजी के स्नान से पवित्र जल और सघन छायादार वृक्ष थे।",
        exampleMeaningEn = "A certain Yaksha, negligent in his duties, deprived of his glory by his master's curse unbearable through separation from his beloved for a year, took up abode in the hermitages of Ramagiri."
      ),

      createItem(
        id = "shikharini",
        nameSa = "शिखरिणी",
        nameEn = "Shikharini",
        category = "समवृत्तम् (अत्यष्टिः)",
        syllableCount = 17,
        yati = "६ तथा ११ अक्षरे (रसैः रुद्रैः)",
        ganaRule = "य, म, न, स, भ, ल, ग (।ऽऽ  ऽऽऽ  ।।।  ।।ऽ  ऽ।।  । ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "रसै रुद्रैश्छिन्ना यमनसभला गः शिखरिणी।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५१)",
            meaningSa = "यत्र य-म-न-स-भ गणाः, लघुः गुरुश्च भवेयुः, तथा रसैः (६) रुद्रैः (११) यतिर्भवति सा शिखरिणी।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः यगण, मगण, नगण, सगण, भगण, एक लघु और एक गुरु वर्ण हों तथा ६ और ११ वर्णों पर यति हो, वह शिखरिणी छन्द है।",
            meaningEn = "Shikharini has Ya, Ma, Na, Sa, Bha ganas, a Laghu, and a Guru (17 syllables), with yati at 6 (rasa) and 11 (rudra)."
          ),
          ChhandasLakshana(
            lakshanaText = "यमनसभलागैः षड्भिर्हयैः शिखरिणी मता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "षट्सु एकादशसु च अक्षरेषु यतिर्भवति।",
            meaningHi = "६ तथा ११ वर्णों पर यति वाली शिखरिणी।",
            meaningEn = "Yati at 6 and 11 syllables."
          )
        ),
        exampleVerse = "भवन्तो वन्द्या मे भुवि विविधविद्याविशारदाः\nपरं ब्रूमः सत्यं न हि परिभवोऽयं कथमपि।\nन विद्मः किं कुर्मः प्रमदमुखपद्मव्यतिकरे\nन यद्वाचः स्फारं दधति परितोषं विदुषिताम्॥",
        exampleSource = "भर्तृहरिकृत-शृङ्गारशतकम्",
        exampleMeaningSa = "विद्वांसः वन्द्याः सन्ति, किन्तु शृङ्गाररसस्य सम्मुखे पण्डितानामपि मनः प्रमुग्धं भवति।",
        exampleMeaningHi = "संसार में अनेक विद्याओं में प्रवीण आप सभी विद्वान् वन्दनीय हैं, परन्तु एक सत्य कहते हैं—कामिनी के मुखकमल के साक्षात् होने पर हमारी वाणी का विद्वत्तापूर्ण सन्तोष कहाँ चला जाता है, कुछ समझ नहीं आता।",
        exampleMeaningEn = "Revered scholars adept in manifold sciences, we state the truth without disrespect: in the presence of lovely lotus-faced maidens, scholarly pride dissolves into delight."
      ),

      createItem(
        id = "shardulavikriditam",
        nameSa = "शार्दूलविक्रीडितम्",
        nameEn = "Shardulavikriditam",
        category = "समवृत्तम् (धृतिः)",
        syllableCount = 19,
        yati = "१२ तथा ७ अक्षरे (सूर्य-अश्वैः)",
        ganaRule = "म, स, ज, स, त, त, ग (ऽऽऽ  ।।ऽ  ।ऽ।  ।।ऽ  ऽऽ।  ऽऽ।  ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "सूर्याश्वैर्मसजस्ततः सगुरवः शार्दूलविक्रीडितम्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५४)",
            meaningSa = "यत्र मगणः, सगणः, जगणः, सगणः, तगणद्वयं, गुरुश्च भवन्ति, तथा सूर्यैः (१२) अश्वैः (७) यतिर्भवति तत् शार्दूलविक्रीडितम्।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः मगण, सगण, जगण, सगण, दो तगण और एक गुरु वर्ण (म-स-ज-स-त-त-ग) हों तथा १२ और ७ वर्णों पर यति हो, वह शार्दूलविक्रीडित छन्द कहलाता है।",
            meaningEn = "Shardulavikriditam comprises Ma, Sa, Ja, Sa, Ta, Ta ganas and one Guru (19 syllables), with yati at 12 (Surya) and 7 (Ashva)."
          ),
          ChhandasLakshana(
            lakshanaText = "द्वादशभिः सप्तभिश्च यतिः शार्दूलविक्रीडिते।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "म-स-ज-स-त-त-ग गणैर्युक्तं १९ अक्षरात्मकं वृत्तम्।",
            meaningHi = "१२ और ७ पर यति से युक्त शार्दूलविक्रीडित है।",
            meaningEn = "19 syllables with pauses at 12 and 7."
          )
        ),
        exampleVerse = "विद्या नाम नरस्य रूपमधिकं प्रच्छन्नगुप्तं धनं\nविद्या भोगकरी यशःसुखकरी विद्या गुरूणां गुरुः।\nविद्या बन्धुजनो विदेशगमने विद्या परा देवता\nविद्या राजसु पूज्यते न हि धनं विद्याविहीनः पशुः॥",
        exampleSource = "भर्तृहरिकृत-नीतिशतकम् (२०)",
        exampleMeaningSa = "विद्या एव मनुष्यस्य वास्तविकं सौन्दर्यम्, गुप्तधनम्, यशःप्रदा, विदेशे बन्धुः, विद्याहीनस्तु साक्षात् पशुरेव।",
        exampleMeaningHi = "विद्या ही मनुष्य का परम रूप और गुप्त धन है; विद्या भोग, यश और सुख देने वाली है; विद्या गुरुओं की गुरु है; विदेश में विद्या ही सच्चा बन्धु है; राजाओं में विद्या पूजी जाती है धन नहीं; विद्या से हीन मनुष्य पशु समान है।",
        exampleMeaningEn = "Learning is man's peerless beauty and hidden treasure; learning yields enjoyment, fame, and joy; learning is the guru of gurus and kinsman abroad; kings honour learning, not mere wealth; one devoid of learning is a beast."
      ),

      createItem(
        id = "sragdhara",
        nameSa = "स्रग्धरा",
        nameEn = "Sragdhara",
        category = "समवृत्तम् (प्रकृतिः)",
        syllableCount = 21,
        yati = "प्रति ७ अक्षरे (त्रिमुनि-यतिः: ७, ७, ७)",
        ganaRule = "म, र, भ, न, य, य, य (ऽऽऽ  ऽ।ऽ  ऽ।।  ।।।  ।ऽऽ  ।ऽऽ  ।ऽऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "म्रभ्नैर्याणां त्रयेण त्रिमुनियतियुता स्रग्धरा कीर्तितेयम्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५७)",
            meaningSa = "यत्र मगणः, रगणः, भगणः, नगणः, यगणत्रयं च भवन्ति, तथा त्रिमुनिभिः (७, ७, ७) यतिर्भवति सा स्रग्धरा।",
            meaningHi = "जिसके प्रत्येक चरण में मगण, रगण, भगण, नगण और तीन यगण (म-र-भ-न-य-य-य = २१ वर्ण) हों तथा प्रत्येक सातवें वर्ण पर (७, ७, ७) यति हो, वह स्रग्धरा छन्द कहलाता है।",
            meaningEn = "Sragdhara contains Ma, Ra, Bha, Na, and three Ya ganas (21 syllables), with three equal pauses every 7 syllables (Tri-muni yati)."
          ),
          ChhandasLakshana(
            lakshanaText = "स्रग्धरा म्रौ भनौ यौ यौ यतिः सप्तभिः सप्तभिः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "त्रिभिः सप्तभिः यतिर्भवति।",
            meaningHi = "सात-सात वर्णों पर तीन बार यति होती है।",
            meaningEn = "Pauses at 7, 14, and 21 syllables."
          )
        ),
        exampleVerse = "ग्रीवाभङ्गाभिरामं मुहुरनुपतति स्यन्दने दत्तदृष्टिः\nपश्चार्धेन प्रविष्टः शरपतनभिया भूयसा पूर्वकायम्।\nशष्पैरर्धावलीढैः श्रमविवृतमुखभ्रंशिभिः कीर्णवर्मा\nपश्योदग्रप्लुतत्वाद्वियति बहुतरं स्तोकमुर्व्यां प्रयाति॥",
        exampleSource = "कालिदासकृत-अभिज्ञानशाकुन्तलम् (१.७)",
        exampleMeaningSa = "मृगस्य धावनभङ्ग्याः स्वाभाविकं मनोहरं च वर्णनम्।",
        exampleMeaningHi = "गर्दन मोड़-मोड़कर रथ पर दृष्टि डालता हुआ, बाण के भय से पिछले शरीर को अगले शरीर में समेटता हुआ, आधे चबाए तिनकों को गिराता हुआ यह हरिण ऊँची छलाँगों के कारण भूमि पर कम और आकाश में अधिक उड़ता हुआ प्रतीत होता है।",
        exampleMeaningEn = "Gracefully turning its neck, casting glances at the pursuing chariot, drawing its hindquarters into its fore-body through fear of arrows, scattering half-chewed grass from its panting mouth—behold, bounds high in air, scarcely touching the ground."
      ),

      createItem(
        id = "bhujangaprayatam",
        nameSa = "भुजङ्गप्रयातम्",
        nameEn = "Bhujangaprayatam",
        category = "समवृत्तम् (जगती)",
        syllableCount = 12,
        yati = "पादान्ते (१२ अक्षरे)",
        ganaRule = "य, य, य, य (।ऽऽ  ।ऽऽ  ।ऽऽ  ।ऽऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "भुजङ्गप्रयातं भवेद् यैश्चतुर्भिः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.२७)",
            meaningSa = "यस्य पादे चत्वारः यगणाः भवन्ति तत् भुजङ्गप्रयातम्।",
            meaningHi = "जिसके प्रत्येक चरण में चार यगण (य-य-य-य = १२ वर्ण) हों, वह भुजङ्गप्रयात छन्द होता है।",
            meaningEn = "Bhujangaprayatam consists of four Ya-ganas in each 12-syllable quarter."
          ),
          ChhandasLakshana(
            lakshanaText = "चतुर्भिर्यकारैर्भुजङ्गप्रयातम्।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "यगणचतुष्टययुक्तं भुजङ्गप्रयातम्।",
            meaningHi = "चार यगणों से भुजङ्गप्रयात बनता है।",
            meaningEn = "Formed by four consecutive Ya-ganas."
          )
        ),
        exampleVerse = "न तातो न माता न बन्धुर्न दाता\nन पुत्रो न पुत्री न भृत्यो न भर्ता।\nन जाया न विद्या न वृत्तिर्ममैव\nगतिस्त्वं गतिस्त्वं त्वमेका भवानि॥",
        exampleSource = "शङ्कराचार्यकृत-भवानीष्टकम् (१)",
        exampleMeaningSa = "हे भवानि! संसारे मम कोऽपि नास्ति, त्वमेव मम एका गतिरसि।",
        exampleMeaningHi = "न पिता, न माता, न भाई, न दाता, न पुत्र, न पुत्री, न सेवक, न स्वामी, न पत्नी, न विद्या और न आजीविका; हे भवानी! केवल तुम्हीं मेरी एकमात्र गति और आश्रय हो।",
        exampleMeaningEn = "Neither father nor mother, kinsman nor giver, son nor daughter, servant nor master, wife nor wealth; You alone, O Bhavani, are my sole refuge!"
      ),

      createItem(
        id = "totakam",
        nameSa = "तोटकम्",
        nameEn = "Totakam",
        category = "समवृत्तम् (जगती)",
        syllableCount = 12,
        yati = "पादान्ते (१२ अक्षरे)",
        ganaRule = "स, स, स, स (।।ऽ  ।।ऽ  ।।ऽ  ।।ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "इह तोटकमम्बुधिसैः प्रमितम्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.२९)",
            meaningSa = "अम्बुधि (४) सगणैः तोटकं भवति।",
            meaningHi = "जिसके प्रत्येक चरण में चार सगण (स-स-स-स = १२ वर्ण) हों, उसे तोटक छन्द कहते हैं।",
            meaningEn = "Totakam consists of four Sa-ganas in each 12-syllable line."
          ),
          ChhandasLakshana(
            lakshanaText = "वद तोटकमब्धिसकारयुतम्।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "चत्वारः सगणाः।",
            meaningHi = "चार सगणों से युक्त तोटक होता है।",
            meaningEn = "Contains four Sa-ganas."
          )
        ),
        exampleVerse = "विदिताखिलशास्त्रसुधाजलधे\nमहितोपनिषत्कथितार्थनिधे।\nहृदये कलये विमलं चरणं\nभव शङ्कर देशिक मे शरणम्॥",
        exampleSource = "तोटकाचार्यकृत-तोटकाष्टकम् (१)",
        exampleMeaningSa = "समस्तशास्त्रज्ञाननिधे शङ्करदेशिक! तव पादपद्मं मे शरणमस्तु।",
        exampleMeaningHi = "समस्त शास्त्रों के अमृत सागर के ज्ञाता, उपनिषदों के परम अर्थ के भण्डार, हे पूज्य गुरुदेव शङ्कराचार्य! मैं आपके निर्मल चरणों का ध्यान करता हूँ, आप मुझे शरण प्रदान करें।",
        exampleMeaningEn = "O ocean of nectar of all scriptures, treasure of Upanishadic truth, I hold your pure feet in my heart; be my refuge, O Master Shankara!"
      ),

      createItem(
        id = "rathoddhata",
        nameSa = "रथोद्धता",
        nameEn = "Rathoddhata",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "र, न, र, ल, ग (ऽ।ऽ  ।।।  ऽ।ऽ  । ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "रान्नराविह रथोद्धता लगौ।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१६)",
            meaningSa = "यत्र रगण-नगण-रगणाः, लघुः गुरुश्च भवन्ति सा रथोद्धता।",
            meaningHi = "जिसके प्रत्येक चरण में रगण, नगण, रगण, एक लघु और एक गुरु वर्ण (र-न-र-ल-ग) हों, वह रथोद्धता कही जाती है।",
            meaningEn = "Rathoddhata consists of Ra, Na, Ra ganas, followed by one Laghu and one Guru (11 syllables)."
          ),
          ChhandasLakshana(
            lakshanaText = "रान्नराविह रथोद्धता मता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "रगण-नगण-रगण-लघु-गुरुयुता।",
            meaningHi = "र-न-र और लघु-गुरु से रथोद्धता बनती है।",
            meaningEn = "Formed by Ra-Na-Ra ganas with laghu and guru."
          )
        ),
        exampleVerse = "चित्रमेतदवधार्यतां जनैः\nकिं न वेत्ति परदुःखमल्पकम्।\nयन्मदीयविभवे विवर्धिते\nशोकसागरनिमग्नमानसः॥",
        exampleSource = "सुभाषितरत्नभाण्डागारम्",
        exampleMeaningSa = "जनानाम् आश्चर्यकरः स्वभावः।",
        exampleMeaningHi = "मनुष्यों के इस आश्चर्यकारी स्वभाव को देखिए कि जो दूसरों की थोड़ी सी भी उन्नति देखकर शोक के सागर में डूब जाते हैं।",
        exampleMeaningEn = "Consider this curious human nature: grieving at another's modest prosperity as though plunged into an ocean of sorrow."
      ),

      createItem(
        id = "shalini",
        nameSa = "शालिनी",
        nameEn = "Shalini",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "४ तथा ७ अक्षरे (वेदैर्लोकैः)",
        ganaRule = "म, त, त, ग, ग (ऽऽऽ  ऽऽ।  ऽऽ।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "शालिन्युक्ता म्तौ तगौ गोऽब्धिलोकैः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१४)",
            meaningSa = "यत्र मगणः, तगणद्वयं, गुरुद्वयं च भवेत्, तथा वेदैः (४) लोकैः (७) यतिर्भवति सा शालिनी।",
            meaningHi = "जिसके प्रत्येक चरण में मगण, दो तगण और दो गुरु वर्ण हों तथा ४ और ७ वर्णों पर यति हो, वह शालिनी छन्द है।",
            meaningEn = "Shalini contains Ma, two Tas, and two Gurus (11 syllables), with pauses at 4 and 7."
          ),
          ChhandasLakshana(
            lakshanaText = "मात्तौ चेद् गौ शालिनी वेदलोकैः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "४, ७ यतिः।",
            meaningHi = "४ और ७ पर यति वाली शालिनी।",
            meaningEn = "Pauses at 4 and 7 syllables."
          )
        ),
        exampleVerse = "साधोर्विद्या ज्ञानदानाय नित्यं\nवित्तं दानं रक्षणं दुर्बलानाम्।\nप्राज्ञानां तु प्रार्थना नैव कार्या\nस्वप्नेऽपि स्यात् सर्वभूतहितेषु॥",
        exampleSource = "सुभाषितरत्नकोशः",
        exampleMeaningSa = "सज्जनानां विद्या परोपकारायैव भवति।",
        exampleMeaningHi = "सत्पुरुषों की विद्या ज्ञानदान के लिए, धन दान और दुर्बलों की रक्षा के लिए होता है; वे स्वतः ही सर्वभूतों के कल्याण में लगे रहते हैं।",
        exampleMeaningEn = "The wisdom of the virtuous is for imparting knowledge, their wealth for charity, and their strength for protecting the weak."
      ),

      createItem(
        id = "praharsini",
        nameSa = "प्रहर्षिणी",
        nameEn = "Praharsini",
        category = "समवृत्तम् (अतिजगती)",
        syllableCount = 13,
        yati = "३ तथा १० अक्षरे (त्रि-दशैः)",
        ganaRule = "म, न, ज, र, ग (ऽऽऽ  ।।।  ।ऽ।  ऽ।ऽ  ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "त्र्याशाभिर्मनजरगा प्रहर्षिणीयम्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.३८)",
            meaningSa = "यत्र म-न-ज-र गणाः गुरुश्च भवन्ति, तथा त्रि (३) आशा (१०) अक्षरेषु यतिर्भवति सा प्रहर्षिणी।",
            meaningHi = "जिसके प्रत्येक चरण में मगण, नगण, जगण, रगण और एक गुरु वर्ण (म-न-ज-र-ग) हों तथा ३ और १० वर्णों पर यति हो, वह प्रहर्षिणी है।",
            meaningEn = "Praharsini consists of Ma, Na, Ja, Ra ganas and one Guru (13 syllables), pausing at 3 and 10."
          ),
          ChhandasLakshana(
            lakshanaText = "मनजरगैः प्रहर्षिणी त्रिदशैः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "म-न-ज-र-ग गणैर्युता प्रहर्षिणी।",
            meaningHi = "म, न, ज, र और गुरु से प्रहर्षिणी बनती है।",
            meaningEn = "Features Ma-Na-Ja-Ra ganas with final guru."
          )
        ),
        exampleVerse = "उत्फुल्लस्फुटकमलोपमो मुखश्रीः\nसानन्दं जनयति वीक्षिता जनानाम्।\nआलोके नयनसुखं ददाति कान्तं\nसङ्गीतं सुमधुरमुत्तमं प्रहर्षम्॥",
        exampleSource = "काव्यकौतुकम्",
        exampleMeaningSa = "प्रफुल्लकमलसदृशं मुखम् आनन्दं जनयति।",
        exampleMeaningHi = "खिले हुए कमल के समान मुख की शोभा देखने वालों को आनन्दित करती है और मधुर संगीत चित्त में परम हर्ष उत्पन्न करता है।",
        exampleMeaningEn = "A radiant face blooming like a fresh lotus fills beholders with joy, while sweet music awakens highest delight."
      ),

      createItem(
        id = "puspitagra",
        nameSa = "पुष्पिताग्रा",
        nameEn = "Pushpitagra",
        category = "अर्धसमवृत्तम्",
        syllableCount = 12, // १२ (विषमे), १३ (समे)
        yati = "पादान्ते (प्रति चरणम्)",
        ganaRule = "विषमे: न-न-र-य (१२), समे: न-ज-ज-र-ग (१३)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "अयुजि नयुगरेफतो यकारो\nयुजि च नजौ जरगाश्च पुष्पिताग्रा।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (४.५)",
            meaningSa = "प्रथमे तृतीये च पादे नगणद्वयं, रगणः, यकारश्च (१२); द्वितीये चतुर्थे च नगणः, जगणद्वयं, रगणः, गुरुश्च (१३) भवति सा पुष्पिताग्रा।",
            meaningHi = "विषम चरणों (१ और ३) में दो नगण, एक रगण और एक यगण (१२ वर्ण) तथा सम चरणों (२ और ४) में एक नगण, दो जगण, एक रगण और एक गुरु (१३ वर्ण) हों, वह पुष्पिताग्रा है।",
            meaningEn = "Pushpitagra has 12 syllables in odd padas (Na-Na-Ra-Ya) and 13 syllables in even padas (Na-Ja-Ja-Ra-Ga)."
          ),
          ChhandasLakshana(
            lakshanaText = "पुष्पिताग्रा ननरयैर्नजौ जरगैर्युता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "अर्धसमवृत्तम्।",
            meaningHi = "अर्धसम पुष्पिताग्रा छन्द।",
            meaningEn = "Semi-equal meter with 12 and 13 syllables."
          )
        ),
        exampleVerse = "अविदितगुणदोषः सन्नपि स्वेच्छयायं\nचरति विषयमार्गे सर्वदा दुष्टचेताः।\nकथमपि यदि लब्धं सन्मतेः सङ्गमेन\nभवति विमलभावस्तत्परं श्रेय एतत्॥",
        exampleSource = "वैराग्यशतकम्",
        exampleMeaningSa = "सत्सङ्गेन दुष्टमतेरपि कल्याणं भवति।",
        exampleMeaningHi = "गुण-दोष का विचार किए बिना यह चंचल मन विषयों में भटकता है; यदि सत्संग प्राप्त हो जाए तो उसका परम कल्याण हो जाता है।",
        exampleMeaningEn = "Without weighing virtue or vice, the restless mind wanders through sensual paths; yet through noble association it achieves supreme purification."
      ),

      createItem(
        id = "viyogini",
        nameSa = "वियोगिनी (वैतालीयम्)",
        nameEn = "Viyogini",
        category = "अर्धसमवृत्तम्",
        syllableCount = 10, // १० (विषमे), ११ (समे)
        yati = "पादान्ते",
        ganaRule = "विषमे: स-स-ज-ग (१०), समे: स-भ-र-ल-ग (११)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "विषमे ससजा गुरुः समे\nसभरा ल्गोऽथ वियोगिनी मता।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (४.४)",
            meaningSa = "विषमे पादे सगणद्वयं, जगणः, गुरुश्च (१०); समे पादे सगणः, भगणः, रगणः, लघुः, गुरुश्च (११) भवति सा वियोगिनी।",
            meaningHi = "विषम चरणों (१, ३) में दो सगण, एक जगण और एक गुरु वर्ण (१० वर्ण) तथा सम चरणों (२, ४) में सगण, भगण, रगण, लघु और गुरु (११ वर्ण) हों तो वियोगिनी छन्द होता है।",
            meaningEn = "Viyogini has 10 syllables in odd quarters (Sa-Sa-Ja-Ga) and 11 syllables in even quarters (Sa-Bha-Ra-La-Ga)."
          ),
          ChhandasLakshana(
            lakshanaText = "ससजौ गुरुर्यत्र विषमे सभरा लगौ समे सा वियोगिनी।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "शृङ्गारविप्रलम्भे बहुप्रयुक्ता।",
            meaningHi = "विरह वर्णन में इसका विशेष प्रयोग होता है।",
            meaningEn = "Frequently used in separation and lamentation scenes."
          )
        ),
        exampleVerse = "रुदितं विशदं कुरङ्गदृश्या\nविरहेण प्रमदाम्बुमुच्यते स्म।\nहृदये विहितो व्यथाप्रपञ्चः\nशममायाति न यत्प्रियावियोगे॥",
        exampleSource = "कालिदासकृत-रघुवंशम् (८.२४ - अजविलापः)",
        exampleMeaningSa = "प्रियायाः वियोगे दुःखस्य पराकाष्ठा।",
        exampleMeaningHi = "मृगनयनी के विरह में राजा अज का विलाप; प्रिय के वियोग में हृदय की असह्य व्यथा अश्रुओं के रूप में बहने लगी।",
        exampleMeaningEn = "Tears of acute grief poured from the eyes at separation from the beloved, for the torment of an aching heart finds no peace in parted love."
      ),

      createItem(
        id = "arya",
        nameSa = "आर्या",
        nameEn = "Arya",
        category = "मात्रावृत्तम् (जातिः)",
        syllableCount = 0, // मात्रावृत्तम्: १२, १८, १२, १५ मात्राः
        yati = "प्रथमे द्वादश, द्वितीये अष्टादश, तृतीये द्वादश, चतुर्थे पञ्चदश मात्राः",
        ganaRule = "चतुर्मात्रिक-गणाः (अष्टौ गणाः, षष्ठे नलौ वा जगणः)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "यस्याः पादे प्रथमे द्वादश मात्रास्तथा तृतीयेऽपि।\nअष्टादश द्वितीये चतुर्थके पञ्चदश सार्या॥",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (२.१)",
            meaningSa = "यस्याः प्रथमे तृतीये च पादे द्वादश मात्राः, द्वितीये अष्टादश, चतुर्थे च पञ्चदश मात्राः भवन्ति सा आर्या।",
            meaningHi = "जिसके पहले और तीसरे चरण में १२-१२ मात्राएँ, दूसरे चरण में १८ मात्राएँ और चौथे चरण में १५ मात्राएँ हों, वह आर्या छन्द कहलाता है।",
            meaningEn = "Arya is a moraic meter (Matra-vritta) having 12 matras in the 1st and 3rd quarters, 18 in the 2nd, and 15 in the 4th."
          ),
          ChhandasLakshana(
            lakshanaText = "प्रथमे द्वादश मात्रा द्वितीयेऽष्टादश स्मृता।\nतृतीये द्वादशैव स्युश्चतुर्थे पञ्चदशार्या॥",
            sourceAuthorOrText = "पिङ्गल-छन्दःसूत्रम्",
            meaningSa = "मात्रागणैः परिगण्यते।",
            meaningHi = "मात्राओं की गणना से आर्या की सिद्धि होती है।",
            meaningEn = "Pingala's canonical definition of the Arya meter."
          )
        ),
        exampleVerse = "अपारे काव्यसंसारे कविरेकः प्रजापतिः।\nयथास्मै रोचते विश्वं तथेदं परिवर्तते॥",
        exampleSource = "आनन्दवर्धनाचार्यकृत-ध्वन्यालोकः (तृतीयोद्द्योतः)",
        exampleMeaningSa = "अनन्ते काव्यप्रपञ्चे कविरेव ब्रह्मा वर्तते, स यथा कल्पयति तथैव सर्वं जगत् प्रकाशते।",
        exampleMeaningHi = "इस असीम काव्य-संसार में एकमात्र कवि ही प्रजापति (स्रष्टा) है, जैसा उसे रुचिकर लगता है, वह सम्पूर्ण विश्व को वैसा ही रूपान्तरित कर देता है।",
        exampleMeaningEn = "In the boundless universe of poetry, the poet alone is the creator; as it pleases him, so does he transform this entire cosmos."
      ),

      createItem(
        id = "giti",
        nameSa = "गीतिः",
        nameEn = "Giti",
        category = "मात्रावृत्तम् (जातिः)",
        syllableCount = 0,
        yati = "प्रथमे तृतीये च द्वादश, द्वितीये चतुर्थे चाष्टादश मात्राः",
        ganaRule = "उभयोरर्धयोः आर्यायाः द्वितीयपादवत् (१२ + १८, १२ + १८)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "आर्याप्रथमदलोक्तं यदि कथमपि लक्षणं भवेदुभयोः।\nदलयोः कृतयतिशोभां तां गीतिं सुधिय आभाजन्ति॥",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (२.४)",
            meaningSa = "यत्र आर्यायाः द्वितीयपादवत् उभयोरर्धयोः १८-१८ मात्राः भवन्ति सा गीतिः।",
            meaningHi = "यदि आर्या के दोनों अर्धांशों में द्वितीय पाद के समान १८-१८ मात्राएँ हों (१२+१८, १२+१८), तो उसे गीति छन्द कहते हैं।",
            meaningEn = "Giti has the structure of the second half of Arya repeated in both halves (12+18 and 12+18 matras)."
          ),
          ChhandasLakshana(
            lakshanaText = "उभयोर्दलयोः सममात्रा गीतिरुदीरिता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "आर्याभेदः।",
            meaningHi = "आर्या का प्रमुख भेद गीति।",
            meaningEn = "A major variety of the Arya family."
          )
        ),
        exampleVerse = "यस्य न सविधे दयिता दवदहनस्तुहिनदीधितिस्तस्य।\nयस्य च सविधे दयिता तुहिनदीधितिर्दवदहनस्तस्य॥",
        exampleSource = "काव्यप्रकाशे मम्मटभट्टः",
        exampleMeaningSa = "प्रियायाः सान्निध्ये विरहे च चन्द्राग्निभावः।",
        exampleMeaningHi = "जिसके समीप प्रिया नहीं है, उसके लिए शीतल चन्द्रमा भी दावाग्नि बन जाता है; और जिसके पास प्रिया है, उसके लिए दावाग्नि भी चन्द्रमा के समान शीतल हो जाती है।",
        exampleMeaningEn = "To him whose beloved is away, even the cool moon is a blazing forest fire; but to him who is near his beloved, even a forest fire is soothing cool moonlight."
      ),

      createItem(
        id = "harini",
        nameSa = "हरिणी",
        nameEn = "Harini",
        category = "समवृत्तम् (अत्यष्टिः)",
        syllableCount = 17,
        yati = "६, ४ तथा ७ अक्षरे (रस-युग-हयैः)",
        ganaRule = "न, स, म, र, स, ल, ग (।।।  ।।ऽ  ऽऽऽ  ऽ।ऽ  ।।ऽ  । ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "नसमरसलागः षड्द्वैहैर्ह्रिणी मता।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५२)",
            meaningSa = "यत्र नगण-सगण-मगण-रगण-सगणाः, लघुः गुरुश्च भवन्ति, तथा ६, ४, ७ अक्षरेषु यतिर्भवति सा हरिणी।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः नगण, सगण, मगण, रगण, सगण, लघु और गुरु वर्ण (१७ वर्ण) हों तथा ६, ४ और ७ वर्णों पर यति हो, वह हरिणी छन्द है।",
            meaningEn = "Harini has Na, Sa, Ma, Ra, Sa ganas with a Laghu and Guru (17 syllables), with pauses at 6, 4, and 7."
          ),
          ChhandasLakshana(
            lakshanaText = "रसयुगहयैर्नौ सौ म्रौ सौ लगौ हरिणी मता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "६, ४, ७ यतिः।",
            meaningHi = "६, ४ और ७ पर यति वाली हरिणी।",
            meaningEn = "Pauses at 6, 10, and 17."
          )
        ),
        exampleVerse = "अभिजनवतां वृत्तं शुद्धं न चेत् कुलमुन्नतं\nकिमिह कुरुते विद्या हीनं मनो न विशोधयेत्।\nजलनिधिजलं क्षारं सर्वं यथैव न तृप्तये\nभवति महतां चेतो हीनं न कल्पयते सुखम्॥",
        exampleSource = "सुभाषितरत्नभाण्डागारम्",
        exampleMeaningSa = "सदाचारस्य महत्त्वम्।",
        exampleMeaningHi = "यदि आचरण शुद्ध न हो तो उच्च कुल क्या कर सकता है? जैसे समुद्र का अपार जल भी प्यास नहीं बुझा सकता, वैसे ही सदाचार के बिना उच्च कुल व्यर्थ है।",
        exampleMeaningEn = "What avails noble birth if character is impure? Just as the vast ocean's saline waters quench no thirst, high birth without nobility grants no lasting joy."
      ),

      createItem(
        id = "prithvi",
        nameSa = "पृथ्वी",
        nameEn = "Prithvi",
        category = "समवृत्तम् (अत्यष्टिः)",
        syllableCount = 17,
        yati = "८ तथा ९ अक्षरे (वसु-ग्रहौ)",
        ganaRule = "ज, स, ज, स, य, ल, ग (।ऽ।  ।।ऽ  ।ऽ।  ।।ऽ  ।ऽऽ  । ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "जसौ जसयला वसुग्रहयतिश्च पृथ्वी गुरुः।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.५३)",
            meaningSa = "यत्र जगण-सगण-जगण-सगण-यगणाः, लघुः गुरुश्च, तथा वसु (८) ग्रह (९) अक्षरेषु यतिः सा पृथ्वी।",
            meaningHi = "जिसके प्रत्येक चरण में जगण, सगण, जगण, सगण, यगण, एक लघु और एक गुरु वर्ण (१७ वर्ण) हों तथा ८ और ९ वर्णों पर यति हो, वह पृथ्वी छन्द है।",
            meaningEn = "Prithvi consists of Ja, Sa, Ja, Sa, Ya ganas, a Laghu, and a Guru (17 syllables), with pauses at 8 and 9."
          ),
          ChhandasLakshana(
            lakshanaText = "जसौ जसयलौ वसुग्रहयतिस्तु पृथ्वी भवेत्।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "८ तथा ९ अक्षरेषु यतिः।",
            meaningHi = "८ और ९ वर्णों पर यति वाली पृथ्वी।",
            meaningEn = "Has pauses at 8 and 9 syllables."
          )
        ),
        exampleVerse = "परेण परिभाषिते न हि मनो विकारं भजेत्\nसतां सहजरूपिणी भवति चित्तवृत्तिः क्षमा।\nयथा भुजगमण्डलं दधदपि ज्वलन्तं विषं\nन चन्दतरुर्मनागपि मुञ्चति स्वां सुधाम्॥",
        exampleSource = "शान्तिशतकम्",
        exampleMeaningSa = "सज्जनानां क्षमाशीलता।",
        exampleMeaningHi = "दूसरों के कटु वचन कहने पर भी सज्जनों का मन विकृत नहीं होता; जैसे विषधर सर्पों से लिपटे रहने पर भी चन्दन का वृक्ष अपनी सुगन्ध नहीं छोड़ता।",
        exampleMeaningEn = "The minds of the virtuous remain undisturbed even when reviled by others, for patience is natural to them; just as the sandalwood tree surrenders not its fragrance even when coiled by venomous serpents."
      ),

      createItem(
        id = "dodhaka",
        nameSa = "दोधकम्",
        nameEn = "Dodhaka",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "भ, भ, भ, ग, ग (ऽ।।  ऽ।।  ऽ।।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "दोधकमिच्छति भत्रितयाद् गौ।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१५)",
            meaningSa = "यत्र भगणत्रयं गुरुद्वयं च भवति तत् दोधकम्।",
            meaningHi = "जिसके प्रत्येक चरण में तीन भगण और दो गुरु वर्ण (भ-भ-भ-ग-ग = ११ वर्ण) हों, उसे दोधक छन्द कहते हैं।",
            meaningEn = "Dodhaka consists of three Bha-ganas and two Gurus in each 11-syllable quarter."
          ),
          ChhandasLakshana(
            lakshanaText = "भत्रितयं यदि गौ च तदोक्तं दोधकमित्यभिधानवता सा।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "भ-भ-भ-ग-ग युक्तं दोधकम्।",
            meaningHi = "तीन भगण और दो गुरुओं से दोधक बनता है।",
            meaningEn = "Defined by three Bha-ganas and two heavy syllables."
          )
        ),
        exampleVerse = "देव मुरारे भक्तजनानां\nतारक विष्णो विष्णुपदे त्वम्।\nपालय सर्वं विश्वमशेषं\nनित्यमनन्तं पादयुगं ते॥",
        exampleSource = "विष्णुस्तोत्रम्",
        exampleMeaningSa = "भगवतो विष्णोः स्तुतिः।",
        exampleMeaningHi = "हे देव! हे मुरारे! हे विष्णु! आप भक्तजनों का उद्धार करने वाले हैं, समस्त विश्व का सदा पालन करें।",
        exampleMeaningEn = "O Lord Murari, redeemer of your devotees, O all-pervading Vishnu, protect this whole cosmos through your eternal lotus feet."
      ),

      createItem(
        id = "vidyunmala",
        nameSa = "विद्युन्माला",
        nameEn = "Vidyunmala",
        category = "समवृत्तम् (अनुष्टुप्)",
        syllableCount = 8,
        yati = "४ तथा ४ अक्षरे",
        ganaRule = "म, म, ग, ग (ऽऽऽ  ऽऽऽ  ऽ ऽ - सर्वे गुरवः)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "मो मो गो गो विद्युन्माला।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.२)",
            meaningSa = "यत्र मगणद्वयं गुरुद्वयं च भवन्ति सा विद्युन्माला। अत्र सर्वेऽष्टावपि वर्णाः गुरव एव भवन्ति।",
            meaningHi = "जिसके प्रत्येक चरण में दो मगण और दो गुरु वर्ण हों (अर्थात् सभी आठों वर्ण गुरु हों), वह विद्युन्माला छन्द कहलाता है।",
            meaningEn = "Vidyunmala consists of two Ma-ganas and two Gurus (all 8 syllables are heavy)."
          ),
          ChhandasLakshana(
            lakshanaText = "सर्वैर्दीर्घैर्विद्युन्माला।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "अष्टावपि गुरुवर्णाः।",
            meaningHi = "सभी आठ वर्ण गुरु होते हैं।",
            meaningEn = "All eight syllables are long."
          )
        ),
        exampleVerse = "सा सा सीता कान्ता रम्या\nरामेणाप्ता श्यामा तन्वी।\nदृष्टा हृष्टा तुष्टा श्रेष्ठा\nलोके पूज्या मान्या धन्या॥",
        exampleSource = "छन्दःशास्त्र-उदाहरणमाला",
        exampleMeaningSa = "सीतायाः गुणगानम्।",
        exampleMeaningHi = "वह मनोरम सीता श्रीराम द्वारा प्राप्त की गईं, जो समस्त लोक में पूज्य, श्रेष्ठ और धन्य हैं।",
        exampleMeaningEn = "That delightful Sita was embraced by Rama; revered, foremost, and blessed throughout the three worlds."
      ),

      createItem(
        id = "svagata",
        nameSa = "स्वागता",
        nameEn = "Svagata",
        category = "समवृत्तम् (त्रिष्टुप्)",
        syllableCount = 11,
        yati = "पादान्ते (११ अक्षरे)",
        ganaRule = "र, न, भ, ग, ग (ऽ।ऽ  ।।।  ऽ।।  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "स्वागतेति रनभागुरुयुग्मम्।",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.१७)",
            meaningSa = "यत्र रगण-नगण-भगणाः गुरुद्वयं च भवन्ति सा स्वागता।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः रगण, नगण, भगण और दो गुरु वर्ण (र-न-भ-ग-ग = ११ वर्ण) हों, वह स्वागता छन्द है।",
            meaningEn = "Svagata consists of Ra, Na, Bha ganas, followed by two Gurus (11 syllables)."
          ),
          ChhandasLakshana(
            lakshanaText = "रान्नभाद् गुरुयुगाच्च हि स्वागता।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "र-न-भ-ग-ग गणैर्युता।",
            meaningHi = "रगण, नगण, भगण और दो गुरुओं से स्वागता बनती है।",
            meaningEn = "Features Ra-Na-Bha ganas and two heavy syllables."
          )
        ),
        exampleVerse = "स्वागतं भवतु ते विदुषां भोः\nसादरं वदत मङ्गलवाचम्।\nसज्जनैः सह समागमकाले\nहृष्टचित्तमिह भाति नितान्तम्॥",
        exampleSource = "अभिनन्दनकाव्यम्",
        exampleMeaningSa = "सज्जनानां स्वागतम्।",
        exampleMeaningHi = "विद्वानों का स्वागत हो, मंगलमय वाणी कहें; सज्जनों के समागम के समय हृदय अत्यधिक प्रसन्न हो उठता है।",
        exampleMeaningEn = "Welcome, O assembly of scholars! Utter auspicious benedictions, for when righteous souls unite, the heart rejoices deeply."
      ),

      createItem(
        id = "pancacamara",
        nameSa = "पञ्चचामरम्",
        nameEn = "Pancacamaram",
        category = "समवृत्तम् (अतिजगती)",
        syllableCount = 16,
        yati = "पादान्ते (१६ अक्षरे)",
        ganaRule = "ज, र, ज, र, ज, ग (।ऽ।  ऽ।ऽ  ।ऽ।  ऽ।ऽ  ।ऽ।  ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "जरौ जरौ जगौ च पञ्चचामरं वदन्ति तत्।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "यस्य पादे क्रमेण जगण-रगण-जगण-रगण-जगण-गुरुवर्णाः (।ऽ। ऽ।ऽ ।ऽ। ऽ।ऽ ।ऽ। ऽ) भवन्ति तत् पञ्चचामरम्।",
            meaningHi = "जिसके प्रत्येक चरण में क्रमशः जगण, रगण, जगण, रगण, जगण और एक गुरु वर्ण (ज-र-ज-र-ज-ग = १६ वर्ण) हों, वह पञ्चचामर छन्द कहलाता है।",
            meaningEn = "Pancacamaram consists of alternating Ja and Ra ganas: Ja-Ra-Ja-Ra-Ja and a final Guru (16 syllables)."
          ),
          ChhandasLakshana(
            lakshanaText = "लघ्वक्षरं गुरुस्ततः क्रमेण पञ्चचामरम्।",
            sourceAuthorOrText = "वृत्तरत्नावली",
            meaningSa = "अतिवेगवद् वृत्तम्।",
            meaningHi = "लयदार और ओजस्वी छन्द।",
            meaningEn = "A rhythmic, dynamic 16-syllable meter."
          )
        ),
        exampleVerse = "जटाटवीगलज्जलप्रवाहपावितस्थले\nगलेऽवलम्ब्य लम्बितां भुजङ्गतुङ्गमालिकाम्।\nडमड्डमड्डमड्डमन्निनादवड्डमर्वयं\nचकार चण्डताण्डवं तनोतु नः शिवः शिवम्॥",
        exampleSource = "रावणकृत-शिवताण्डवस्तोत्रम् (१)",
        exampleMeaningSa = "भगवतः शङ्करस्य ताण्डवनृत्यवर्णनम्।",
        exampleMeaningHi = "सघन जटारूपी वन से निकलती हुई गङ्गाजी के प्रवाह से पवित्र हुए कण्ठ में सर्पों की विशाल माला को धारण कर डमरू की डम-डम ध्वनि के साथ प्रचण्ड ताण्डव करने वाले भगवान् शिव हमारा कल्याण करें।",
        exampleMeaningEn = "With His neck purified by the cascade of the Ganga streaming from His tangled locks, wearing the king of serpents as a garland, performing His intense Tandava dance to the resounding damaru—may Lord Shiva bestow auspiciousness upon us!"
      ),

      createItem(
        id = "mattamayura",
        nameSa = "मत्तमयूरम्",
        nameEn = "Mattamayuram",
        category = "समवृत्तम् (शक्वरी)",
        syllableCount = 14,
        yati = "४ तथा १० अक्षरे (वेदैः आशाभिः)",
        ganaRule = "म, त, य, स, ग, ग (ऽऽऽ  ऽऽ।  ।ऽऽ  ।।ऽ  ऽ ऽ)",
        lakshanas = listOf(
          ChhandasLakshana(
            lakshanaText = "वेदै रन्ध्रैर्मत्तमायूरमुद्दिष्टम्। (म-त-य-स-ग-ग)",
            sourceAuthorOrText = "केदारभट्टकृत-वृत्तरत्नाकरः (३.४२)",
            meaningSa = "यत्र मगण-तगण-यगण-सगणाः गुरुद्वयं च भवन्ति तन् मत्तमायूरम्।",
            meaningHi = "जिसके प्रत्येक चरण में मगण, तगण, यगण, सगण और दो गुरु वर्ण हों तथा ४ और १० वर्णों पर यति हो, वह मत्तमयूर छन्द है।",
            meaningEn = "Mattamayuram has Ma, Ta, Ya, Sa ganas and two Gurus (14 syllables), pausing at 4 and 10."
          ),
          ChhandasLakshana(
            lakshanaText = "मत्तमायूरं म्तौ यसौ गौ च वेदरन्ध्रैः।",
            sourceAuthorOrText = "गङ्गादासकृत-छन्दोमञ्जरी",
            meaningSa = "वर्षावर्णने प्रयुक्तम्।",
            meaningHi = "वर्षा ऋतु में मयूरों के नृत्य का भाव प्रकट करने वाला।",
            meaningEn = "Evokes the joyous dance of peacocks in the rains."
          )
        ),
        exampleVerse = "मेघैराकाशे संवृते सान्द्रनादैः\nनृत्यन्तीह स्वैरमुन्मत्तकेकाः।\nधारापातैः प्लाविता भूमिभागाः\nसद्यः कुर्वन्ति प्रमदं विहङ्गाः॥",
        exampleSource = "ऋतुसंहारम् (२.५)",
        exampleMeaningSa = "वर्षाकाले मयूराणां नर्तनम्।",
        exampleMeaningHi = "मेघों की गम्भीर गर्जना से आकाश घिर जाने पर मयूर उन्मत्त होकर नृत्य करने लगते हैं; मूसलाधार वर्षा से धरती तृप्त हो जाती है।",
        exampleMeaningEn = "As the skies darken with rumbling monsoon clouds, wild peacocks dance with unrestrained joy, and flooded valleys bring ecstasy to the birds."
      )
    )
  }

  private fun createItem(
    id: String,
    nameSa: String,
    nameEn: String,
    category: String,
    syllableCount: Int,
    yati: String,
    ganaRule: String,
    lakshanas: List<ChhandasLakshana>,
    exampleVerse: String,
    exampleSource: String,
    exampleMeaningSa: String,
    exampleMeaningHi: String,
    exampleMeaningEn: String
  ): ChhandasItem {
    val scanned = ChhandasEngine.scanVerseToPadas(exampleVerse)
    return ChhandasItem(
      id = id,
      nameSa = nameSa,
      nameEn = nameEn,
      category = category,
      syllableCount = syllableCount,
      yati = yati,
      ganaRule = ganaRule,
      lakshanas = lakshanas,
      exampleVerse = exampleVerse,
      exampleSource = exampleSource,
      exampleMeaningSa = exampleMeaningSa,
      exampleMeaningHi = exampleMeaningHi,
      exampleMeaningEn = exampleMeaningEn,
      scansionBreakdown = scanned
    )
  }
}
