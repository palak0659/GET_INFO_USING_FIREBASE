package com.example.info_store_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_layout.view.*


class DataAdapter(var list: ArrayList<DatabaseModel>) :RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {



        var name=itemView.tv_name
        var field=itemView.tv_field
        var location=itemView.tv_location
        var college=itemView.tv_college
        var hobbies=itemView.tv_hobbies



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text =list[position].tv_name
        holder.field.text =list[position].tv_field
        holder.location.text =list[position].tv_location
        holder.college.text =list[position].tv_college
        holder.hobbies.text =list[position].tv_hobbies


    }

    override fun getItemCount(): Int {
        return list.size
    }

}