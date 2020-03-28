package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.data.items.Slide
import com.example.barbershop.databinding.SlideItemContainerBinding

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.ViewHolder>()  {

    var data = listOf<Slide>()
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
        val slideItem : Slide = data[position]
        holder.bind(slideItem)
    }
    class ViewHolder private constructor(val binding : SlideItemContainerBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Slide){

            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
            binding.icon.setImageResource(item.icon)
            binding.imageSlide.setImageResource(item.slideImage)

        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInfalter = LayoutInflater.from(parent.context)
                val binding = SlideItemContainerBinding.inflate(layoutInfalter,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}