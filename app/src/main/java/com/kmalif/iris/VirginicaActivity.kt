package com.kmalif.iris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmalif.iris.databinding.ActivityVirginicaBinding

class VirginicaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVirginicaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVirginicaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResultDetail()
        iconBackAction()
    }


    private fun getResultDetail(){
        binding.tvResult.text = intent.getIntExtra("virginica", 0).toString()
    }

    private fun iconBackAction(){
        binding.IconBack.setOnClickListener {
            finish()
        }
    }
}