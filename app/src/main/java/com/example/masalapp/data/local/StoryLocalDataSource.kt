package com.example.masalapp.data.local

import com.example.masalapp.data.model.StoryDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StoryLocalDataSource {

    fun observeStories(): Flow<List<StoryDto>> = flowOf(sampleStories)

    fun observeStory(id: String): Flow<StoryDto?> = flowOf(
        sampleStories.find { it.id == id }
    )

    private companion object {
        val sampleStories = listOf(
            StoryDto(
                id = "kirmizi-baslikli-kiz",
                title = "Kırmızı Başlıklı Kız",
                summary = "Büyükannesine giden küçük kızın ormandaki macerası.",
                durationMinutes = 4,
                content = """
                    Bir varmış bir yokmuş, küçük bir kız varmış. Annesi ona kırmızı bir başlık dikmiş, herkes ona Kırmızı Başlıklı Kız dermiş.

                    Bir gün annesi, “Büyükannen hasta, ona bu sepeti götür,” demiş. Kız ormana girmiş. Yol kenarında kurnaz bir kurt çıkmış.

                    Kurt önce büyükannenin evine gitmiş, sonra da küçük kızı kandırmaya çalışmış. Ama avcı yetişmiş, büyükannenin ve Kırmızı Başlıklı Kız’ın yanına gelmiş.

                    O günden sonra Kırmızı Başlıklı Kız, annesinin sözünü dinlemiş ve yoldan sapmamış. Hepsi mutlu mesut yaşamışlar.
                """.trimIndent()
            ),
            StoryDto(
                id = "kulkedisi",
                title = "Külkedisi",
                summary = "İyiliğin ve sabrın bir balo gecesinde ödüllendirildiği masal.",
                durationMinutes = 5,
                content = """
                    Bir varmış bir yokmuş, çok iyi kalpli bir kız varmış. Üvey annesi ve kız kardeşleri ona Külkedisi dermiş, çünkü her işi ona yaptırırlarmış.

                    Bir gün sarayda büyük bir balo düzenlenmiş. Külkedisi de gitmek istemiş ama evde bırakılmış. O sırada peri annesi gelmiş, bir balkabağını at arabasına, fareleri atlara çevirmiş.

                    Külkedisi baloda prensle dans etmiş. Gece yarısı büyünün bozulacağını unutup kaçmış, cam bir pabucu merdivenlerde kalmış.

                    Prens pabucu denemiş, yalnızca Külkedisi’ne uymuş. İyilik ve sabır ödüllendirilmiş; ikisi de mutlu mesut yaşamışlar.
                """.trimIndent()
            ),
            StoryDto(
                id = "rapunzel",
                title = "Rapunzel",
                summary = "Kulesinde bekleyen uzun saçlı kızın umut dolu hikâyesi.",
                durationMinutes = 4,
                content = """
                    Bir varmış bir yokmuş, yüksek bir kulede Rapunzel adında bir kız yaşarmış. Saçları altın gibi parlarmış ve çok uzunmuş.

                    Cadı, “Rapunzel, Rapunzel, saçlarını sarkıt,” diye seslenirmiş. Rapunzel saçlarını pencereden sarkıtır, cadı da onlarla kuleye tırmanırmış.

                    Bir gün bir prens bu sesi duymuş, aynı sözlerle kuleye çıkmış. Rapunzel ile prens arkadaş olmuş, sonra da birbirlerine güvenmişler.

                    Cadı onları ayırmaya çalışmış ama umutları bitmemiş. Sonunda Rapunzel ve prens yeniden kavuşmuş, özgürce yaşamışlar.
                """.trimIndent()
            ),
            StoryDto(
                id = "hansel-gretel",
                title = "Hansel ve Gretel",
                summary = "Ormanda kaybolan iki kardeşin zekâsı ve cesareti.",
                durationMinutes = 5,
                content = """
                    Bir varmış bir yokmuş, Hansel ve Gretel adında iki kardeş varmış. Bir gün ormanda kaybolmuşlar.

                    Ekmek kırıntılarıyla yolu işaretlemişler ama kuşlar kırıntıları yemiş. Derken şekerden, çikolatadan bir ev görmüşler.

                    Evde yaşayan cadı onları kandırmak istemiş. Gretel çok uyanık davranmış, Hansel’i kurtarmış.

                    İki kardeş el ele tutuşup evlerine dönmüşler. Bir daha ormanda ayrı düşmemiş, birbirlerine hep sahip çıkmışlar.
                """.trimIndent()
            )
        )
    }
}
