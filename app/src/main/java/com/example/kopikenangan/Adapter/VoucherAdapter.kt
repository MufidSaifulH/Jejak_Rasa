package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.Adapter.ListPromoAdapter.Companion.DIFF_CALLBACK
import com.example.kopikenangan.databinding.ItemVoucherBinding
import com.example.kopikenangan.response.Data
import com.example.kopikenangan.response.DataItem

class VoucherAdapter : ListAdapter<Data, VoucherAdapter.ViewHolder>(DIFF_CALLBACK){
    class ViewHolder (private val binding: ItemVoucherBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data){
            binding.tvNominal.text = data.harga
            binding.tvDeskrip.text = data.klaim
            binding.tvKlaim.text = data.deskripsi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}