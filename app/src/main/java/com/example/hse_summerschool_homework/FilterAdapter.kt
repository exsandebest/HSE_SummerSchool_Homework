package com.example.hse_summerschool_homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FilterAdapter(var items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilterItemHolder(inflater.inflate(R.layout.filter_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as FilterItemHolder).bind(items[position] as FilterItem)
        }
    }

    override fun getItemCount() : Int = items.size
}
