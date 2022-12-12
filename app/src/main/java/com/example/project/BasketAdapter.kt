package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class BasketAdapter(private val context: BasketFragment, val dataset: List<Tours>): RecyclerView.Adapter<BasketAdapter.ItemViewHolder>()  {
    var onItemClick:((Tours) -> Unit)? = null
    private var viewModel: ToursViewModel = ViewModelProvider(context).get(ToursViewModel::class.java)


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: ImageView = view.findViewById(R.id.imageView8)
        val textView1: TextView = view.findViewById(R.id.textView18)
        val textView8: TextView = view.findViewById(R.id.textView8)
        val delete :ImageView =  view.findViewById(R.id.imageView9)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_wish, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView8.text = item.name
        val identifier=context.resources.getIdentifier(item.image1,"drawable",context.getPackageName())
        holder.textView.setImageResource(identifier)

        holder.delete.setOnClickListener {
            val p = position +1
            viewModel.updateData(0, p)

        }
        holder.itemView.setOnClickListener {view: View ->
            //       onItemClick?.invoke(item)
            val bundle = bundleOf("amount" to position)
            view.findNavController().navigate(R.id.action_basketFragment_to_infoFragment2,bundle)

        }



    }


    override fun getItemCount(): Int {
        return dataset.size
    }

}