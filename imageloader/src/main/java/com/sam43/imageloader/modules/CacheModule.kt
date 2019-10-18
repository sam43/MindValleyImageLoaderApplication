package com.sam43.imageloader.modules

import com.sam43.imageloader.data.MemoryCache
import dagger.Module
import dagger.Provides

/**
 * Dagger implementation for CacheModule
 */
@Module
internal class CacheModule {
    /**
     * Responsible to provide MemoryCache instance.
     */
    @Provides
    fun provideMemoryCache(): MemoryCache = MemoryCache.getInstance()

}