package com.sam43.mindvalleyimageloaderapplication.ui.home

import com.sam43.mindvalleyimageloaderapplication.services.APIService
import com.sam43.mindvalleyimageloaderapplication.services.ApiFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private var service: APIService? = null

    @Before
    fun setUp() {
        service = ApiFactory.service
    }

    @Test
    suspend fun getUnSplashedImagesLiveData() {
        AssertionError(ImageListRepo(service!!).getImages().isNullOrEmpty())
    }

    @Throws(IllegalArgumentException::class)
    @Test(expected = IllegalArgumentException::class)
    suspend fun getUnSplashedImagesErrorLiveData() {
        assertEquals(ImageListRepo(service!!).getImages()?.get(0)?.isSuccess, false)
    }

    @Test
    fun fetchImagesFromServer() {
    }

    @Test
    fun cancelAllRequests() {
    }
}