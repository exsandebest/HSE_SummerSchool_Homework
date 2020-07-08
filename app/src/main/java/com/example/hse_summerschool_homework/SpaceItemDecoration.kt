package com.example.hse_summerschool_homework

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = 10
        outRect.bottom = 10
        outRect.left = 20
        outRect.right = 20
        }
}