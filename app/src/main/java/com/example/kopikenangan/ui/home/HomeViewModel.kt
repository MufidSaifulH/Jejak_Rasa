package com.example.kopikenangan.ui.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kopikenangan.response.Data
import com.example.kopikenangan.response.DataItem
import com.example.kopikenangan.response.DataItemFood
import com.example.kopikenangan.response.DrinkResponse
import com.example.kopikenangan.response.FoodResponse
import com.example.kopikenangan.response.Item
import com.example.kopikenangan.response.PromoResponse
import com.example.kopikenangan.response.VoucherResponse
import com.example.kopikenangan.retrofit.ApiConfig
import com.example.kopikenangan.retrofit.ApiConfig2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _listPromo = MutableLiveData<List<DataItem>>()
    val listPromo: LiveData<List<DataItem>> = _listPromo

    private val _listVoucher = MutableLiveData<List<Data>>()
    val listVoucher : LiveData<List<Data>> = _listVoucher

    private val _listDrink = MutableLiveData<List<Item>>()
    val listDrink : LiveData<List<Item>> = _listDrink

    private val _listFood = MutableLiveData<List<DataItemFood>>()
    val listFood : LiveData<List<DataItemFood>> = _listFood

    init {
        getPromo()
        getVoucher()
        getDrink()
        getFood()
    }

    private fun getFood() {
        val client = ApiConfig2.getApi().getAllMakanan()
        client.enqueue(object : Callback<FoodResponse>{
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                if (response.isSuccessful){
                    _listFood.value = response.body()?.data
                }else{
                    Log.e(TAG,"On Failure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                Log.e(TAG,"OnFailure ${t.message}")
            }

        })
    }

    private fun getDrink() {
        val client = ApiConfig2.getApi().getAllMinuman()
        client.enqueue(object : Callback<DrinkResponse>{
            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>) {
                if (response.isSuccessful){
                    _listDrink.value = response.body()?.data
                }else{
                    Log.e(TAG,"On Failure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DrinkResponse>, t: Throwable) {
                Log.e(TAG,"OnFailure ${t.message}")
            }

        })
    }

    private fun getVoucher() {
        val client = ApiConfig.getApiService().getAllVoucher()
        client.enqueue(object : Callback<VoucherResponse>{
            override fun onResponse(
                call: Call<VoucherResponse>,
                response: Response<VoucherResponse>
            ) {
                if (response.isSuccessful){
                    _listVoucher.value = response.body()?.data
                }else{
                    Log.e(TAG,"On Failure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<VoucherResponse>, t: Throwable) {
                Log.e(TAG,"OnFailure ${t.message}")
            }

        })
    }

    private fun getPromo() {
        val client = ApiConfig.getApiService().getALlPromo()
        client.enqueue(object : Callback<PromoResponse>{
            override fun onResponse(call: Call<PromoResponse>, response: Response<PromoResponse>) {
                if (response.isSuccessful){
                    _listPromo.value = response.body()?.data
                }else{
                    Log.e(TAG,"On Failure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<PromoResponse>, t: Throwable) {
                Log.e(TAG,"OnFailure ${t.message}")
            }
        })
    }

}