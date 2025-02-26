package com.example.kopikenangan.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PromoResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("response")
	val response: Int,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("nama")
	val nama: String?,

	@field:SerializedName("harga_baru")
	val hargaBaru: String?,

	@field:SerializedName("harga_lama")
	val hargaLama: String?,

	@field:SerializedName("id")
	val id: String?,

	@field:SerializedName("gambar")
	val gambar: String?
)
