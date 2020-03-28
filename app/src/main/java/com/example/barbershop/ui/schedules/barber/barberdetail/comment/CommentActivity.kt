package com.example.barbershop.ui.schedules.barber.barberdetail.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.barbershop.R
import com.example.barbershop.databinding.ActivityCommentBinding

class CommentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment)
        supportActionBar?.setHomeButtonEnabled(true)
        if(intent.hasExtra(KEY_COMMMENT)){
            binding.tvCommentBig.text = intent.getStringExtra(KEY_COMMMENT)
        }
    }

    companion object{
        val KEY_COMMMENT = "TEXT_COMMMENT"
    }
}
