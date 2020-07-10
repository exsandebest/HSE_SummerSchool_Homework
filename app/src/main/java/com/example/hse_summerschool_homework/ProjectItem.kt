package com.example.hse_summerschool_homework

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.project_item.view.*

class ProjectItem(
    val header: String,
    val description: String
)

class ProjectItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var projectItem: ProjectItem

    fun bind(projectItem: ProjectItem) {
        view.projectDescription.text = projectItem.description
        view.projectHeader.text = projectItem.header
        this.projectItem = projectItem
    }
}
