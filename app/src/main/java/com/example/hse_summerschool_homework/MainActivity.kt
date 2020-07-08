package com.example.hse_summerschool_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = MainAdapter(
            listOf(
                UserItem(
                    "Даниил Богданов",
                    "Выпускник АНОО \"Физтех-лицей\" им. П.Л. Капицы",
                    "https://github.com/exsandebest"
                ),
                ProjectItem("Проект \"Воспоминания\"", "Сохраняй лучшие моменты жизни!"),
                SkillsHeaderItem("Навыки"),
                SkillItem("C++", 2.0),
                SkillItem("Python", 1.5),
                SkillItem("JavaScript", 6.0),
                SkillItem("Kotlin", 0.2),
                SkillItem("HTML/CSS", 2.5)
            )
        )
        mainView.adapter = adapter
        mainView.addItemDecoration(SpaceItemDecoration())
    }
}

