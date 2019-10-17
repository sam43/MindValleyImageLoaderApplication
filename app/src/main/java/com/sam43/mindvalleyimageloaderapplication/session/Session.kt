package com.sam43.mindvalleyimageloaderapplication.session

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

@SuppressLint("StaticFieldLeak")
object Session {
    private lateinit var pref: SharedPreferences
    private lateinit var editor: Editor
    private lateinit var cxt: Context

    fun init(context: Context) {
        cxt = context
        pref = context.getSharedPreferences(SessionConstants.PREF_NAME, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    fun getContext(): Context {
        return cxt
    }
}