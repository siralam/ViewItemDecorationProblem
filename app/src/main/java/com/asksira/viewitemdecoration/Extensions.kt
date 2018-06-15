package com.asksira.viewitemdecoration

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun Int.dp(): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
}

fun Context.inflate(layoutRes: Int, container: ViewGroup?, attachToRoot: Boolean = true): View {
    return LayoutInflater.from(this).inflate(layoutRes, container, attachToRoot)
}
