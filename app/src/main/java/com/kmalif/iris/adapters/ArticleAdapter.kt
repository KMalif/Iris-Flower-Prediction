package com.kmalif.iris.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmalif.iris.databinding.ListArticlesBinding
import com.kmalif.iris.models.Articles

class ArticleAdapter(private val listArticles : ArrayList<Articles>, val listener : ArticleAdapter.OnClick ):RecyclerView.Adapter<ArticleAdapter.ArticleViewholder>() {
    inner class ArticleViewholder(val binding: ListArticlesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewholder {
        return ArticleViewholder(ListArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listArticles.size
    }

    override fun onBindViewHolder(holder: ArticleViewholder, position: Int) {
        holder.binding.apply {
            Glide.with(holder.itemView.context)
                    .load(listArticles[position].image)
                    .into(holder.binding.ArticleImage)
            Title.text = listArticles[position].title
            Content.text = listArticles[position].content
        }
        holder.itemView.setOnClickListener {
            listener.onItemClick(listArticles[position])
        }
    }

    interface OnClick{
        fun onItemClick(articles: Articles)
    }
}