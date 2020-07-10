package com.arpit.modimemes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.memes_item.view.*

class ViewAdapter(private val memes: List<MemeResponse>): RecyclerView.Adapter<ViewAdapter.ViewHolder>() {
    class ViewHolder(itemView :View): RecyclerView.ViewHolder(itemView) {
        var ivMemes :ImageView = itemView.ivMemes
        var textView :TextView = itemView.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.memes_item , parent , false)
        return  ViewHolder(view)
    }

    override fun getItemCount() = memes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val meme = memes[position]
        Picasso.get().load(meme.url).into(holder.ivMemes)
        holder.textView.text = meme.id
    }
}