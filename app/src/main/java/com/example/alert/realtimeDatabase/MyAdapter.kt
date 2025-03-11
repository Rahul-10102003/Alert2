package com.example.alert.realtimeDatabase

import android.annotation.SuppressLint
import android.os.Build.VERSION_CODES.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alert.databinding.RecycleritemBinding

class MyAdapter(var list:ArrayList<Item>,var clickInterface:Click):RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(var view: View):RecyclerView.ViewHolder(view){
//        var name=view.findViewById<TextView>(R.i)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
//    var binding:RecycleritemBinding=RecycleritemBinding.inflate(this,parent:)
//
//    class ViewHolder (var view: View): RecyclerView.ViewHolder(view){
//
//        var name = view.findViewById<TextView>(R.id.setname)
//        var subject = view.findViewById<TextView>(R.id.setsubject)
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R..item_layout,parent,false)
//        return ViewHolder(view)
//    }

//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.apply{
//            id.text=list[position].id.toString()
//            name.text = list[position].title
//            subject.text = list[position].description
////            view.setOnClickListener(){
////                listinterface.update(position)
////            }
////            view.setOnLongClickListener(){
////                listinterface.delete(position)
////                return@setOnLongClickListener true
////            }
//
//        }
//    }
//
//    interface Click{
//        fun update(position : Int)
//        fun delete(position: Int)
//    }
}

class Click {

}
