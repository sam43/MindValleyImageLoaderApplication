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