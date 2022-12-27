package com.example.eindosat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eindosat.databinding.ItemSlidBinding
import com.example.eindosat.networking.Imagslid

class AdapterSlid(private val items:List<Imagslid>): RecyclerView.Adapter<AdapterSlid.ImagViewHolder>() {
    inner class ImagViewHolder(itemView: ItemSlidBinding):RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(data:Imagslid){
            with(binding){
                Glide.with(itemView)
                    .load(data.imagUrl)
                    .into(ivSlid)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagViewHolder {
        return ImagViewHolder(ItemSlidBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImagViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}