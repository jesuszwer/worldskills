package com.example.myapplication.Event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class EventAdapter(private val dataList: List<EventData>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.text1)
        val desc: TextView = itemView.findViewById(R.id.text2)
        val status: TextView = itemView.findViewById(R.id.text3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.events_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]

        // Установите значения изображения и текста для каждого элемента списка
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.title.text = currentItem.title
        holder.desc.text = currentItem.desc
        holder.status.text = currentItem.status

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