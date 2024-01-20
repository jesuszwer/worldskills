package com.example.myapplication.Tickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TicketsAdapter(private val dataList: List<TicketData>) : RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_text)
        val place: TextView = itemView.findViewById(R.id.place_text)
        val type: TextView = itemView.findViewById(R.id.type_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tickets_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]

        holder.name.text = currentItem.name
        holder.place.text = currentItem.place
        holder.type.text = if (currentItem.type == 1) "Open" else "Close"

        holder.itemView.setOnClickListener{
            listener?.onItemClick(position)
        }

    }

    override fun getItemCount() = dataList.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var listener: OnItemClickListener?=null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}