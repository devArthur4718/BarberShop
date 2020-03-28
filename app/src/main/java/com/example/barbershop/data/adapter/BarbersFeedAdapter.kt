package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.data.items.Barber
import com.example.barbershop.databinding.ItemSmallBarberBinding


class BarbersFeedAdapter ( val clickListener : BarberFeedListener) : RecyclerView.Adapter<BarbersFeedAdapter.ViewHolder>() {


    var data = listOf<Barber>()
        set(value){
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: BarbersFeedAdapter.ViewHolder, position: Int) {
        val item : Barber = data[position]
        holder.bind(item,clickListener)
    }

    class ViewHolder private constructor(val binding : ItemSmallBarberBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Barber, clickListener: BarberFeedListener){
            binding.tvSmallBarberName.text = item.name
            binding.barber = item
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSmallBarberBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class BarberFeedListener(val clickListener: (barber: Barber) -> Unit) {
        fun onClick(barber: Barber) = clickListener(barber)
    }

}