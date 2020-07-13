package com.example.hse_summerschool_homework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var filter = booleanArrayOf(true, true, true, true, true)
    val m = mapOf(0.5 to 0, 1.5 to 1, 2.5 to 2, 4.5 to 3, 5.5 to 4)
    val staticElements = listOf(
        UserItem(
            "Даниил Богданов",
            "Выпускник АНОО \"Физтех-лицей\" им. П.Л. Капицы",
            "https://github.com/exsandebest"
        ),
        ProjectItem("Проект \"Воспоминания\"", "Приложение для сохранения воспоминаний текстом: Календарь + Заметки в стиле Google Photos, и всё это заточено под воспоминания"),
        SkillsHeaderItem("Навыки")
    )
    val languages = listOf(
        SkillItem("C++", 2.5),
        SkillItem("Python", 1.5),
        SkillItem("JavaScript", 5.5),
        SkillItem("Kotlin", 0.5),
        SkillItem("HTML/CSS", 2.5)
    )
    var viewElements = staticElements.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewElements.addAll(languages)

        mainView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = MainAdapter(
            viewElements,
            filter
        )
        mainView.adapter = adapter
        mainView.addItemDecoration(SpaceItemDecoration())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 111 && resultCode == Activity.RESULT_OK && data != null) {
            filter = data.getBooleanArrayExtra("filter")
            val tempList: MutableList<Any> = emptyList<Any>().toMutableList()
            for (lang in languages) {
                if (filter[m[lang.time]!!]) tempList.add(lang)
            }
            viewElements = staticElements.toMutableList()
            viewElements.addAll(tempList)
            val adapter = MainAdapter(
                viewElements,
                filter
            )
            mainView.adapter = adapter
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
