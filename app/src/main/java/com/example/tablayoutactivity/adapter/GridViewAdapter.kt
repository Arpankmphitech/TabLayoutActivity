package com.example.tablayoutactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.modelClass.GridViewModal

internal class GridViewAdapter(
    private val courseList: List<GridViewModal>,
    private val context: Context?
) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var txtUserName: TextView
    private lateinit var txtCourseName: TextView

    override fun getCount(): Int {
        return courseList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.grid_data_item, null)
        }
        txtCourseName = convertView!!.findViewById(R.id.txtCourseName)
        txtUserName = convertView.findViewById(R.id.txtUserName)
        txtCourseName.setText(courseList.get(position).courseName)
        txtUserName.setText(courseList.get(position).userName)
        return convertView
    }
}