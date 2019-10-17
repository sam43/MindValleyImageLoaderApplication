package com.sam43.mindvalleyimageloaderapplication.ui.home

import androidx.lifecycle.MutableLiveData
import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import com.sam43.mindvalleyimageloaderapplication.services.ApiFactory
import com.sam43.mindvalleyimageloaderapplication.utils.ViewModelFactory
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModelFactory() {
    private val repository: ImageListRepo = ImageListRepo(ApiFactory.service)
    val unSplashedImagesLiveData = MutableLiveData<MutableList<GenericReS?>>()

    fun fetchImagesFromServer() {
        scope.launch {
            val popularMovies = repository.getImages()
            unSplashedImagesLiveData.postValue(popularMovies)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}