package com.example.barbershop.ui.schedules

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.barbershop.R
import com.example.barbershop.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        val navController = findNavController(R.id.nav_host_fragment)
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        binding.navView.setupWithNavController(navController)
        setObservables()
    }

    private fun setObservables() {
        viewModel.navigateToSchedule.observe(this, Observer {
            if(it) showSchedule()
        })
    }

    private fun showSchedule() {
        viewModel.doneNavigatingSchedule()
        binding.navView.selectedItemId = R.id.navigation_history
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    fun onCheckboxClicked(view: View) {
        if(view is CheckBox){
            val checked: Boolean = view.isChecked

            when(view.id){
                R.id.checkbox_service1 -> {
                    if(checked)
                        viewModel.sumServiceValue(50.00)
                    else
                        viewModel.subServiceValue(50.00)
                }
                R.id.checkbox_service2 -> {
                    if(checked)
                        viewModel.sumServiceValue(90.00)
                    else
                        viewModel.subServiceValue(90.00)
                }
                R.id.checkbox_service3 -> {
                    if(checked)
                        viewModel.sumServiceValue(55.00)
                    else
                        viewModel.sumServiceValue(-55.00)
                }
                R.id.checkbox_service4 -> {
                    if(checked)
                        viewModel.sumServiceValue(40.00)
                    else
                        viewModel.sumServiceValue(-40.00)
                }
                R.id.checkbox_service5 -> {
                    if(checked)
                        viewModel.sumServiceValue(50.00)
                    else
                        viewModel.sumServiceValue(-50.00)
                }
                R.id.checkbox_service6 -> {
                    if(checked)
                        viewModel.sumServiceValue(90.00)
                    else
                        viewModel.sumServiceValue(-90.00)
                }
            }
        }
    }
}
