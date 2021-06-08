package com.kmalif.iris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmalif.iris.databinding.ActivitySetosaBinding

class SetosaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetosaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetosaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResultDetail()
        iconBackAction()
    }

    private fun getResultDetail(){
        binding.tvResult.text = intent.getIntExtra("setosa", 0).toString()
    }

    private fun iconBackAction(){
        binding.IconBack.setOnClickListener {
            finish()
        }
    }
}