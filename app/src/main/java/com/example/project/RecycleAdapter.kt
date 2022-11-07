package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(private val context: Context, val dataset: List<Affirmation>):RecyclerView.Adapter<RecycleAdapter.ItemViewHolder>()  {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: ImageView = view.findViewById(R.id.r1)
        val textView1: TextView = view.findViewById(R.id.r2)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView1.text = item.b
        holder.textView.setImageResource(item.a);
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}