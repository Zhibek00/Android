package com.example.project

import android.annotation.SuppressLint
import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ListView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController


import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import java.security.AccessController.getContext




class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        val bottomNavigationView = findViewById<BottomNavigationView
                >(R.id.bottomNv)
        val navController = findNavController(R.id.myNavHostFragment)
        bottomNavigationView.setupWithNavController(navController)

        //   setContentView(R.layout.main_page)
       // val myDataset = DataSource().loadAffirmations()

      //  val recyclerView = findViewById<RecyclerView>(R.id.rec)
       // recyclerView.adapter = RecycleAdapter(this, myDataset)

       // recyclerView.setHasFixedSize(true)
       // val listview = findViewById<ListView>(R.id.list)
       // listview.adapter= ArrayListAdapter(this,myDataset)

    }
private fun replaceF(fragment: Fragment){
    val ftr = supportFragmentManager
    val ft = ftr.beginTransaction()
    ft.replace(R.id.myNavHostFragment,fragment)
    ft.commit()
}
}
