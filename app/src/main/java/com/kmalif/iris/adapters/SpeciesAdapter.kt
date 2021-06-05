package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmalif.iris.databinding.ListSpeciesBinding

class SpeciesAdapter():RecyclerView.Adapter<SpeciesAdapter.SpeciesViewholder>() {

    inner class SpeciesViewholder(val binding: ListSpeciesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewholder {
        return SpeciesViewholder(ListSpeciesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SpeciesViewholder, position: Int) {
        TODO("Not yet implemented")
    }
}