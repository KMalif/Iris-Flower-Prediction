package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmalif.iris.databinding.ListArticlesBinding

class ArticleAdapter():RecyclerView.Adapter<ArticleAdapter.ArticleViewholder>() {
    inner class ArticleViewholder(val binding: ListArticlesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewholder {
        return ArticleViewholder(ListArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArticleViewholder, position: Int) {
        TODO("Not yet implemented")
    }
}