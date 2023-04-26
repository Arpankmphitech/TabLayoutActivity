package com.example.tablayoutactivity.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.dataclass.Contact
import com.example.roomdatabase.dataclass.NoteDatabase
import com.example.roomdatabasedemo.roomdatabase.inVisible
import com.example.roomdatabasedemo.roomdatabase.visible
import com.example.tablayoutactivity.databinding.FragmentStorageDataBinding
import com.example.tablayoutactivity.roomdatabase.adapter.MyAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StorageData : Fragment() {

    var courseList = ArrayList<Contact>()
    private val noteDatabase by lazy { context?.let { NoteDatabase.getDatabase(it).noteDao() } }
    lateinit var binding: FragmentStorageDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStorageDataBinding.inflate(inflater, container, false)
        binding.progressBar.visible()

        initView()

        return binding.root
    }

    private fun initView() {

        binding.rcvDataStorage.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        CoroutineScope(Dispatchers.IO).launch {
            courseList = noteDatabase!!.getNotes() as ArrayList<Contact>
            Log.e("TAG", "6" + courseList)
            var adapter = MyAdapter(courseList)
            binding.rcvDataStorage.adapter = adapter
        }
        binding.progressBar.inVisible()
    }

}