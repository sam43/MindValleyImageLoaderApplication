package com.sam43.imageloader

import com.sam43.imageloader.utilities.NetworkUtils
import org.junit.Assert
import org.junit.Test
import java.net.HttpURLConnection

class NetworkUtilsTest {

    @Throws(IllegalArgumentException::class)
    @Test(expected = IllegalArgumentException::class)
    fun networkUtils_EmptyUrl_ThrowsException() {
        NetworkUtils.getCaller("")
    }

    @Throws(IllegalArgumentException::class)
    @Test(expected = IllegalArgumentException::class)
    fun networkUtils_BlankUrl_ThrowsException() {
        NetworkUtils.getCaller("   ")
    }

    @Test
    fun networkUtils_DefaultParameters_ReturnEquals() {
        val reason = NetworkUtils.getRequestFailReason()
        Assert.assertEquals(reason.first, "Request Fail")
        Assert.assertEquals(reason.second?.message, "Something went wrong!")
    }

    @Test
    fun networkUtils_TestParameters_ReturnEquals() {
        val reason = NetworkUtils.getRequestFailReason(HttpURLConnection.HTTP_BAD_REQUEST)
        Assert.assertEquals(reason.first, "Bad Request")
        Assert.assertEquals(
            reason.second?.message,
            "The requested data is invalid, Please try again later."
        )
    }

    @Test
    fun networkUtils_UnknownParameters_ReturnEquals() {
        Assert.assertEquals(NetworkUtils.getRequestFailReason(-2), "" to null)
    }
}