package com.sam43.mindvalleyimageloaderapplication.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.sam43.imageloader.MediaLoader

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

fun loadImage(url: String, itemView: View, imageView: ImageView) {
    MediaLoader.Builder<ImageView>(itemView.context)
        .load(url)
        .into(imageView)
        .create().download()
}

fun Context.getImageLoader(url: String, imageView: ImageView): MediaLoader<ImageView> {
    return MediaLoader.Builder<ImageView>(this).load(url).into(imageView).create()
}