package com.example.barbershop.data.items

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.barbershop.R


@BindingAdapter("barberStatus")
fun TextView.setBarberStatus(barber: EstablishmentName?){
    barber?.let {
        if(barber.isOpen){
            text = resources.getString(R.string.barber_open)
            setTextColor(resources.getColor(R.color.green))
        }else{
            text = resources.getString(R.string.barber_closed)
            setTextColor(resources.getColor(R.color.red))
        }
    }
}


