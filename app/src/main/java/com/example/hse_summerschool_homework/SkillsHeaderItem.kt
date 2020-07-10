package com.example.hse_summerschool_homework

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.skills_header.view.*

class SkillsHeaderItem(
    val header: String
)

class SkillsHeaderItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var head: SkillsHeaderItem

    fun bind(head: SkillsHeaderItem) {
        view.skillsHeader.text = head.header
        this.head = head
    }
}
