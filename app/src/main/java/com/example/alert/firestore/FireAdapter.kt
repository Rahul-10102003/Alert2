package com.example.alert.firestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alert.R

class FireAdapter(var list: List<Fireitem>,var clickInterface: click):RecyclerView.Adapter<FireAdapter.Viewholder>() {
    interface click{
        fun update(position: Int)
        fun add(position: Int)
    }

    class Viewholder(view: View):RecyclerView.ViewHolder(view) {
//        val cat=view.findViewById<TextView>(R.id.cattext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemnew,parent,false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.apply {
//            cat.text=list[position].category.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}