package com.sam43.imageloader.components

import com.sam43.imageloader.data.DiskCache
import com.sam43.imageloader.data.MemoryCache
import com.sam43.imageloader.modules.NetworkModule
import com.sam43.imageloader.networks.Downloader
import com.sam43.imageloader.networks.HttpOperationWrapper
import com.sam43.imageloader.repositories.MediaLoaderRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component responsible for integration with NetworkModule and CacheComponent.
 */
@Singleton
@Component(modules = [NetworkModule::class], dependencies = [CacheComponent::class])
internal interface MediaLoaderComponent {

    /**
     * Provides MemoryCache instance.
     */
    fun getMemoryCache(): MemoryCache

    /**
     * Provides DiskCache instance.
     */
    fun getDiskCache(): DiskCache

    /**
     * Provides Downloader instance.
     */
    fun getDownloader(): Downloader

    /**
     * Provides HttpOperationWrapper instance.
     */
    fun getHttpOperationWrapper(): HttpOperationWrapper

    /**
     * Provides MediaLoaderRepository instance.
     */
    fun injectMediaLoaderRepository(mediaLoaderRepository: MediaLoaderRepository)
}