package com.example.nytimeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimeapp.dao.response.ArticleResultModel
import com.example.nytimeapp.databinding.ItemArticlesBinding
import com.example.nytimeapp.listener.OnArticleItemClick

class ArticlesAdapter(
    private val arrArticles: ArrayList<ArticleResultModel>,
    val callback: OnArticleItemClick
) : RecyclerView.Adapter<ArticlesAdapter.VH>() {

    class VH(binding: ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root) {
        val mBinding: ItemArticlesBinding = binding
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArticlesBinding.inflate(layoutInflater)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var articleItem = arrArticles.get(position)

        holder.mBinding.tvTitle.text = articleItem.title
        holder.mBinding.tvName.text = articleItem.byline
        holder.mBinding.tvDate.text = articleItem.published_date

        holder.itemView.setOnClickListener {
            callback.onItemClick(articleItem)
        }

    }

    override fun getItemCount(): Int {
        return arrArticles.size
    }
}