package com.example.barbershop.ui.schedules.barber

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.barbershop.R
import com.example.barbershop.data.adapter.EstablishmentAdapter
import com.example.barbershop.data.items.EstablishmentName
import com.example.barbershop.databinding.ActivityBarberLocationListBinding

class BarberLocationList : AppCompatActivity() {

    private lateinit var viewModel : BarberViewModel
    private lateinit var binding : ActivityBarberLocationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_barber_location_list)
        supportActionBar?.setHomeButtonEnabled(true)
        viewModel = ViewModelProviders.of(this).get(BarberViewModel::class.java)
        setObservables()
    }

    private fun setObservables() {
        viewModel.barberMockList.observe(this, Observer { establishmentList ->
            showBarberList(establishmentList)
        })

    }

    private fun showBarberList(establishmentList: List<EstablishmentName>) {
        val adapter = EstablishmentAdapter(EstablishmentAdapter.EstablishmentListener { establishment ->
            if(establishment.isOpen)
                sendNameResult(establishment.barberName)
        })
        adapter.data = establishmentList
        binding.rvBarberLocation.adapter = adapter
    }

    private fun sendNameResult(establishmentName: String) {
        var intent = Intent()
        intent.putExtra(KEY_BAR_NAME, establishmentName)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        setResult(Activity.RESULT_CANCELED)
        finish()
        return true
    }

    companion object{
        const val  KEY_BAR_NAME = "BAR_NAME"
    }
}
