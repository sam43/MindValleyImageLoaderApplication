package com.sam43.imageloader.components

import com.sam43.imageloader.data.DiskCache
import com.sam43.imageloader.data.MemoryCache
import com.sam43.imageloader.modules.CacheModule
import dagger.Component

/**
 * Dagger component responsible for integration with CacheModule and provide required objects.
 */
@Component(modules = [CacheModule::class])
internal interface CacheComponent {

    /**
     * Provides MemoryCache instance.
     */
    fun getMemoryCache(): MemoryCache

    /**
     * Provides DiskCache instance.
     */
    fun getDiskCache(): DiskCache
}