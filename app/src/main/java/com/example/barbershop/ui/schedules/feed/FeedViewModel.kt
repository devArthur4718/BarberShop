package com.example.barbershop.ui.schedules.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershop.data.items.Barber
import com.example.barbershop.data.items.BarberTimeline

class FeedViewModel : ViewModel() {

    private val _itemList = MutableLiveData<List<Barber>>()
    val itemList : LiveData<List<Barber>> get() = _itemList

    private val _timeline = MutableLiveData<List<BarberTimeline>>()
    val timeline : LiveData<List<BarberTimeline>> get() = _timeline

    private val _showBarberDetail = MutableLiveData<Boolean>()
    val showBarberDetail: LiveData<Boolean> get() = _showBarberDetail


    init {
        var dummyData = listOf(
            Barber("Arthur", "4.00", ""),
            Barber("Ada Lovelace", "3.50", ""),
            Barber("Jimmy Hendrix", "2.00", ""),
            Barber("Carlos Vinicius", "1.00", ""),
            Barber("Ricardo Bugan", "4.45", ""),
            Barber("Stevie Vaughan", "5.00", ""),
            Barber("Alice", "4.00", ""),
            Barber("Mariana Gomes", "3.50", ""),
            Barber("Camilo", "2.00", ""),
            Barber("Alex", "1.00", ""),
            Barber("Sea Salt", "4.45", "")

        )

        var dummyTimeline = listOf(
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0),
            BarberTimeline("", "", "", 0.0)
            )
        _itemList.value = dummyData
        _timeline.value = dummyTimeline

    }

}
