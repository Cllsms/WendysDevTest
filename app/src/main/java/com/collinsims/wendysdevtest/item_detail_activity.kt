package com.collinsims.wendysdevtest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.collinsims.wendysdevtest.fragments.item_detail_fragment
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [main_activity].
 */
class item_detail_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        /**
         * a floating action button that been setup to imitate sharing functionality within the app.
         */
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Send to a friend?", Snackbar.LENGTH_LONG)
                    .setAction("Share", View.OnClickListener {
                        Toast.makeText(view.context, "Shared This With Friends!", Toast.LENGTH_LONG).show()
                    }).show()
        }

        // Show the Up button in the action bar.
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
            arguments.putString(item_detail_fragment.ARG_ITEM_ID,
                    intent.getStringExtra(item_detail_fragment.ARG_ITEM_ID))
            val fragment = item_detail_fragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            /**
             * This option represents the up or back button that is shown in the
             * top left corner in the screen in the toolbar and is used for navigating
             * back to the previous screen.
             */
            //NavUtils.navigateUpTo(this, Intent(this, main_activity::class.java))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
