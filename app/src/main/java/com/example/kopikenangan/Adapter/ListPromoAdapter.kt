package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kopikenangan.R
import com.example.kopikenangan.databinding.ItemSpecialBinding
import com.example.kopikenangan.response.DataItem

class ListPromoAdapter : ListAdapter<DataItem, ListPromoAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(private val binding: ItemSpecialBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem: DataItem) {
            binding.promo1.setImageResource(R.drawable.promo1)
            binding.tvDeskripsi.text = dataItem.nama
            binding.tvHargaCoret.text = dataItem.hargaLama
            binding.tvHargaBaru.text = "Rp.${dataItem.hargaBaru}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSpecialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.bind(dataItem)

        Glide.with(holder.itemView.context)
            .load(dataItem.gambar)
            .into(holder.itemView.findViewById(R.id.promo_1))

//        val activity = holder.itemView.context as Activity
//        holder.itemView.setOnClickListener {
//            val intent = Intent(activity, AddUpdateActivity::class.java)
//            intent.putExtra(AddUpdateActivity.EXTRA_DATA, dataItem)
//            activity.startActivity(intent)
//            activity.finish()
//        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>(){
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}