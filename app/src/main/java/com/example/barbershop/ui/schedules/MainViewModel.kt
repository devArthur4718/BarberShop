package com.example.barbershop.ui.schedules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    private val _serviceValue = MutableLiveData<String>()
    val serviceValue : LiveData<String> get() = _serviceValue

    private val _sumValues = MutableLiveData<Double>()
    val sumValues : LiveData<Double> get() = _sumValues

    private val _navigateToSchedule = MutableLiveData<Boolean>()
    val navigateToSchedule : LiveData<Boolean> get() = _navigateToSchedule

    private val _doMockedLogin = MutableLiveData<Boolean>()
    val doMockedLogin  : LiveData<Boolean> get() = _doMockedLogin

    var total : Double = 0.0

    init {
        _doMockedLogin.value = false
        _serviceValue.postValue("Agendar")
        _sumValues.postValue(0.0)
        _navigateToSchedule.postValue(false)
    }

    fun sumServiceValue(serviceValue : Double){
        total += serviceValue
        _sumValues.value = total
    }

    fun subServiceValue(serviceValue : Double){
        total -= serviceValue
        _sumValues.value = total
    }

    fun showSchedule(){
        _navigateToSchedule.value = true
    }

    fun doneNavigatingSchedule(){
        _navigateToSchedule.value = false
    }

    fun performLogin(){
        _doMockedLogin.value = true
    }

    fun finishedLogin(){
        _doMockedLogin.value = false
    }


}
