package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project.databinding.ActivityMainBinding
import com.example.project.databinding.BookingBinding

class BookingFragment: Fragment()  {
        lateinit var binding: BookingBinding
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            binding = BookingBinding.inflate(layoutInflater)

            return binding.root
        }

}


