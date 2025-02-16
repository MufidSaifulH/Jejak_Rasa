package com.example.kopikenangan.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.Bahasa
import com.example.kopikenangan.BorongActivity
import com.example.kopikenangan.KebijakanActivity
import com.example.kopikenangan.MainActivity
import com.example.kopikenangan.R
import com.example.kopikenangan.KetentuanActivity
import com.example.kopikenangan.TentangActivity
import com.example.kopikenangan.dataclass.Menu

class AdapterMenu(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<AdapterMenu.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.menu)
        val tvDescription: TextView = itemView.findViewById(R.id.tx_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.menu, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMenu.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.imgPhoto.setImageResource(listMenu[position].foto)
        holder.tvDescription.text = listMenu[position].menu

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val selectedMenu = listMenu[holder.bindingAdapterPosition]

            val intent = when (selectedMenu.menu) {
//                "Menu 1" -> Intent(context, DetailActivity::class.java)
//                "Menu 2" -> Intent(context, OrderFragment::class.java)
//                "Menu 3" -> Intent(context, ProfileFragment::class.java)
//                "Menu 4" -> Intent(context, BahasaActivity::class.java)
//                "Menu 5" -> Intent(context, KeranjangActivity::class.java)
//                "Menu 6" -> Intent(context, RiwayatActivity::class.java)
                "Pengaturan Bahasa" -> Intent(context, Bahasa::class.java)
                "Ketentuan Layanan" -> Intent(context, KetentuanActivity::class.java)
                "Kebijakan Privasi" -> Intent(context, KebijakanActivity::class.java)
                "Order Jumlah Besar" -> Intent(context, BorongActivity::class.java)
                "Tentang Kopi Kenangan" -> Intent(context, TentangActivity::class.java)
                else -> Intent(context, MainActivity::class.java)
            }
            intent.putExtra("EXTRA_NAME", selectedMenu.menu)

            context.startActivity(intent)
        }
    }
}
