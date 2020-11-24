package com.gsixacademy.android.welovemilano.firebaseModel

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class Pictures():Parcelable {
    val pave : Pave?=null
    val gino : ArrayList<Gino>?=null
    val am : ArrayList<Am>?=null
    val founderieM : ArrayList<FounderieM>?=null
    val otto : ArrayList<Otto>?=null
    val luini : ArrayList<Luini>?=null
    val temakinho : ArrayList<Temakinho>?=null
    val lagodana : ArrayList<Lagodana>?=null
    val briscola : ArrayList<Briscola>?=null
    val ostello : ArrayList<Ostello>?=null
    val ofele : ArrayList<Ofele>?=null
    val deus : ArrayList<Deus>?=null
    val mag: ArrayList<Mag>?=null
    val cioccolati: ArrayList<Cioccolati>?=null
    val carlo : ArrayList<Carlo>?=null
    val corso:ArrayList<Corso>?=null
    val milano: ArrayList<Milano>?=null
    val alfresco:ArrayList<Alfresco>?=null
    val cimmino: ArrayList<Cimmino>?=null
    val unposto:ArrayList<Unposto>?=null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pictures> {
        override fun createFromParcel(parcel: Parcel): Pictures {
            return Pictures(parcel)
        }

        override fun newArray(size: Int): Array<Pictures?> {
            return arrayOfNulls(size)
        }
    }

}
