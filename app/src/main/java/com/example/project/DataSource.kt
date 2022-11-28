package com.example.project

import android.os.Parcel
import android.os.Parcelable
class DataSource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.drawable.p1,"h"),
            Affirmation(R.drawable.p2,"d"),
            Affirmation(R.drawable.p3,"d"),
            Affirmation(R.drawable.p4,"f"),
            Affirmation(R.drawable.p5,"f"),

        )
    }


}

class Affirmation(val a:Int, val b: String?) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(a)
        parcel.writeString(b)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Affirmation> {
        override fun createFromParcel(parcel: Parcel): Affirmation {
            return Affirmation(parcel)
        }

        override fun newArray(size: Int): Array<Affirmation?> {
            return arrayOfNulls(size)
        }
    }


}



