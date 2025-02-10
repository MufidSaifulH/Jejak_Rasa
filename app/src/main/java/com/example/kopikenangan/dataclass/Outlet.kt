package com.example.kopikenangan.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Outlet (
    val logo1 : Int,
    val logo2 : Int,
    val logo3 : Int,
    val nama : String,
    val alamat : String,
    val ket : String
):Parcelable
