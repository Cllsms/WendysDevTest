package com.collinsims.wendysdevtest

import android.support.test.InstrumentationRegistry
import com.collinsims.wendysdevtest.test.TestContent

import org.junit.Test

import org.junit.Assert.*

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */

class ExampleInstrumentedTest {

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.collinsims.wendysdevtest", appContext.packageName)
    }

    /**
     * a series of tests to make sure that all the category data was initialized correctly.
     *
     */
    @Test
    fun categoryOneNotNull() {
        TestContent
        assertNotNull(TestContent.ITEMS_ONE)
    }

    @Test
    fun categoryTwoNotNull() {
        assertNotNull(TestContent.ITEMS_TWO)
    }

    @Test
    fun categoryThreeNotNull() {
        assertNotNull(TestContent.ITEMS_THREE)
    }

    @Test
    fun categoryFourNotNull() {
        assertNotNull(TestContent.ITEMS_FOUR)
    }

    @Test
    fun itemsMapNotNull() {
        assertNotNull(TestContent.ITEM_MAP)
    }
}
