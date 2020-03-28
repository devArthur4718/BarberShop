package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import com.example.barbershop.data.items.Barber
import com.example.barbershop.databinding.ItemBarberBinding

class BarberAdapter(val clickListener : BarberListener) : RecyclerView.Adapter<BarberAdapter.ViewHolder>() {

     var data = listOf<Barber>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Barber = data[position]
        holder.bind(item,clickListener)
    }

    class ViewHolder private constructor(val binding : ItemBarberBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Barber, clickListener: BarberListener){
            binding.barber = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
            if(item.name.equals("Sem \n Preferência")){
                binding.profileImage.setImageResource(R.drawable.no_barber)
                binding.containerRating.visibility = View.INVISIBLE
            }else{
                binding.profileImage.setImageResource(R.drawable.img_avatar1)
                binding.containerRating.visibility = View.VISIBLE
            }
        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBarberBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class BarberListener(val clickListener: (barber: Barber) -> Unit) {
        fun onClick(barber: Barber) = clickListener(barber)
    }


}