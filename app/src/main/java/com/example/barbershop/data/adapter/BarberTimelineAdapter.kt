package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.data.items.BarberTimeline
import com.example.barbershop.databinding.ItemFeedBinding


class BarberTimelineAdapter(val clickListener : BarberTimelineListener) : RecyclerView.Adapter<BarberTimelineAdapter.ViewHolder>(){

    var data = listOf<BarberTimeline>()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : BarberTimeline = data[position]
        holder.bind(item,clickListener)
    }

    class ViewHolder private constructor(val binding : ItemFeedBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(item : BarberTimeline, clickListener: BarberTimelineListener){

        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFeedBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class BarberTimelineListener(val clickListener: (barber: BarberTimeline) -> Unit) {
        fun onClick(barber: BarberTimeline) = clickListener(barber)
    }
}