package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.Adapter.ListPromoAdapter.Companion.DIFF_CALLBACK
import com.example.kopikenangan.R
import com.example.kopikenangan.databinding.ItemOrderBinding
import com.example.kopikenangan.response.DataItem
import com.example.kopikenangan.response.DataOutlet

class OutletAdapter : ListAdapter<DataOutlet, OutletAdapter.ViewHolder>(DIFF_CALLBACK){
    class ViewHolder (private val binding: ItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataOutlet: DataOutlet) {
            binding.lgKopi.setImageResource(R.drawable.brand2)
            binding.lgRoti.setImageResource(R.drawable.brand3)
            binding.lgManis.setImageResource(R.drawable.brand5)
            binding.nmMall.text = dataOutlet.namaMall
            binding.alMall.text = dataOutlet.alamatMall
            binding.biru.setImageResource(R.drawable.circle1)
            binding.tvBiru.text = "Pickup"
            binding.ijo.setImageResource(R.drawable.circle2)
            binding.tvIjo.text = "Dine In"
            binding.ungu.setImageResource(R.drawable.circle3)
            binding.tvUngu.text = "Delivery"
            binding.tvJam.text = dataOutlet.jam
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataOutlet = getItem(position)
        holder.bind(dataOutlet)
//        holder.imgLogo1.setImageResource(listOutlet[position].logo1)
//        holder.imgLogo2.setImageResource(listOutlet[position].logo2)
//        holder.imgLogo3.setImageResource(listOutlet[position].logo3)
//        holder.tvName.text = listOutlet[position].nama
//        holder.tvAlamat.text = listOutlet[position].alamat
//        holder.tvKet.text = listOutlet[position].ket
    }
    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataOutlet>(){
            override fun areItemsTheSame(oldItem: DataOutlet, newItem: DataOutlet): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataOutlet, newItem: DataOutlet): Boolean {
                return oldItem == newItem
            }
        }
    }
}