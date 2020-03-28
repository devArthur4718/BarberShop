package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.data.items.EstablishmentName
import com.example.barbershop.databinding.ItemBarberLocationBinding


class EstablishmentAdapter(val clickListener : EstablishmentListener) : RecyclerView.Adapter<EstablishmentAdapter.ViewHolder>(){

    var data = listOf<EstablishmentName>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : EstablishmentName = data[position]
        holder.bind(clickListener, item)
    }

    class ViewHolder private constructor( val binding : ItemBarberLocationBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(clickListener: EstablishmentListener, item : EstablishmentName){
            binding.establishment = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBarberLocationBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class EstablishmentListener(val clickListener: (establishment: EstablishmentName) -> Unit) {
        fun onClick(establishment: EstablishmentName) = clickListener(establishment)
    }

}