package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.model.Item
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ClubViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder =
        ClubViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Item) -> Unit) {
            with(itemView) {
                name.text = item.name
                item.image?.let { Glide.with(this).load(it).into(image)}
                itemView.setOnClickListener {
                    listener(item)
                }
            }
        }
    }
}