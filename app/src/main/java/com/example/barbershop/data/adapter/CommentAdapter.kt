package com.example.barbershop.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.data.items.Comment
import com.example.barbershop.databinding.ItemCommentCardBinding

class CommentAdapter(val clicklistener : CommentListener ) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    var data = listOf<Comment>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Comment = data[position]
        holder.bind(item, clicklistener)
    }

    class ViewHolder private constructor(val binding : ItemCommentCardBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Comment, clicklistener : CommentListener){
            binding.comment = item
            binding.clicklistener = clicklistener
            binding.executePendingBindings()
            binding.tvContent.text = item.comment
            binding.lastCommentDate.text = item.timelapse
        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCommentCardBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class CommentListener(val clickListener: (comment: Comment) -> Unit) {
        fun onClick(comment: Comment) = clickListener(comment)
    }
}