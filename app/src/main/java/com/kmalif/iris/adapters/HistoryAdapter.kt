package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmalif.iris.databinding.ListHistoryBinding
import com.kmalif.iris.models.History

class HistoryAdapter(private val histories : MutableList<History>): RecyclerView.Adapter<HistoryAdapter.HistoryViewholder>() {
    inner class HistoryViewholder(val binding: ListHistoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewholder {
        return HistoryViewholder(ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return histories.size
    }

    fun setHistory(data : List<History>){
        histories.clear()
        histories.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HistoryViewholder, position: Int) {
        holder.binding.apply {
            TVSepalLength.text = histories[position].getSLength()
            TvSepalWidth.text = histories[position].getSWidth()
            TvPetalLength.text = histories[position].getPLength()
            TVPetalWidth.text = histories[position].getPWidth()
            TVResult.text = histories[position].getResult()
        }
    }
}