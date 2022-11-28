package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.project.databinding.LoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : LoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = LoginBinding.inflate(layoutInflater)
         binding.button4.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_toursFragment)
        }
        return binding.root
    }

}