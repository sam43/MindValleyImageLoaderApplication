package com.sam43.imageloader

import com.sam43.imageloader.data.MemoryCache
import org.junit.Assert
import org.junit.Test

class MemoryCacheTest {

    @Throws(IllegalArgumentException::class)
    @Test(expected = IllegalArgumentException::class)
    fun memoryCache_ValidMaxCapacity_ThrowsException() {
        MemoryCache.setCapacity(0)
    }

    @Throws(IllegalArgumentException::class)
    @Test(expected = IllegalArgumentException::class)
    fun memoryCache_ValidTimeout_ThrowsException() {
        MemoryCache.setTimeout(1234)
    }

    @Test
    fun memoryCache_EmptyKey_ReturnsNull() {
        Assert.assertNull("Object should be null.", MemoryCache.getInstance().get(""))
    }

    @Test
    fun memoryCache_TestKey_ReturnsNull() {
        Assert.assertNull("Object should be null.", MemoryCache.getInstance().get("Test"))
    }
}