package com.example.kopikenangan.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Voucher (
    val nama : String,
    val nominal : String,
    val klaim : String
): Parcelable