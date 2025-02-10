package com.example.kopikenangan.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Menu (
    val foto : Int,
    val menu : String
):Parcelable