package com.example.tablayoutactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayoutactivity.adapter.ViewPagerAdapter
import com.example.tablayoutactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {

        var viewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager())
        binding.viwPager.setAdapter(viewPagerAdapter)
        binding.tab.setupWithViewPager(binding.viwPager)

    }
}