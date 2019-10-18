package com.sam43.imageloader.data

import okhttp3.MediaType

/**
 * Responsible for maintaining disk cache.
 * Currently not available for release v1.0.0
 */
internal class DiskCache private constructor() : Cache {

    companion object {

        @Volatile
        private var diskCache: DiskCache? = null

        private val lock = Any()

        /**
         * Singleton implementation for DiskCache instance.
         */
        fun getInstance(): DiskCache = diskCache ?: synchronized(lock) {
            if (diskCache == null) {
                diskCache = DiskCache()
            }
            diskCache ?: throw NullPointerException("Object creation failed.")
        }
    }

    override fun get(key: String): Pair<ByteArray, MediaType>? {
        TODO("Not supported in release v1.0.0")
    }

    override fun put(
        key: String,
        value: Pair<ByteArray, MediaType>
    ) {
        TODO("Not supported in release v1.0.0")
    }

    override fun clearCache() {
        TODO("Not supported in release v1.0.0")
    }
}