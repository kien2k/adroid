package com.example.tbdhspdn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TBaoListAdapter(private val listener: OnItemClickedTBao):RecyclerView.Adapter<TBaoListAdapter.TBaoViewHolder>() {

    private val items:ArrayList<ThongBao> = ArrayList()

    class TBaoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        val title : TextView = itemView.findViewById(R.id.tieude)
        val author : TextView = itemView.findViewById(R.id.ngaydang)
        val urlToImage : ImageView = itemView.findViewById(R.id.image2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TBaoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tbao,parent,false)
        val viewHolder = TBaoViewHolder(view)
        view.setOnClickListener{
            listener.ItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TBaoViewHolder, position: Int) {
        val currentItem = items[position]
        holder.title.text = currentItem.title
        holder.author.text = currentItem.author

        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.urlToImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateTBao(updateTBao: ArrayList<ThongBao>){
        items.clear()
        items.addAll(updateTBao)
        notifyDataSetChanged()
    }
}
interface OnItemClickedTBao
{
    fun ItemClicked(items:ThongBao)
}