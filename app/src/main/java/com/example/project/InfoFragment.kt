package com.example.project

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.TourInformationBinding


class InfoFragment : AppCompatActivity() {
   private lateinit var binding :TourInformationBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = TourInformationBinding.inflate(layoutInflater)
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        val q = intent.getParcelableExtra<Affirmation>( "affir")


        if (q != null) {
            binding.imageView2.setImageResource(q.a)
        }

        setContentView(binding.root)









    }

}