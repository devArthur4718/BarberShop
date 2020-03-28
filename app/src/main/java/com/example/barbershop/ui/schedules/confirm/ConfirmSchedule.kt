package com.example.barbershop.ui.schedules.confirm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.barbershop.R
import com.example.barbershop.databinding.ActivityScheduleBinding

class ConfirmSchedule : AppCompatActivity() {

//    private lateinit var viewModel: ConfirmScheduleViewModel
    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule)
        supportActionBar?.hide()
        getDataFromBundle()
        setObservables()
    }

    private fun getDataFromBundle() {

    }

    private fun setObservables() {
        binding.btnGetAllScheduledServices.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

    }
}
