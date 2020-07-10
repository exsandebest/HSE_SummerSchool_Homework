package com.example.hse_summerschool_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*
import kotlinx.android.synthetic.main.filter_item.view.*

class FilterActivity : AppCompatActivity() {

    private var boxes = booleanArrayOf(true, true, true, true, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        if (intent.getBooleanArrayExtra("currentFilter") != null) {
            boxes = intent.getBooleanArrayExtra("currentFilter")!!
            var idx = 0
            for (v in recycler.children) {
                v.checkBox.setChecked(boxes[idx])
                ++idx
            }
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FilterAdapter(
            listOf(
                FilterItem("< 1 года", 0.5),
                FilterItem("< 2 лет", 1.5),
                FilterItem("< 3 лет", 2.5),
                FilterItem("< 5 лет", 4.5),
                FilterItem("> 5 лет", 5.5)
            )
        )

        applyButton.setOnClickListener {
            var idx = 0
            for (v in recycler.children) {
                boxes[idx] = v.checkBox.isChecked
                ++idx
            }
            setResult(Activity.RESULT_OK, Intent().putExtra("filter", boxes))
            finish()
        }
    }
}
