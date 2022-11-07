package com.example.project

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessControlContext

public  class ArrayListAdapter(val context: Activity, val dataset: List<Affirmation>) : ArrayAdapter<Affirmation>(context,R.layout.array_list,dataset) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
      // val inflater :LayoutInflater = LayoutInflater.from(context)
        val view= LayoutInflater.from(parent.context).inflate(R.layout.array_list, parent, false)

     //   val view :View = inflater.inflate(R.layout.array_list,null)
        val image:ImageView = view.findViewById(R.id.a1)
        val text : TextView = view.findViewById(R.id.a2)


        image.setImageResource(dataset[position].a)
        text.text=dataset[position].b


        return view
    }
}