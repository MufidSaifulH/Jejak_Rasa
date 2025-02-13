package com.example.kopikenangan.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.DetailActivity
import com.example.kopikenangan.OrderFragment
import com.example.kopikenangan.R
import com.example.kopikenangan.dataclass.Promo

class ListPromoAdapter (private val listPromo : ArrayList<Promo>) :
    RecyclerView.Adapter<ListPromoAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.promo_1)
        val tvDescription : TextView = itemView.findViewById(R.id.tv_deskripsi)
        val tvHargaLama : TextView = itemView.findViewById(R.id.tv_harga_coret)
        val tvHargaBaru : TextView = itemView.findViewById(R.id.tv_harga_baru)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_special, parent, false)
        return ListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.imgPhoto.setImageResource(listPromo[position].photo)
        holder.tvDescription.text = listPromo[position].nama
        holder.tvHargaLama.text = HtmlCompat.fromHtml(listPromo[position].harga_coret, HtmlCompat.FROM_HTML_MODE_LEGACY)
        holder.tvHargaBaru.text = listPromo[position].harga

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("EXTRA_PHOTO", listPromo[holder.bindingAdapterPosition].photo)
            intentDetail.putExtra("EXTRA_NAME", listPromo[holder.bindingAdapterPosition].nama)
            intentDetail.putExtra("EXTRA_HARGA_C", listPromo[holder.bindingAdapterPosition].harga_coret)
            intentDetail.putExtra("EXTRA_HARGA_B", listPromo[holder.bindingAdapterPosition].harga)

            holder.itemView.context.startActivity(intentDetail)
        }
    }
    override fun getItemCount(): Int = listPromo.size

}