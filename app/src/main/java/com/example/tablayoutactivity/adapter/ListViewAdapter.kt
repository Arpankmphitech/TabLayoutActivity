package com.example.tablayoutactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.newdemo.activity.modelClass.ItemsViewModel
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.fragment.ListFragment
import java.util.ArrayList

class ListViewAdapter(
    private val arrayList: ArrayList<ItemsViewModel>
) : BaseAdapter() {
    private lateinit var sNameList: TextView
    private lateinit var cNameList: TextView
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(parent.context).inflate(R.layout.list_data_item, parent, false)
        sNameList = convertView.findViewById(R.id.txtStudentName)
        cNameList = convertView.findViewById(R.id.txtCourseName)
        sNameList.text = arrayList[position].studentName
        cNameList.text = arrayList[position].CourseName
        return convertView
    }
}