package com.collinsims.wendysdevtest.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.collinsims.wendysdevtest.item_detail_activity
import com.collinsims.wendysdevtest.R
import com.collinsims.wendysdevtest.test.TestContent
import kotlinx.android.synthetic.main.item_list_content.view.*

/**
 * Adapter class for the recycler view list for each of the four categories in the
 * swipe enabled view pager on the main screen of the app.
 */

class item_list_fragment_adapter(private val mValues: List<TestContent.TestItem>, private val ctx: Context, private val mTwoPane:Boolean,
                                 private val supportFragmentManager:FragmentManager?) : RecyclerView.Adapter<item_list_fragment_adapter.ViewHolder>() {

    /**
     * creates a new viewHolder object for the item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(ctx)
                .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    /**
     * populates the newly created viewHolder with the information for the item
     * in the list at that position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.itemName.text = mValues[position].content

        holder.cardView.setOnClickListener { v ->
            if (mTwoPane && supportFragmentManager != null) {
                val arguments = Bundle()
                arguments.putString(item_detail_fragment.ARG_ITEM_ID, holder.mItem!!.id)
                val fragment = item_detail_fragment()
                fragment.arguments = arguments
                supportFragmentManager.beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit()
            } else {
                val context = v.context
                val intent = Intent(context, item_detail_activity::class.java)
                intent.putExtra(item_detail_fragment.ARG_ITEM_ID, holder.mItem!!.id)

                context.startActivity(intent)
            }
        }
    }

    /**
     * returns the number of items in the category
     */
    override fun getItemCount(): Int {
        return mValues.size
    }

    /**
     * inner class for the view holder that contains all the UI elements for
     * the layout of each item in the list.
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.cardView
        val itemImage: ImageView = itemView.imageView
        val itemName: TextView = itemView.content
        var mItem: TestContent.TestItem? = null

        override fun toString(): String {
            return super.toString() + "'" + itemName.text + "'"
        }
    }
}