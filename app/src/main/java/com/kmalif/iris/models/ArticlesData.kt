package com.kmalif.iris.models

import com.kmalif.iris.R

object ArticlesData {

    private val articleTitle = arrayOf(
            "Fakta Menarik Bunga Iris, Tanaman Invasif Bunga Nasional Prancis",
            "Bunga Nasional dan Simbol Kerajaan Prancis",
            "Iris, genus tanaman berbunga dengan bunga mencolok dan unik cantik di musim semi hingga musim panas",
            "Perbedaan Sepal dan Petal pada bunga"

    )

    private val articleContent = arrayOf(
            "Bunga iris merupakan salah satu jenis bunga dari famili Iridaceae yang terdiri dari 300 spesies. Bunga ini memiliki warna yang beragam dan mencolok, kecuali merah terang. Keindahannya tersebar di seluruh belahan dunia dengan warna dominan yang berbeda di setiap wilayahnya.",
            "Bunga iris adalah bunga nasional Prancis yang dalam bahasa ini disebut 'fleur-de-lis'. Lambang bunga iris dengan tiga kelopak ini juga banyak digunakan dalam berbagai desain atau motif dekorasi. Bunga iris adalah genus dari 260 hingga 300 tumbuhan berbunga dari famili Iridaceae. Iris sebagai bunga nasional Prancis memiliki sejarah yang cukup panjang. Iris telah menjadi simbol Prancis sejak abad ke-13. Keluarga kerajaan kuno Prancis menggunakan bunga itu sebagai lambang mereka selama berabad-abad. Louis VII dari Prancis sangat menyukai bunga iris. Dia meresmikan bunga itu sebagai dekorasi kerajaan eskslusif, menghiasi jubahnya dengan iris, menjadi hiasan di istana, dan dinding sebagai simbol kesempurnaan, cahaya, dan kehidupan. \n" +
                    "\n" +
                    "Selain keindahannya yang cantik, Iris juga memiliki nilai yang sangat tinggi dalam mengekstraksi wewangian yang menjadikan banyak wewangian unggulan Prancis.",
            "Nama Iris diambil dari kata bahasa Yunani untuk pelangi, yang juga merupakan nama dari dewi pelangi Yunani, Iris. Ya, seperti pelangi yang memiliki banyak warna. Warna bunga Iris memiliki banyak ragam, dari kalem hingga garang, dari ceria hingga sendu. Dari satu warna hingga perpaduan beberapa warna. Selain sebagai nama ilmiah, bunga iris juga banyak digunakan sebagai nama umum untuk semua spesies Iris, begitu juga untuk nama beberapa milik genera lain yang terkait erat.\n" +
                    "\n" +
                    "Nama umum untuk beberapa spesies adalah ‘flags‘ atau ‘bendera’, sedangkan tanaman dari subgenus Scorpiris secara luas dikenal sebagai ‘junos’, terutama dalam hortikultura. Ini adalah bunga taman yang populer. Beberapa genera masuk ke dalam Iris. Genera Belamcanda monotipik yang sering dipisahkan (blackberry lily, I. domestica), Hermodactylus (snake’s head iris, I. tuberosa), dan Pardanthopsis (iris vesper, I. dichotoma) saat ini termasuk dalam Iris.\n" +
                    "\n" +
                    "Tiga varietas Iris digunakan dalam data bunga Iris yang diuraikan oleh Ronald Fisher dalam makalahnya tahun 1936. Penggunaan berbagai pengukuran dalam masalah taksonomi sebagai contoh analisis diskriminan linier.",
            "Bunga adalah organ reproduksi penting dalam tanaman berbunga. Bunga angiosperma terdiri dari berbagai bagian yang mengandung fungsi khusus. Androecium dan gynoecium terutama terlibat dalam reproduksi oleh produksi butiran serbuk sari, perkecambahan butir serbuk sari dan pemupukan, masing-masing. Sepal dan kelopak secara tidak langsung membantu proses di atas. Kelopak menarik penyerbuk menggunakan warna dan aroma yang menarik dan membantu dalam penyerbukan. Sepal berwarna hijau dan terlibat dalam memberikan perlindungan pada bunga selama kondisi kuncup. Ini adalah perbedaan utama antara sepal dan kelopak. Sepal dapat didefinisikan sebagai bagian dari bunga di tanaman berbunga (angiospermae). Sepal biasanya berwarna hijau. Mereka melindungi bunga di panggung kuncup dan bertindak sebagai pendukung untuk kelopak yang mekar. Nama kolektif untuk sepal adalah kelopak. Tampuk adalah bagian luar, yaitu whorl, yang membentuk bunga. Pada bunga, sepal dan kelopak adalah daun setelah modifikasi. Whorl steril eksternal bunga adalah sepal (kelopak) dan kelopak (corolla). Bagian-bagian ini bersama-sama membentuk perianth. Sepal yang terbentuk dapat berupa struktur bebas yang disebut polisepalus atau struktur menyatu yang disebut gamosepalous. "



    )

    private val articleImage = arrayOf(
            R.drawable.iris,
            R.drawable.ayame,
            R.drawable.japonica,
            R.drawable.brojolintang
    )

    val listArticles : ArrayList<Articles>
        get() {
            val listAtcls = arrayListOf<Articles>()
            for (position in articleTitle.indices){
                val articles = Articles()
                articles.title = articleTitle[position]
                articles.content = articleContent[position]
                articles.image = articleImage[position]
                listAtcls.add(articles)
            }
            return listAtcls
        }

}