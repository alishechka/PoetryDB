package com.example.poetrydb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poetrydb.R
import com.example.poetrydb.model.TitleByAuthorModel
import kotlinx.android.synthetic.main.title_by_authro_item.view.*

class TitleByAuthorAdapter(val models: List<TitleByAuthorModel>) :
    RecyclerView.Adapter<TitleByAuthorAdapter.TitleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TitleViewHolder {
        return TitleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.title_by_authro_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.title.text = models[position].title
        holder.author.text = models[position].author
        //hmm this might not work

        val list = models[position].lines
        for (i in list){
            holder.titleBody.append(i)
            holder.titleBody.append("\n")
        }

//        holder.titleBody.text = models[position].lines[5]
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.tv_title
        val author = itemView.tv_author
        val titleBody = itemView.tv_title_body
    }
}