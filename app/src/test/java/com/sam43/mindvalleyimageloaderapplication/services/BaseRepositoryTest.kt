package com.sam43.mindvalleyimageloaderapplication.services

import org.junit.Before
import org.junit.Test

class BaseRepositoryTest {

    private var service: APIService? = null

    @Before
    fun setUp() {
        service = ApiFactory.service
    }

    @Test
    fun safeApiCall() {
    }
}