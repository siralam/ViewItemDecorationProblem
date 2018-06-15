package com.asksira.viewitemdecoration

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class JustAnAdapter (private var context: Context) : RecyclerView.Adapter<JustAnAdapter.JustAViewHolder>() {

    val itemList = ArrayList<Int>()

    init {
        for (i in 1 until 20) {
            itemList.add(i)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JustAViewHolder {
        return JustAViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: JustAViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class JustAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tv: TextView = itemView.findViewById(R.id.tv)

        fun bind (position: Int) {
            tv.text = itemList[position].toString()
            itemView.setBackgroundColor(ContextCompat.getColor(context, when (position % 4) {
                0 -> android.R.color.holo_red_dark
                1 -> android.R.color.holo_orange_dark
                2 -> android.R.color.holo_green_dark
                else -> android.R.color.holo_blue_dark
            }))
        }

    }
}