package com.sam43.imageloader

import android.content.Context
import android.net.ConnectivityManager

/**
 * Check for network connection availability.
 *
 * @return true if device is currently connected to the internet (WiFi or Mobile Data), otherwise false.
 */
fun Context.isNetworkAvailable(): Boolean {
    val networkInfo =
        (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?)?.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}