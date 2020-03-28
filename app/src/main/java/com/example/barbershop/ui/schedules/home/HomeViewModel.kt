package com.example.barbershop.ui.schedules.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershop.data.items.Barber

class HomeViewModel : ViewModel() {

    private val _showBottomDialog = MutableLiveData<Boolean>()
    val showBottomDialog: LiveData<Boolean> get() = _showBottomDialog

    private val _showBarberDialog = MutableLiveData<Boolean>()
    val showBarberDialog: LiveData<Boolean> get() = _showBarberDialog

    private val _pickLocation = MutableLiveData<Boolean>()
    val pickLocation: LiveData<Boolean> get() = _pickLocation

    private val _showCalendarDialog = MutableLiveData<Boolean>()
    val showCalendarDialog: LiveData<Boolean> get() = _showCalendarDialog

    private val _itemList = MutableLiveData<List<Barber>>()
    val itemList : LiveData<List<Barber>> get() = _itemList

    private val _confirmSchedule = MutableLiveData<Boolean>()
    val confirmSchedule : LiveData<Boolean> get() = _confirmSchedule

    init {
        var dummyData = listOf(
            Barber("Sem \n Preferência", "5.00", ""),
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
        _itemList.value = dummyData
        _confirmSchedule.value = false
        _showCalendarDialog.value = false

    }
    fun showConfirmScheduleActivity(){
        _confirmSchedule.value = true
    }

    fun doneShowingConfirmScheduleActivity(){
        _confirmSchedule.value = false
    }

    fun showBottomDialog() {
        _showBottomDialog.value = true
    }

    fun bottomDialogDismissed(){
        _showBottomDialog.value = false
    }

    fun showBarberLocationActivity(){
        _pickLocation.value = true
    }

    fun doneBarberLocationActivity(){
        _pickLocation.value = false
    }

    fun showBarberDialog(){
        _showBarberDialog.value = true
    }

    fun dismissBarberDialog(){
        _showBarberDialog.value = false
    }

    fun showCalendar(){
        _showCalendarDialog.value = true
    }

    fun dismisCalendarDialog(){
        _showCalendarDialog.value = false
    }
}