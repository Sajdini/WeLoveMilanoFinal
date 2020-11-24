package com.gsixacademy.android.welovemilano.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.gsixacademy.android.welovemilano.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_view_pager.view.*

class FirstViewPagerAdapter(private val photoslist:ArrayList<String>):PagerAdapter() {
    override fun getCount(): Int {
return photoslist.size    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
return view==`object`
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater= LayoutInflater.from(container.context)
        val view=inflater.inflate(R.layout.image_view_pager,container,false)as ViewGroup
        Picasso.get().load(photoslist.get(position)).fit().centerInside().into(view.image_view_details_main)
        container.addView(view)
        return view
    }
}