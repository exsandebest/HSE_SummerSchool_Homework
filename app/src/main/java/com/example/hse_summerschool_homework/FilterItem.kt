package com.example.hse_summerschool_homework


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_item.view.*

class FilterItem(
    val header: String,
    val id : Double
)

class FilterItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var filterItem: FilterItem

    fun bind(filterItem: FilterItem) {
        view.checkBox.text = filterItem.header
        this.filterItem = filterItem
    }
}
