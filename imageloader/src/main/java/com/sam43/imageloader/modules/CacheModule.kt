/*
 * Created by Onkar Nene on 14/7/19 12:49 PM
 *
 * Copyright (c) 2019 Onkar Nene. All rights reserved.
 */

package com.sam43.imageloader.modules

import com.sam43.imageloader.data.DiskCache
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

    /**
     * Responsible to provide DiskCache instance.
     */
    @Provides
    fun provideDiskCache(): DiskCache = DiskCache.getInstance()
}