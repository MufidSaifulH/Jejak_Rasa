package com.example.kopikenangan.response

import com.google.gson.annotations.SerializedName

data class DrinkResponse(

	@field:SerializedName("data")
	val data: List<Item>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class Item(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("harga")
	val harga: Int,

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("gambar")
	val gambar: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
