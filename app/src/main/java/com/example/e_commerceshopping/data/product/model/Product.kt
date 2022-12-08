package com.example.e_commerceshopping.data.product.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Product (
    @Transient
    var name : String? = null,
    var image : String? = null,
    var price : Long? = null,
    var model : String? = null,
    var type : String? = null
) : Parcelable