package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.R
import com.example.kopikenangan.dataclass.Outlet

class OutletAdapter (private val listOutlet: ArrayList<Outlet>): RecyclerView.Adapter<OutletAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLogo1: ImageView = itemView.findViewById(R.id.lg_kopi)
        val imgLogo2: ImageView = itemView.findViewById(R.id.lg_roti)
        val imgLogo3: ImageView = itemView.findViewById(R.id.lg_manis)
        val tvName: TextView = itemView.findViewById(R.id.nm_mall)
        val tvAlamat: TextView = itemView.findViewById(R.id.al_mall)
        val tvKet :TextView = itemView.findViewById(R.id.tv_jam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listOutlet.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.imgLogo1.setImageResource(listOutlet[position].logo1)
        holder.imgLogo2.setImageResource(listOutlet[position].logo2)
        holder.imgLogo3.setImageResource(listOutlet[position].logo3)
        holder.tvName.text = listOutlet[position].nama
        holder.tvAlamat.text = listOutlet[position].alamat
        holder.tvKet.text = listOutlet[position].ket

    }
}