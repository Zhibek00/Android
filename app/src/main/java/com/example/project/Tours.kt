
package com.example.project

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tours")
data class Tours(
    @PrimaryKey
    var id : Int?=null,
    @ColumnInfo(name = "name")
    var name : String ,
    @ColumnInfo(name = "description")
    var description : String ?= null,
    @ColumnInfo(name = "price_adult")
    var price_adult : Int ?= null,
    @ColumnInfo(name = "price_child")
    var price_child : Int ?= null,
    @ColumnInfo(name = "basket")
    var basket : Int ?= null,
    @ColumnInfo(name = "rating")
    var rating : String ?= null,
    @ColumnInfo(name = "image1")
    var image1 : String ?= null,
    @ColumnInfo(name = "image2")
    var image2 : String ?= null,
    @ColumnInfo(name = "image3")
    var image3 : String ?= null

)