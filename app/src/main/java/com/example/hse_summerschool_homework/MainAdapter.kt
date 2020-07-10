package com.example.hse_summerschool_homework

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.skills_header.view.*

class MainAdapter(private var items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> 0
            1 -> 1
            2 -> 2
            else -> 3
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> UserItemHolder(inflater.inflate(R.layout.user_item, parent, false))
            1 -> ProjectItemHolder(inflater.inflate(R.layout.project_item, parent, false))
            2 -> SkillsHeaderItemHolder(inflater.inflate(R.layout.skills_header, parent, false))
            3 -> SkillItemHolder(inflater.inflate(R.layout.skills_item, parent, false))
            else -> throw Exception("Incorrect viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as UserItemHolder).bind(items[position] as UserItem)
            1 -> (holder as ProjectItemHolder).bind(items[position] as ProjectItem)
            2 -> {
                (holder as SkillsHeaderItemHolder).bind(items[position] as SkillsHeaderItem)
                holder.view.filterButton.setOnClickListener {
                    val int = Intent(it.context, FilterActivity::class.java)
                    (it.context as MainActivity).startActivityForResult(int, 0)
                }
            }
            3 -> (holder as SkillItemHolder).bind(items[position] as SkillItem)
        }
    }

    override fun getItemCount(): Int = items.size
}
