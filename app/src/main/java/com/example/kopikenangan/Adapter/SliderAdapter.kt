package com.example.kopikenangan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.R

class SliderAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

        class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val imageView : ImageView = itemView.findViewById(R.id.imageView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
    }

}