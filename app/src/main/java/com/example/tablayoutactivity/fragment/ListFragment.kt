package com.example.tablayoutactivity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.newdemo.activity.modelClass.ItemsViewModel
import com.example.roomdatabase.dataclass.Contact
import com.example.roomdatabase.dataclass.NoteDatabase
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.adapter.ListViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    val list = ArrayList<ItemsViewModel>()
    var adapter: ListAdapter? = null
    private val noteDatabase by lazy { context?.let { NoteDatabase.getDatabase(it).noteDao() } }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_list, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {

        val rcv = view.findViewById<ListView>(R.id.userlist)


        list.add(ItemsViewModel(1, "Jay", "Android Developer"))
        list.add(ItemsViewModel(2, "Yash", "Developer"))
        list.add(ItemsViewModel(3, "Jay", "Android Developer"))
        list.add(ItemsViewModel(4, "Jay", "Android Developer"))
        list.add(ItemsViewModel(5, "Jay", "Android Developer"))
        list.add(ItemsViewModel(6, "Jay", "Android Developer"))
        list.add(ItemsViewModel(7, "Jay", "Android Developer"))
        list.add(ItemsViewModel(8, "Jay", "Android Developer"))
        list.add(ItemsViewModel(9, "Jay", "Android Developer"))
        list.add(ItemsViewModel(10, "Jay", "Android Developer"))
        list.add(ItemsViewModel(11, "Jay", "Android Developer"))
        list.add(ItemsViewModel(12, "Jay", "Android Developer"))
        list.add(ItemsViewModel(13, "Jay", "Android Developer"))
        list.add(ItemsViewModel(14, "Jay", "Android Developer"))
        list.add(ItemsViewModel(15, "Jay", "Android Developer"))

        adapter = ListViewAdapter(list)

        rcv.adapter = adapter

        rcv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                context, " selected" + position, Toast.LENGTH_SHORT
            ).show()
            val name = list[position].studentName
            val course = list[position].CourseName
            addData(position, name, course)
        }

    }

    private fun addData(position: Int, name: String, course: String) {

        val agentsCount: Int = noteDatabase!!.agentsCount(position, name, course)
        if (agentsCount > 0) {
            Toast.makeText(context, "data already exists!", Toast.LENGTH_SHORT).show()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                noteDatabase!!.addNote(Contact(position, name, course))
                Log.e("TAG", "6/04" + noteDatabase!!.getNotes())
            }
        }
    }


}