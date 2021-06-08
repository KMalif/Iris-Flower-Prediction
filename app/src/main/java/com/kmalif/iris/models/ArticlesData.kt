package com.kmalif.iris.models

import com.kmalif.iris.R

object ArticlesData {

    private val articleTitle = arrayOf(
            "Fakta Menarik Bunga Iris, Tanaman Invasif Bunga Nasional Prancis",
            "Bunga Nasional dan Simbol Kerajaan Prancis"

    )

    private val articleContent = arrayOf(
            "Bunga iris merupakan salah satu jenis bunga dari famili Iridaceae yang terdiri dari 300 spesies. Bunga ini memiliki warna yang beragam dan mencolok, kecuali merah terang. Keindahannya tersebar di seluruh belahan dunia dengan warna dominan yang berbeda di setiap wilayahnya.",
            "Bunga iris adalah bunga nasional Prancis yang dalam bahasa ini disebut 'fleur-de-lis'. Lambang bunga iris dengan tiga kelopak ini juga banyak digunakan dalam berbagai desain atau motif dekorasi. Bunga iris adalah genus dari 260 hingga 300 tumbuhan berbunga dari famili Iridaceae. Iris sebagai bunga nasional Prancis memiliki sejarah yang cukup panjang. Iris telah menjadi simbol Prancis sejak abad ke-13. Keluarga kerajaan kuno Prancis menggunakan bunga itu sebagai lambang mereka selama berabad-abad. Louis VII dari Prancis sangat menyukai bunga iris. Dia meresmikan bunga itu sebagai dekorasi kerajaan eskslusif, menghiasi jubahnya dengan iris, menjadi hiasan di istana, dan dinding sebagai simbol kesempurnaan, cahaya, dan kehidupan. \n" +
                    "\n" +
                    "Selain keindahannya yang cantik, Iris juga memiliki nilai yang sangat tinggi dalam mengekstraksi wewangian yang menjadikan banyak wewangian unggulan Prancis."



    )

    private val articleImage = arrayOf(
            R.drawable.iris,
            R.drawable.ayame
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