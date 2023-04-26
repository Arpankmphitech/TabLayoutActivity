package com.example.tablayoutactivity.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tablayoutactivity.R
import com.example.tablayoutactivity.fragment.GridFragment
import com.example.tablayoutactivity.fragment.ListFragment
import com.example.tablayoutactivity.fragment.RecyclerFragment
import com.example.tablayoutactivity.fragment.StorageData


class ViewPagerAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0) fragment = RecyclerFragment() else if (position == 1) fragment =
            GridFragment() else if (position == 2) fragment =
            ListFragment() else if (position == 3) fragment = StorageData()
        return fragment!!
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0) {
            title = "Recycler"
        } else if (position == 1) {
            title =
                "GridView"
        } else if (position == 2) {
            title = "ListView"
        }else if (position == 3) {
            title = "storage Data"
        }
        return title
    }
}