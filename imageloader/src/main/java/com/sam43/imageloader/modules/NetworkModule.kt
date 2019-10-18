/*
 * Created by Onkar Nene on 14/7/19 1:10 PM
 *
 * Copyright (c) 2019 Onkar Nene. All rights reserved.
 */

package com.sam43.imageloader.modules

import com.sam43.imageloader.networks.Downloader
import com.sam43.imageloader.networks.HttpOperationWrapper
import dagger.Module
import dagger.Provides

/**
 * Dagger implementation for NetworkModule
 */
@Module
internal class NetworkModule {

    /**
     * Responsible to provide Downloader instance.
     */
    @Provides
    fun provideDownloader(): Downloader = Downloader()

    /**
     * Responsible to provide HttpOperationWrapper instance.
     */
    @Provides
    fun provideHttpOperationWrapper(): HttpOperationWrapper = HttpOperationWrapper()
}