package com.kmalif.iris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kmalif.iris.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDetailArticle()
    }


    private fun getDetailArticle(){
        binding.ArticleTitle.text = intent.getStringExtra("ArticleTitle")
        binding.ArticleContent.text = intent.getStringExtra("ArticleContent")
        val image = intent.getIntExtra("ArticleImage", 0)
        Glide.with(this)
            .load(image)
            .into(binding.ImgArticle)
    }


}