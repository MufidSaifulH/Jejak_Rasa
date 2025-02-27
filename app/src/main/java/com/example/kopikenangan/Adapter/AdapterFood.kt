package com.example.kopikenangan.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kopikenangan.Adapter.ListPromoAdapter.Companion.DIFF_CALLBACK
import com.example.kopikenangan.DetailFoodAndDrink
import com.example.kopikenangan.R
import com.example.kopikenangan.databinding.ItemProdukBinding
import com.example.kopikenangan.dataclass.Food
import com.example.kopikenangan.response.DataItemFood
import com.example.kopikenangan.response.Item

class AdapterFood : ListAdapter<DataItemFood, AdapterFood.ListViewHolder>(DIFF_CALLBACK) {
    class ListViewHolder (private val binding : ItemProdukBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(data: DataItemFood){
            Glide.with(itemView.context)
                .load(data.gambar)
                .into(binding.produk1)
            binding.namaProduk.text = data.nama
            binding.hargaProduk.text = "Rp.${data.harga}"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListViewHolder {
        val binding = ItemProdukBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
//        holder.imgPhoto.setImageResource(listFood[position].photo)
//        holder.tvDescription.text = listFood[position].nama
//        holder.tvHarga.text = listFood[position].harga
//
//        holder.itemView.setOnClickListener {
//            val intentDetail = Intent(holder.itemView.context, DetailFoodAndDrink::class.java)
//            intentDetail.putExtra("EXTRA_PHOTO", listFood[holder.bindingAdapterPosition].photo)
//            intentDetail.putExtra("EXTRA_NAME", listFood[holder.bindingAdapterPosition].nama)
//            intentDetail.putExtra("EXTRA_HARGA_B", listFood[holder.bindingAdapterPosition].harga)
//
//            holder.itemView.context.startActivity(intentDetail)
//        }
    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemFood>() {
            override fun areItemsTheSame(oldItem: DataItemFood, newItem: DataItemFood): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataItemFood, newItem: DataItemFood): Boolean {
                return oldItem == newItem
            }
        }
    }
}

