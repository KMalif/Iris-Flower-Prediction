package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmalif.iris.databinding.ListHistoryBinding

class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.HistoryViewholder>() {
    inner class HistoryViewholder(val binding: ListHistoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewholder {
        return HistoryViewholder(ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HistoryViewholder, position: Int) {
        TODO("Not yet implemented")
    }
}