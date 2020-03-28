package com.example.barbershop.ui.schedules.barber.barberdetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.barbershop.R
import com.example.barbershop.data.adapter.CommentAdapter
import com.example.barbershop.data.adapter.FeedbackAdapter
import com.example.barbershop.data.items.Comment
import com.example.barbershop.data.items.Feedback
import com.example.barbershop.databinding.ActivityBarDetailBinding
import com.example.barbershop.ui.schedules.barber.barberdetail.comment.CommentActivity

class BarberDetail : AppCompatActivity() {

    private lateinit var binding: ActivityBarDetailBinding
    private lateinit var viewModel: BarberDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bar_detail)
        supportActionBar?.hide()
        viewModel = ViewModelProviders.of(this).get(BarberDetailViewModel::class.java)
        setObservables()
    }

    private fun setObservables() {
        viewModel.ItemFeedbackList.observe(this, Observer {
            setFeedbackList(it)
        })

        viewModel.itemComment.observe(this, Observer {
            setCommentList(it)
        })

        binding.ivClose.setOnClickListener {
            finish()
        }
        binding.ivDetailBackground.setOnClickListener {
            finish()
        }
    }

    private fun setCommentList(datalist: List<Comment>?) {
        val adapter = CommentAdapter(CommentAdapter.CommentListener {
            showCommentActivity(it)
        })
        datalist?.let {
            adapter.data = it
        }
        binding.rvComments.adapter = adapter
    }

    private fun showCommentActivity(data: Comment) {
        val intent = Intent(this@BarberDetail, CommentActivity::class.java)
        intent.putExtra(KEY_COMMMENT, data.comment)
        startActivity(intent)
    }

    private fun setFeedbackList(datalist: List<Feedback>?) {
        val adapter = FeedbackAdapter()
        datalist?.let {
            adapter.data = it
        }
        binding.rvFeedbacks.adapter = adapter
    }

    companion object{
        val KEY_COMMMENT = "TEXT_COMMMENT"
    }
}
