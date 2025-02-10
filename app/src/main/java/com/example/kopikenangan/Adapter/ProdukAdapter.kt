package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.R
import com.example.kopikenangan.dataclass.Produk

class ProdukAdapter (private val listProduk : ArrayList<Produk>) : RecyclerView.Adapter<ProdukAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.produk_1)
        val tvDescription: TextView = itemView.findViewById(R.id.nama_produk)
        val tvHarga: TextView = itemView.findViewById(R.id.harga_produk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listProduk.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.imgPhoto.setImageResource(listProduk[position].photo)
        holder.tvDescription.text = listProduk[position].nama
        holder.tvHarga.text = listProduk[position].harga

    }
}