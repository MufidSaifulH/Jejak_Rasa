package com.example.kopikenangan.response

import com.google.gson.annotations.SerializedName

data class VoucherResponse(

	@field:SerializedName("data")
	val data: List<Data>,

	@field:SerializedName("response")
	val response: Int,

	@field:SerializedName("message")
	val message: String
)

data class Data(

	@field:SerializedName("klaim")
	val klaim: String,

	@field:SerializedName("harga")
	val harga: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String
)
