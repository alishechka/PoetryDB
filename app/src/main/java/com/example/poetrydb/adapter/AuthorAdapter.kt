package com.example.poetrydb.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poetrydb.R
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.onItemClick
import kotlinx.android.synthetic.main.author_item.view.*

class AuthorAdapter(
    val models: AuthorModel,
    val itemClick: onItemClick
) :
    RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AuthorViewHolder {
        return AuthorViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.author_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.testText.text = models.authors[position]
        holder.bind(models.authors[position], itemClick)
    }

    class AuthorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testText = itemView.tv_test


        fun bind(author: String, onItemClick: onItemClick) {
            itemView.setOnClickListener{onItemClick.clickedItem(author)}
        }
    }
}