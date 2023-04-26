package com.example.tablayoutactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newdemo.activity.modelClass.ItemsViewModel
import com.example.tablayoutactivity.R

class CustomAdapter(
    var list: ArrayList<ItemsViewModel>, val onItemClicked: (Int, String, String) -> Unit
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val studentName = ItemView.findViewById<TextView>(R.id.txtStudentName)
        val courseName = ItemView.findViewById<TextView>(R.id.txtCourseName)
        val linearLayout = ItemView.findViewById<LinearLayout>(R.id.layout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.studentName.text = list[position].studentName
        holder.courseName.text = list[position].CourseName
        holder.linearLayout.setOnClickListener {
            var id = list[position].id
            var sName = list[position].studentName
            var cName = list[position].CourseName
            onItemClicked.invoke(id, sName, cName)

        }


    }
}