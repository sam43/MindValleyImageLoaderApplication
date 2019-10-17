package com.sam43.mindvalleyimageloaderapplication.utils

import android.app.Activity
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Activity.getClassName() {
    Log.i("className", "${this.localClassName} // ${this.javaClass.simpleName}")
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun Any.debug(message: String) {
    Log.d("***" + this::class.java.simpleName, message)
}

fun Any.info(message: String, tr: Throwable) {
    Log.i(this::class.java.simpleName, message, tr)
}

inline fun <T> T.guard(block: T.() -> Unit): T {
    if (this == null) block(); return this
}

fun showNetworkMessage(isConnected: Boolean, view: View) {
    val message = "You are disconnected, please check your internet connection."
    if (!isConnected) {
        val snack = Snackbar
            .make(view, message, Snackbar.LENGTH_LONG)
        snack.show()
    }
}

fun View.showSnack(message: String) {
    val snack = Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
    snack.show()
}