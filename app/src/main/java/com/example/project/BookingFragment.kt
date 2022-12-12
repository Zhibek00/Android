package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.project.databinding.ActivityMainBinding
import com.example.project.databinding.BookingBinding

class BookingFragment: Fragment()  {
        lateinit var binding: BookingBinding
        private lateinit var viewModel: ToursViewModel

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            binding = BookingBinding.inflate(layoutInflater)
            viewModel = ViewModelProvider(this).get(ToursViewModel::class.java)

            val pos: Int? = arguments?.getInt("amount")

            viewModel.readData.observe(viewLifecycleOwner, Observer { tourlist ->

                val identifier=requireContext().resources.getIdentifier(tourlist[pos!!].image1,"drawable",requireContext().getPackageName())
                binding.imageView7.setImageResource(identifier)
                binding.textView21.text = tourlist[pos!!].name

                })
            return binding.root
        }

}


