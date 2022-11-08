package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.main_page)
        val myDataset = DataSource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.rec)
        recyclerView.adapter = RecycleAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
        val listview = findViewById<ListView>(R.id.list)
        listview.adapter= ArrayListAdapter(this,myDataset)

    }
}