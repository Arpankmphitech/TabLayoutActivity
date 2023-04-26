package com.example.tablayoutactivity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import com.example.roomdatabase.dataclass.Contact
import com.example.roomdatabase.dataclass.NoteDatabase
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.adapter.GridViewAdapter
import com.example.tablayoutactivity.modelClass.GridViewModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GridFragment : Fragment() {

    var courseList = ArrayList<GridViewModal>()
    private val noteDatabase by lazy { context?.let { NoteDatabase.getDatabase(it).noteDao() } }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_grid, container, false)

        initView(view)



        return view
    }

    private fun initView(view: View) {

        val grid = view.findViewById<GridView>(R.id.idGRV)


        courseList.add(GridViewModal(1, "Jay", "Android Developer"))
        courseList.add(GridViewModal(2, "Yash", "Android Developer"))
        courseList.add(GridViewModal(3, "Meet", "Android Developer"))
        courseList.add(GridViewModal(4, "Mitesh", "Android Developer"))
        courseList.add(GridViewModal(5, "Arpan", "Android Developer"))
        courseList.add(GridViewModal(6, "Denish", "Android Developer"))
        courseList.add(GridViewModal(7, "Sumil", "Android Developer"))
        courseList.add(GridViewModal(8, "Ajay", "Android Developer"))
        courseList.add(GridViewModal(9, "Nayan", "Android Developer"))
        courseList.add(GridViewModal(10, "Het", "Android Developer"))
        courseList.add(GridViewModal(11, "Krish", "Android Developer"))
        courseList.add(GridViewModal(12, "Jash", "Android Developer"))
        courseList.add(GridViewModal(13, "Ashvin", "Android Developer"))
        courseList.add(GridViewModal(14, "Sumit", "Android Developer"))
        courseList.add(GridViewModal(15, "Harsh", "Android Developer"))
        courseList.add(GridViewModal(16, "Vipul", "Android Developer"))
        courseList.add(GridViewModal(17, "Pritesh", "Android Developer"))
        courseList.add(GridViewModal(18, "Sarthik", "Android Developer"))
        courseList.add(GridViewModal(19, "Bhavik", "Android Developer"))
        courseList.add(GridViewModal(20, "Sumit", "Android Developer"))
        courseList.add(GridViewModal(21, "Aakash", "Android Developer"))
        courseList.add(GridViewModal(22, "Sahil", "Android Developer"))
        courseList.add(GridViewModal(23, "Ankit", "Android Developer"))
        courseList.add(GridViewModal(24, "Sonu", "Android Developer"))
        courseList.add(GridViewModal(25, "Najmin", "Android Developer"))
        courseList.add(GridViewModal(26, "Jayesh", "Android Developer"))


        val courseAdapter = GridViewAdapter(courseList = courseList, context)

        grid.adapter = courseAdapter

        grid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(context, " selected" + position, Toast.LENGTH_SHORT).show()

            val idModel = courseList[position].id
            val name = courseList[position].userName
            val course = courseList[position].courseName

            addData(idModel, name, course)
        }

        CoroutineScope(Dispatchers.IO).launch {

        }



    }

    private fun addData(idModel: Int, name: String, course: String) {
        val agentsCount: Int = noteDatabase!!.agentsCount(idModel, name, course)
        if (agentsCount > 0) {
            Toast.makeText(context, "data already exists!", Toast.LENGTH_SHORT).show()
        } else {

            noteDatabase!!.addNote(Contact(idModel, name, course))
            Log.e("TAG", "6/04" + noteDatabase!!.getNotes())
        }

    }
}