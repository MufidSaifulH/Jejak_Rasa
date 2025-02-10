package com.example.kopikenangan.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Promo (
    val nama : String,
    val harga_coret : String,
    val harga : String,
    val photo : Int
):Parcelable