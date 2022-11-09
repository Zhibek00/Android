package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import android.widget.ListView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityMainBinding

import java.security.AccessController.getContext




class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



     //   setContentView(R.layout.main_page)
       // val myDataset = DataSource().loadAffirmations()

      //  val recyclerView = findViewById<RecyclerView>(R.id.rec)
       // recyclerView.adapter = RecycleAdapter(this, myDataset)

       // recyclerView.setHasFixedSize(true)
       // val listview = findViewById<ListView>(R.id.list)
       // listview.adapter= ArrayListAdapter(this,myDataset)

    }
}