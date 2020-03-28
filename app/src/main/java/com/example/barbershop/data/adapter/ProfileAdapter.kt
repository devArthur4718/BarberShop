package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import com.example.barbershop.data.items.HistoryTabItem
import com.example.barbershop.databinding.HistoryTabItemBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ViewHolder>()  {

    var data = listOf<HistoryTabItem>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : HistoryTabItem = data[position]
        holder.bind(item)
    }
    class ViewHolder private constructor(val binding : HistoryTabItemBinding)
        : RecyclerView.ViewHolder(binding.root) {


        fun bind(item : HistoryTabItem){

            if(itemView.resources.getString(R.string.scheduled) == item.title){
                binding.groupBooked.visibility = View.VISIBLE
                binding.groupHistory.visibility = View.GONE
            }else{
                binding.groupBooked.visibility = View.GONE
                binding.groupHistory.visibility = View.VISIBLE
            }


        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInfalter = LayoutInflater.from(parent.context)
                val binding = HistoryTabItemBinding.inflate(layoutInfalter,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}