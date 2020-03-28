package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import com.example.barbershop.data.items.Feedback
import com.example.barbershop.databinding.ItemDetailRatingBinding

class FeedbackAdapter : RecyclerView.Adapter<FeedbackAdapter.ViewHolder>() {

    var data = listOf<Feedback>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Feedback = data[position]
        holder.bind(item, position)
    }

    class ViewHolder private constructor(val binding : ItemDetailRatingBinding)
        : RecyclerView.ViewHolder(binding.root){

        var listDrawables = listOf(R.drawable.ic_clock_roud,
                                        R.drawable.ic_leader,
                                        R.drawable.ic_contract,
                                        R.drawable.ic_goal)

        fun bind(item : Feedback, position : Int){
            binding.ivBadgeBig.setImageResource(listDrawables[position])
            binding.tvDetailName.text = item.name
            binding.tvBadgeCount.text = item.points.toString()
        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailRatingBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}