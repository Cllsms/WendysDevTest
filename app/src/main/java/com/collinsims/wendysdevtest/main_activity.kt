package com.collinsims.wendysdevtest

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.collinsims.wendysdevtest.fragments.item_list_fragment
import com.collinsims.wendysdevtest.test.TestContent
import kotlinx.android.synthetic.main.activity_item_list.*

/**
 * An activity that contains a swappable ViewPager, which is populated
 * with four separate categories with individual items for each.
 */
class main_activity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        /**
         * floating action button that is currently configured to show the creator and app version,
         * could used for other functionality.
         */
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Created By Collin Sims, Version 1.0.0", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        if (findViewById(R.id.item_detail_container) != null) {
            /**
             * The detail container view will be present only in the
             * large-screen layouts (res/values-w900dp).
             * If this view is present, then the
             * activity should be in two-pane mode.
             */
            mTwoPane = true
        }

        /**
         * Create four individual item list fragments for each of the 4 categories and add them to an
         * arraylist. This arraylist will then be passed into the categories adapter to be used to
         * populate the swappable viewpager.
         */
        val category_one = item_list_fragment(TestContent.CAT_ONE, mTwoPane, supportFragmentManager)
        val category_two = item_list_fragment(TestContent.CAT_TWO, mTwoPane, supportFragmentManager)
        val category_three = item_list_fragment(TestContent.CAT_THREE, mTwoPane, supportFragmentManager)
        val category_four = item_list_fragment(TestContent.CAT_FOUR, mTwoPane, supportFragmentManager)

        val categoriesList: ArrayList<Fragment> = ArrayList()
        categoriesList.add(category_one)
        categoriesList.add(category_two)
        categoriesList.add(category_three)
        categoriesList.add(category_four)

        viewPager.adapter = categories_adapter(categoriesList, supportFragmentManager)
    }
}
