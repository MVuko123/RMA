package com.example.orwma_lv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.orwma_lv2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_new.*


class NewActivity: AppCompatActivity()  {

    lateinit var binding: ActivityNewBinding

    //link: https://www.youtube.com/watch?v=Q2HY58s9cHs, znaci sve "radi" osim sto mi binding nece za ovaj "NewActivity" te ne mogu korisiti fragmente u toj aktivnosti


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_new)

        binding.fragment1Btn.setOnClickListener {

            replaceFragment(Fragment1())
            

        }

        binding.fragment2Btn.setOnClickListener {

            replaceFragment(Fragment2())

        }



    }

    private fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }
}