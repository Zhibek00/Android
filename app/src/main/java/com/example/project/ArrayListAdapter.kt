package com.example.project

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import java.security.AccessControlContext

public  class ArrayListAdapter(val context: Activity, var dataset: List<Tours>) : ArrayAdapter<Tours>(context,R.layout.array_list,dataset) {
    var onItemClick:((Affirmation) -> Unit)? = null

    override fun getView( position: Int, convertView: View?, parent: ViewGroup): View {
      // val inflater :LayoutInflater = LayoutInflater.from(context)
        val view= LayoutInflater.from(parent.context).inflate(R.layout.array_list, parent, false)
        Log.d("positionnnn",dataset.size.toString())
        Log.d("position",position.toString())
     //   val view :View = inflater.inflate(R.layout.array_list,null)
        val image:ImageView = view.findViewById(R.id.a1)
        val text : TextView = view.findViewById(R.id.a2)

        val identifier=context.resources.getIdentifier(dataset[position!!].image1,"drawable",context.getPackageName())
        image.setImageResource(identifier)
        text.text=dataset[position!!].name
        view.setOnClickListener {
            val tt : Int? = dataset[position].id
            val j = tt?.minus(1)
            val bundle = bundleOf("amount" to j)
            view.findNavController().navigate(R.id.action_toursFragment_to_infoFragment2, bundle)
        }
        //    view.setOnClickListener {
         //       onItemClick?.invoke(dataset[position])

           // }

        return view
    }
    fun setData(newData: List<Tours>){
        dataset = newData
        notifyDataSetChanged()
    }
}