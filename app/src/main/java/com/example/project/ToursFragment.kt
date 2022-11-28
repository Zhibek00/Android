package com.example.project

//noinspection SuspiciousImport
import com.example.project.R.id
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment.Companion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project.databinding.MainPageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ContextUtils.getActivity


class ToursFragment : Fragment() {
    lateinit var binding: MainPageBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = MainPageBinding.inflate(layoutInflater)
        //   setContentView(R.layout.main_page)
        val myDataset = DataSource().loadAffirmations()

        val recyclerView = binding.rec
        val ffff = RecycleAdapter(requireContext(), myDataset)
        recyclerView.adapter = ffff
        ffff.onItemClick = {
            val intent = Intent(requireContext(), InfoFragment::class.java)
            intent.putExtra("affir", it)
            requireContext().startActivity(intent)
        }
        recyclerView.setHasFixedSize(true)

        val listview = binding.list

        val hhh = ArrayListAdapter(requireContext() as Activity, myDataset)
        listview.adapter =hhh
        hhh.onItemClick = {
            val intent = Intent(requireContext(), InfoFragment::class.java)
            intent.putExtra("affir", it)
            requireContext().startActivity(intent)
        }
            return binding.root

    }







}