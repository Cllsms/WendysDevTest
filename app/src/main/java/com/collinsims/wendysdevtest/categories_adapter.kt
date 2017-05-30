package com.collinsims.wendysdevtest

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * This adapter is used to populate the swappable viewpager with the different item_list_fragments
 * in order to display the items in each category.
 */

class categories_adapter(categories: ArrayList<Fragment>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var categoriesList: ArrayList<Fragment> = categories

    /**
     * returns the fragment at that position in the list of fragments.
     */
    override fun getItem(p0: Int): Fragment {
        return categoriesList[p0]
    }

    /**
     * returns the total number of fragments in the list.
     */
    override fun getCount(): Int {
        return categoriesList.size
    }

    /**
     * returns the title to be displayed in the pagertabstrip for each fragment.
     */
    override fun getPageTitle(position: Int): CharSequence {
        return "Category " + (position + 1)
    }
}