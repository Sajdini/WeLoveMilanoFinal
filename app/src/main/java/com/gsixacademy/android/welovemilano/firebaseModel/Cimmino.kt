package com.gsixacademy.android.welovemilano.firebaseModel

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class Cimmino():Parcelable {
    val photos: ArrayList<String>?=null
    val menu:ArrayList<String>?=null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cimmino> {
        override fun createFromParcel(parcel: Parcel): Cimmino {
            return Cimmino(parcel)
        }

        override fun newArray(size: Int): Array<Cimmino?> {
            return arrayOfNulls(size)
        }
    }
}
