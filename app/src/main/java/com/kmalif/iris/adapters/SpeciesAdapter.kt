package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmalif.iris.databinding.ListSpeciesBinding
import com.kmalif.iris.models.Species

class SpeciesAdapter(private val listSpecies : ArrayList<Species>):RecyclerView.Adapter<SpeciesAdapter.SpeciesViewholder>() {

    inner class SpeciesViewholder(val binding: ListSpeciesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewholder {
        return SpeciesViewholder(ListSpeciesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listSpecies.size
    }

    override fun onBindViewHolder(holder: SpeciesViewholder, position: Int) {
        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(listSpecies[position].image)
                .into(holder.binding.SpeciesImage)
            SpeciesName.text = listSpecies[position].name
        }
    }
}