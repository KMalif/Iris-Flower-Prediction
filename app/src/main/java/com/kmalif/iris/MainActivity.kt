package com.kmalif.iris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kmalif.iris.databinding.ActivityMainBinding
import com.kmalif.iris.fragments.HistoryFragment
import com.kmalif.iris.fragments.HomeFragment
import com.kmalif.iris.fragments.PredictionFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBotomNavAction()
        setCurrentFragment(HomeFragment())
    }

    private fun onBotomNavAction(){
        binding.BottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icHome ->setCurrentFragment(HomeFragment())
                R.id.icPredict ->setCurrentFragment(PredictionFragment())
                R.id.icHistory ->setCurrentFragment(HistoryFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.Container, fragment).addToBackStack(null).commit()
    }
}