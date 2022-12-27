package com.example.eindosat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eindosat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(FirstFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.beranda ->{
                    replaceFragment(FirstFragment())
                }
                R.id.riwayat ->{
                    replaceFragment(SecondFragment())
                }
                R.id.kosong ->{
                    replaceFragment(ThirdFragment())
                }
                R.id.inbox ->{
                    replaceFragment(FourFragment())
                }
                R.id.profile ->{
                    replaceFragment(FiveFragment())
                }
                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(home: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activity_main_nav_host_fragment,home)
        fragmentTransaction.commit()

    }
}