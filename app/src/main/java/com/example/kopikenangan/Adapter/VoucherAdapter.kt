package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.R
import com.example.kopikenangan.dataclass.Promo
import com.example.kopikenangan.dataclass.Voucher

class VoucherAdapter (private val listVoucher : ArrayList<Voucher>) : RecyclerView.Adapter<VoucherAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvKlaim: TextView = itemView.findViewById(R.id.tv_klaim)
        val tvNominal: TextView = itemView.findViewById(R.id.tv_nominal)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskrip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_voucher, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listVoucher.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvKlaim.text = listVoucher[position].nama
        holder.tvNominal.text = listVoucher[position].nominal
        holder.tvDeskripsi.text = listVoucher[position].klaim

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Voucher Telah" + listVoucher[holder.adapterPosition].nama, Toast.LENGTH_SHORT)
                .show()
        }
    }
}
