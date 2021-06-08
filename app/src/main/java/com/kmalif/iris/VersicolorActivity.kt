package com.kmalif.iris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmalif.iris.databinding.ActivityVersicolorBinding

class VersicolorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVersicolorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersicolorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResultDetail()
        iconBackAction()
    }

    private fun getResultDetail(){
        binding.tvResult.text = intent.getIntExtra("versicolor", 0).toString()
    }

    private fun iconBackAction(){
        binding.IconBack.setOnClickListener {
            finish()
        }
    }
}