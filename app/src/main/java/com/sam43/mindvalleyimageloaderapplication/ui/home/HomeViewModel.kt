package com.sam43.mindvalleyimageloaderapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sam43.mindvalleyimageloaderapplication.model.ResponseImageList
import com.sam43.mindvalleyimageloaderapplication.services.Repository
import com.sam43.mindvalleyimageloaderapplication.utils.ViewModelFactory
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModelFactory() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val fetchImageListLiveData = MutableLiveData<MutableList<ResponseImageList>>()

    fun fetchMovies() {
        scope.launch {
            val items = Repository.fetchAllImageList()
            fetchImageListLiveData.postValue(items) // don't use it
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}