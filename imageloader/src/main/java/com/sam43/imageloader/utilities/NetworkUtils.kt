package com.sam43.imageloader.utilities

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit.SECONDS

internal object NetworkUtils {

    private const val CODE_UNKNOWN: Int = 0
    private const val HTTP_REQUEST_FAIL = "Request Fail"
    private val BAD_REQUEST =
        "Bad Request" to Throwable("The requested data is invalid, Please try again later.")
    private val UNAUTHORIZED =
        "User Unauthorized" to Throwable("This user is not authorized to access the data.")
    private val PAGE_NOT_FOUND =
        "Page Not Found" to Throwable("The server page you are looking for is not available.")
    private val TIMEOUT =
        "Request Timeout" to Throwable("Due to the server or network unavailability request cannot proceed.")
    private val MAINTENANCE_BREAK =
        "Maintenance Break" to Throwable("Sorry, the server is under maintenance. Please try again after some time.")

    /**
     * Single OkHttpClient instance created by lazy initialization.
     */
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient().newBuilder().connectTimeout(20, SECONDS).readTimeout(20, SECONDS).build()
    }

    /**
     * Builds and returns new http call for execution.
     */
    fun getCaller(url: String): Call {
        require(!(url.isEmpty() || url.isBlank())) { "Url should not be empty or blank." }
        val request = Request.Builder().url(url).get().build()
        return okHttpClient.newCall(request)
    }

    /**
     * Provide human readable error messages.
     */
    fun getRequestFailReason(
        code: Int = CODE_UNKNOWN,
        throwable: Throwable? = null
    ) = when (code) {
        CODE_UNKNOWN -> HTTP_REQUEST_FAIL to (throwable ?: Throwable("Something went wrong!"))
        HttpURLConnection.HTTP_BAD_REQUEST, HttpURLConnection.HTTP_BAD_METHOD, HttpURLConnection.HTTP_UNSUPPORTED_TYPE -> BAD_REQUEST
        HttpURLConnection.HTTP_UNAUTHORIZED -> UNAUTHORIZED
        HttpURLConnection.HTTP_NOT_FOUND, HttpURLConnection.HTTP_NOT_ACCEPTABLE -> PAGE_NOT_FOUND
        HttpURLConnection.HTTP_CLIENT_TIMEOUT, HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> TIMEOUT
        HttpURLConnection.HTTP_INTERNAL_ERROR, HttpURLConnection.HTTP_BAD_GATEWAY, HttpURLConnection.HTTP_UNAVAILABLE -> MAINTENANCE_BREAK
        else -> "" to null
    }
}