package com.example.tbdhspdn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NhomListAdapter(private val listener:OnItemClickedNhom) : RecyclerView.Adapter<NhomListAdapter.NhomViewHolder>() {

    private val items:ArrayList<Nhom> = ArrayList()

    class NhomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tennhom: TextView = itemView.findViewById(R.id.tennhom)
        val chutich: TextView = itemView.findViewById(R.id.chutich)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NhomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nhom,parent,false)
        val viewHolder = NhomViewHolder(view)
        view.setOnClickListener{
            listener.ItemClick(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NhomViewHolder, position: Int) {
        val currentItem = items[position]
        holder.tennhom.text = currentItem.tennhom
        holder.chutich.text = currentItem.chutich
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNhom(updatedNhom:ArrayList<Nhom>){
        items.clear()
        items.addAll(updatedNhom)

        notifyDataSetChanged()
    }
}

interface OnItemClickedNhom{
    fun ItemClick(items:Nhom)
}