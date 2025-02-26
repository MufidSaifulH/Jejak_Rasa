package com.example.kopikenangan.retrofit

import com.example.kopikenangan.response.DrinkResponse
import com.example.kopikenangan.response.PromoResponse
import com.example.kopikenangan.response.VoucherResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Promo/readPromo.php")
    fun getALlPromo(): Call<PromoResponse>

    @GET("Voucher/readVoucher.php")
    fun getAllVoucher(): Call<VoucherResponse>

    @GET("api/v1/minuman")
    fun getAllMinuman(): Call<DrinkResponse>

}