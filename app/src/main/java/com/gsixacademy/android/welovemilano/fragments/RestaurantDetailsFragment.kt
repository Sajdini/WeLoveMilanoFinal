package com.gsixacademy.android.welovemilano.fragments


import android.graphics.Picture
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gsixacademy.android.welovemilano.MainActivity
import com.gsixacademy.android.welovemilano.R
import com.gsixacademy.android.welovemilano.adapter.FirstViewPagerAdapter
import com.gsixacademy.android.welovemilano.api.ApiServiceBuilder
import com.gsixacademy.android.welovemilano.api.MilanoDatabaseApi
import com.gsixacademy.android.welovemilano.firebaseModel.Pave
import com.gsixacademy.android.welovemilano.firebaseModel.PictureListModel
import com.gsixacademy.android.welovemilano.firebaseModel.Pictures
import com.gsixacademy.android.welovemilano.models.MilanoListResponse
import com.gsixacademy.android.welovemilano.models.Restaurant
import com.gsixacademy.android.welovemilano.models.RestaurantData
import kotlinx.android.synthetic.main.details_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantDetailsFragment:Fragment (){
      lateinit var rest: Restaurant
      lateinit var pictureListModel: PictureListModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_activity, container,false)

        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rest= arguments?.get("rest")as Restaurant
      text_view_res_name.text= rest.restaurant?.name
        text_view_type.text= rest.restaurant?.establishment.toString()
        text_view_cuisine_value.text= rest.restaurant?.cuisines
     text_view_cost_value.text= rest.restaurant?.average_cost_for_two.toString()
      text_view_adress.text= rest.restaurant?.location?.address
        text_view_phone_value.text= rest.restaurant?.phone_numbers
        text_view_timing_value.text=rest.restaurant?.timings
        viewPagerInit()

        }
    private fun viewPagerInit(){
       var pictureListModel=(activity as MainActivity).pictureListModel

        when(rest.restaurant?.id){
            16543135->view_pager_images.adapter=pictureListModel?.pictureListModel?.pave?.photos?.let { FirstViewPagerAdapter(it) }
        }

    }
    }


