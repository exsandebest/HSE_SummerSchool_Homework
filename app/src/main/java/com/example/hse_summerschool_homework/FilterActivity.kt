package com.example.hse_summerschool_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*


class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FilterAdapter( listOf(
            FilterItem("< 1 года", 0.5),
            FilterItem("< 2 лет", 1.5),
            FilterItem("< 3 лет", 2.5),
            FilterItem("< 5 лет", 4.5),
            FilterItem("> 5 лет", 5.5)
        ))
    }
}
