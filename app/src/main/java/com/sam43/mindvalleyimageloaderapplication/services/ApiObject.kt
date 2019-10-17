package com.sam43.mindvalleyimageloaderapplication.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import com.sam43.mindvalleyimageloaderapplication.session.Session
import com.sam43.mindvalleyimageloaderapplication.utils.debug
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiObject {
    private val data = MutableLiveData<GenericReS>()
    private val apiObject = object : Callback<GenericReS> {
        override fun onFailure(call: Call<GenericReS>, t: Throwable) {
            debug("In, on Failure")
            debug(t.message.toString())
        }

        override fun onResponse(call: Call<GenericReS>, response: Response<GenericReS>) {
            handle(call, response)
        }

    }

    fun getApiObject(): Callback<GenericReS> {
        return apiObject
    }

    fun getData(): LiveData<GenericReS> {
        return data
    }

    private fun handle(call: Call<GenericReS>, response: Response<GenericReS>) {
        when (response.code()) {
            200,
            201 -> {
            }
            else -> {
                try {
                    val errorResponse =
                        Gson().fromJson(response.errorBody()?.string(), GenericReS::class.java)
                    errorResponse.isSuccess = false
                    data.value = errorResponse
                    Session.getContext().toast("Problem with your Internet or something gone wrong")
                } catch (e: Exception) {
                    debug("Error: ${e.message}")
                    Session.getContext().toast("Something went wrong!")
                    data.value = GenericReS(isSuccess = false) // var isSuccess: Boolean? = true
                }
                when (response.code()) {
                    400 -> {
                        // TODO: when phone number is already added
                    }
                    401 -> {
                    }
                }
            }
        }

    }
}
