package com.collinsims.wendysdevtest.test

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards, and edited by Collin Sims.
 */
object TestContent {

    /**
     * a list of category ID's in order to be able to sort test items into lists
     */
    val CAT_ONE: Int = 0
    val CAT_TWO: Int = 1
    val CAT_THREE: Int = 2
    val CAT_FOUR: Int = 3

    /**
     * An array of sample (Test) items for category one.
     */
    val ITEMS_ONE: MutableList<TestItem> = arrayListOf()

    /**
     * An array of sample (Test) items for category two.
     */
    val ITEMS_TWO: MutableList<TestItem> = arrayListOf()

    /**
     * An array of sample (Test) items for category three.
     */
    val ITEMS_THREE: MutableList<TestItem> = arrayListOf()

    /**
     * An array of sample (Test) items for category four.
     */
    val ITEMS_FOUR: MutableList<TestItem> = arrayListOf()

    /**
     * A map of all sample (Test) items, using the item ID as the key.
     */
    val ITEM_MAP: MutableMap<String, TestItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items randomly to the different categories.
        for (i in 1..COUNT) {
            val r = Random()
            addItemToCategory(createTestItem(i), r.nextInt(4))
        }
    }

    /**
     * adding the items to their respective item lists and the overall item hash map
     */
    private fun addItemToCategory(item: TestItem, category: Int) {
        when (category) {
            CAT_ONE -> ITEMS_ONE.add(item)
            CAT_TWO -> ITEMS_TWO.add(item)
            CAT_THREE -> ITEMS_THREE.add(item)
            else -> ITEMS_FOUR.add(item)
        }
        ITEM_MAP.put(item.id, item)
    }

    /**
     * constructor to create a generic test item
     */
    private fun createTestItem(position: Int): TestItem {
        return TestItem(position.toString(), "Item " + position, makeDetails(position))
    }

    /**
     * method to populate the newly created test item with content.
     */
    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        builder.append("\n\nAdditional details and information about the Item here.")
        return builder.toString()
    }

    /**
     * The data object class for the test item.
     */
    class TestItem(val id: String, val content: String, val details: String) {
        override fun toString(): String {
            return content
        }
    }
}
