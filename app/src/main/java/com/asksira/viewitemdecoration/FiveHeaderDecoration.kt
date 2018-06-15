package com.asksira.viewitemdecoration

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class FiveHeaderDecoration: RecyclerView.ItemDecoration() {

    private var header: Bitmap? = null
    private val paint = Paint()

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        val params = view?.layoutParams as? RecyclerView.LayoutParams
        if (params == null || parent == null) {
            super.getItemOffsets(outRect, view, parent, state)
        } else {
            val position = params.viewAdapterPosition
            val number = (parent.adapter as? JustAnAdapter)?.itemList?.getOrNull(position)
            if (number == 5) {
                outRect?.set(0, 48.dp(), 0, 0)
            } else {
                super.getItemOffsets(outRect, view, parent, state)
            }
        }
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        initHeader(parent)
        if (parent == null) return
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(view)
            val number = (parent.adapter as? JustAnAdapter)?.itemList?.getOrNull(position)
            if (number == 5) {
                header?.let {
                    c?.drawBitmap(it, 0.toFloat(), view.top.toFloat() - 48.dp(), paint)
                }
            } else {
                super.onDraw(c, parent, state)
            }
        }
    }

    private fun initHeader(parent: RecyclerView?) {
        if (header == null) {
            val view = parent?.context?.inflate(R.layout.decoration, parent, false)
            val bitmap = Bitmap.createBitmap(parent?.width?:0, 40.dp(), Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            view?.layout(0, 0, parent.width, 40.dp())
            view?.draw(canvas)
            header = bitmap
        }
    }

}
