package com.sam43.imageloader.repositories

import com.sam43.imageloader.components.DaggerCacheComponent
import com.sam43.imageloader.components.DaggerMediaLoaderComponent
import com.sam43.imageloader.networks.Downloader
import com.sam43.imageloader.networks.Downloader.DownloaderCallback

internal object MediaLoaderRepository {

    private val lock = Any()

    private val component =
        DaggerMediaLoaderComponent.builder().cacheComponent(DaggerCacheComponent.create()).build()

    /**
     * Check if data is cached or not.
     * @return true if and only if data is cached and not expired.
     */
    fun isCached(
        url: String,
        //isMemoryCache: Boolean = true,
        callback: DownloaderCallback
    ): Boolean = synchronized(lock) {
        val value = component.getMemoryCache().get(url)
        if (value != null) {
            callback.onSuccess(value.first, value.second)
            return@synchronized true
        }
        false
    }

    /**
     * @return executed Downloader instance.
     */
    fun getDownloader(
        isSynchronous: Boolean,
        url: String,
        //isMemoryCache: Boolean = true,
        callback: DownloaderCallback
    ): Downloader = synchronized(lock) {
        val downloader = component.getDownloader()
        downloader.init(
            isSynchronous,
            url,
            component.getMemoryCache(),
            //if (isMemoryCache) component.getMemoryCache() else component.getDiskCache(),
            callback,
            component.getHttpOperationWrapper()
        )
        downloader
    }

    /**
     * Force executed call to be cancel.
     */
    fun cancelLoad(downloader: Downloader) {
        synchronized(lock) {
            downloader.cancel()
        }
    }
}