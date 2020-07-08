package com.example.hse_summerschool_homework

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*

class UserItem(
    val name: String,
    val status: String,
    val link: String
)

class UserItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var userInfo: UserItem

    fun bind(userInfo: UserItem) {
        view.userName.text = userInfo.name
        view.userStatus.text = userInfo.status
        view.githubButton.setOnClickListener {
            view.context.startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse(userInfo.link))
            )
        }
        this.userInfo = userInfo
    }
}