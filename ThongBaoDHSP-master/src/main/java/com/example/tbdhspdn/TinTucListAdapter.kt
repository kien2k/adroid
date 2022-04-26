package com.example.tbdhspdn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TinTucListAdapter(private val listener:OnItemClicked) : RecyclerView.Adapter<TinTucListAdapter.TinTucViewHolder>() {

    private val items:ArrayList<TinTuc> = ArrayList()

    class TinTucViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)
        val author: TextView = itemView.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TinTucViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_thongbao,parent,false)
        val viewHolder = TinTucViewHolder(view)
        view.setOnClickListener{
            listener.ItemClick(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TinTucViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author

        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateTinTuc(updatedNews:ArrayList<TinTuc>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

interface OnItemClicked{
    fun ItemClick(items: TinTuc)
}