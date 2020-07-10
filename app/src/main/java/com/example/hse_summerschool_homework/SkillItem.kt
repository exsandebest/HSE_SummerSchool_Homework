package com.example.hse_summerschool_homework

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.skills_item.view.*

class SkillItem(
    val name: String,
    val time: Double
)

class SkillItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillItem: SkillItem

    fun bind(skillItem: SkillItem) {
        view.skillName.text = skillItem.name
        view.skillTime.text = skillTimeString(skillItem.time)
        this.skillItem = skillItem
    }
}

fun skillTimeString(t: Double): String {
    if (t < 1) return "< 1 года"
    if (t < 2) return "< 2 лет"
    if (t < 3) return "< 3 лет"
    if (t < 5) return "< 5 лет"
    return "> 5 лет"
}
