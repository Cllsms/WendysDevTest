package com.collinsims.wendysdevtest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.collinsims.wendysdevtest.R
import com.collinsims.wendysdevtest.test.TestContent
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class item_detail_fragment : Fragment() {

    /**
     * The Test content this fragment is presenting.
     */
    private var mItem: TestContent.TestItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(ARG_ITEM_ID)) {
            // Load the test content specified by the fragment
            // argument, which is the item id.
            mItem = TestContent.ITEM_MAP[arguments.getString(ARG_ITEM_ID)]

            val appBarLayout = toolbar_layout
            if (appBarLayout != null) {
                appBarLayout.title = mItem!!.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.item_detail, container, false)

        // Show the test content as text in a TextView.
        if (mItem != null) {
            rootView.item_detail.text = mItem!!.details
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        val ARG_ITEM_ID = "item_id"
    }
}
