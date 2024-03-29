package com.sam43.mindvalleyimageloaderapplication.ui.home

import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import com.sam43.mindvalleyimageloaderapplication.services.APIService
import com.sam43.mindvalleyimageloaderapplication.services.BaseRepository

class ImageListRepo(private val api: APIService) : BaseRepository() {

    suspend fun getImages(): MutableList<GenericReS?>? {
        val response = safeApiCall(
            call = { api.fetchImageListAsync().await() },
            errorMessage = "Error Fetching Popular Movies"
        )
        return response?.toMutableList()
    }
}