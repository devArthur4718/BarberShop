package com.example.barbershop.ui.schedules.barber

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershop.data.items.EstablishmentName

class BarberViewModel : ViewModel() {

    private val _barberMockList = MutableLiveData<List<EstablishmentName>>()
    val barberMockList : LiveData<List<EstablishmentName>> get() = _barberMockList

    init {
        _barberMockList.postValue(listOf(
            EstablishmentName("Seu Antônio", "Paulistano", "Av.Paulista - 1204, São Paulo - SP", true),
            EstablishmentName("Seu Zé", "Jd.Pery", "Av.Paulista - 1204, São Paulo - SP", false),
            EstablishmentName("Seu Marcelo", "Morumbi", "Av.Paulista - 1204, São Paulo - SP", true),
            EstablishmentName("Seu Carioca", "Ipanema", "Av.Paulista - 1204, São Paulo - SP", false),
            EstablishmentName("Seu Mujica", "Pacaembu", "Av.Paulista - 1204, São Paulo - SP", false),
            EstablishmentName("Seu Malaquias", "Paulistano", "Av.Paulista - 1204, São Paulo - SP", true),
            EstablishmentName("Seu Cuca", "Paulistano", "Av.Paulista - 1204, São Paulo - SP", true)
        ))
    }

}