package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project.databinding.FragmentBasketBinding

// TODO:


class BasketFragment : Fragment() {
    lateinit var binding : FragmentBasketBinding
    private lateinit var viewModel: ToursViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBasketBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(ToursViewModel::class.java)
        val recyclerView = binding.rec
        viewModel.basketData.observe(viewLifecycleOwner, Observer { tourlist ->
            val adapter = BasketAdapter(this , tourlist)
            recyclerView.adapter = adapter

            /*   adapter.onItemClick = {
                   val intent = Intent(requireContext(), InfoFragment::class.java)
                   intent.putExtra("affir", it)
                   requireContext().startActivity(intent)
               }*/
        })

        return binding.root

    }

    fun getPackageName(): String? {
          return context?.packageName;


    }


}