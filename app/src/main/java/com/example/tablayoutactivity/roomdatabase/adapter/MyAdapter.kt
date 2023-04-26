package com.example.tablayoutactivity.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.dataclass.Contact
import com.example.tablayoutactivity.R

class MyAdapter(var courseList: ArrayList<Contact>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val studentName = ItemView.findViewById<TextView>(R.id.txtStudentName)
        val courseName = ItemView.findViewById<TextView>(R.id.txtCourseName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.studentName.text = courseList[position].name
        holder.courseName.text = courseList[position].course
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

}