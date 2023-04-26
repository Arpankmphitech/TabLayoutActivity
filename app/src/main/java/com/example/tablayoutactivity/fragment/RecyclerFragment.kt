package com.example.tablayoutactivity.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newdemo.activity.modelClass.ItemsViewModel
import com.example.roomdatabase.dataclass.Contact
import com.example.roomdatabase.dataclass.NoteDatabase
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.adapter.CustomAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RecyclerFragment : Fragment() {

    val list = ArrayList<ItemsViewModel>()
    private val noteDatabase by lazy { context?.let { NoteDatabase.getDatabase(it).noteDao() } }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_recycler, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {

        val rcv = view.findViewById<RecyclerView>(R.id.rcvData)

        rcv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
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

        val adapter = CustomAdapter(list) { id, sName, cName ->
            matchData(id, sName, cName)
//            Toast.makeText(context, "==" + id + "==" + sName + "==" + cName, Toast.LENGTH_SHORT).show()
        }
        rcv.adapter = adapter

    }

    private fun matchData(id: Int, sName: String, cName: String) {

        val agentsCount: Int = noteDatabase!!.agentsCount(id, sName, cName)
        if (agentsCount > 0) {
            Toast.makeText(context, "data already exists!", Toast.LENGTH_SHORT).show()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                noteDatabase!!.addNote(Contact(id, sName, cName))
                Log.e("TAG", "6/04" + noteDatabase!!.getNotes())
            }
        }
    }
}