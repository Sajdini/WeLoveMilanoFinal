package com.gsixacademy.android.welovemilano



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.database.*
import com.gsixacademy.android.welovemilano.firebaseModel.PictureListModel
import com.gsixacademy.android.welovemilano.models.MilanoListResponse
import com.gsixacademy.android.welovemilano.models.Restaurant
import com.gsixacademy.android.welovemilano.models.RestaurantData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var navListener: NavController.OnDestinationChangedListener
    var pictureListModel:PictureListModel?=null
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= FirebaseDatabase.getInstance().reference
        navController = Navigation.findNavController(this, R.id.navigation_host_fragment)
        initListeners()
        initialiseFireBaseDatabase()
    }

    fun initialiseFireBaseDatabase(){
        val postListener=object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                //no implementation yet
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                pictureListModel=snapshot.getValue(PictureListModel::class.java)
            }

        }
        database.addValueEventListener(postListener)
    }

    fun initListeners(){
    navListener=NavController.OnDestinationChangedListener{controller, destination, arguments ->
        when(destination.id){
            R.id.placesFragment->{navigation_bottom_view.visibility= View.VISIBLE
            navigation_bottom_view.setSelectedTab(1)
            }
            R.id.mapFragment->{navigation_bottom_view.visibility= View.VISIBLE
            navigation_bottom_view.setSelectedTab(2)}
            R.id.restaurantFragment->{navigation_bottom_view.visibility= View.VISIBLE
            navigation_bottom_view.setSelectedTab(3)}
            R.id.infoFragment->{ navigation_bottom_view.visibility= View.VISIBLE
            navigation_bottom_view.setSelectedTab(4)}
            R.id.splashFragment->{navigation_bottom_view.visibility=View.GONE}
        }
    }
    navController.addOnDestinationChangedListener(navListener)
    text_view_places.setOnClickListener { navController.navigate(R.id.action_global_placesFragment) }
    text_view_map.setOnClickListener { navController.navigate(R.id.action_global_mapFragment) }
    text_view_list.setOnClickListener {  navController.navigate(R.id.action_global_restaurantFragment)}
    text_view_info.setOnClickListener { navController.navigate(R.id.action_global_infoFragment) }
}

}