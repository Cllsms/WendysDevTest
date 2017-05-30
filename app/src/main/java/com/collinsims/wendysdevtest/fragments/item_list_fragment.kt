package com.collinsims.wendysdevtest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.collinsims.wendysdevtest.R
import com.collinsims.wendysdevtest.test.TestContent
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * This is the fragment that is used to display all the items for a given category.
 */

class item_list_fragment(private val categoryID: Int, private val isTwoPane: Boolean, private val sFM: FragmentManager?) : Fragment() {

    /**
     * a default constructor for the fragment.
     */
    constructor() : this(0, false, null)

    /**
     * creates the fragment for the view to put into
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * inflates the layout for the fragment, calls the setupRecyclerView method to
     * populate the list for the screen, and returns the inflated layout
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.item_list, container, false)
        setupRecyclerView(rootView.item_list)
        return rootView
    }

    /**
     * method that is used to setup the recycler view list of items for the
     * category ID that is passed in when the fragment is created
     */
    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        when (categoryID) {
            TestContent.CAT_ONE -> recyclerView.adapter = item_list_fragment_adapter(TestContent.ITEMS_ONE, activity, isTwoPane, sFM)
            TestContent.CAT_TWO -> recyclerView.adapter = item_list_fragment_adapter(TestContent.ITEMS_TWO, activity, isTwoPane, sFM)
            TestContent.CAT_THREE -> recyclerView.adapter = item_list_fragment_adapter(TestContent.ITEMS_THREE, activity, isTwoPane, sFM)
            else -> recyclerView.adapter = item_list_fragment_adapter(TestContent.ITEMS_FOUR, activity, isTwoPane, sFM)
        }
    }
}