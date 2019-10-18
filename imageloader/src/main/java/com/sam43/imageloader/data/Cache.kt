package com.sam43.imageloader.data

import okhttp3.MediaType

/**
 * Base implementation for MemoryCache module.
 */
internal interface Cache {

    /**
     * Returns Pair<ByteArray, MediaType> if available in map, otherwise null.
     */
    fun get(key: String): Pair<ByteArray, MediaType>?

    /**
     * Add inputted key-value into map. If already available and expired then remove it from map.
     */
    fun put(
        key: String,
        value: Pair<ByteArray, MediaType>
    )

    /**
     * Provides interface to clear current cache.
     */
    fun clearCache()
}