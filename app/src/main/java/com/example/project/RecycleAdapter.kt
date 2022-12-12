package com.example.project


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class RecycleAdapter(private val context: ToursFragment, val dataset: List<Tours>):RecyclerView.Adapter<RecycleAdapter.ItemViewHolder>()  {
     var onItemClick:((Tours) -> Unit)? = null

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: ImageView = view.findViewById(R.id.r1)
        val textView1: TextView = view.findViewById(R.id.r2)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView1.text = item.name

        val identifier=context.resources.getIdentifier(item.image1,"drawable",context.getPackageName())
        holder.textView.setImageResource(identifier)
        holder.itemView.setOnClickListener {view: View ->
     //       onItemClick?.invoke(item)
            val bundle = bundleOf("amount" to position)
            view.findNavController().navigate(R.id.action_toursFragment_to_infoFragment2,bundle)

       }

    }


    override fun getItemCount(): Int {
        return dataset.size
    }

}