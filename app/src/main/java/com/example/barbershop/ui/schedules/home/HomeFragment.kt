package com.example.barbershop.ui.schedules.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.barbershop.R
import com.example.barbershop.data.adapter.BarberAdapter
import com.example.barbershop.databinding.FragmentHomeBinding
import com.example.barbershop.ui.schedules.barber.BarberLocationList
import com.example.barbershop.ui.schedules.confirm.ConfirmSchedule
import com.example.barbershop.utils.BaseFragment
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = homeViewModel
        setObservables()
    }

    private fun setObservables() {
        homeViewModel.showBottomDialog.observe(viewLifecycleOwner, Observer {
            if (it) showBottomSheet()
        })

        homeViewModel.pickLocation.observe(viewLifecycleOwner, Observer {
            if (it) sendIntentBarberActivity()
        })

        homeViewModel.showBarberDialog.observe(viewLifecycleOwner, Observer {
            if (it) showBarberBottomSheet()
        })
        homeViewModel.showCalendarDialog.observe(viewLifecycleOwner, Observer {
            if (it) showCalendarDialog()
        })

        homeViewModel.confirmSchedule.observe(viewLifecycleOwner, Observer {
            if (it) confirmScheduleActivity()
        })


    }

    private fun confirmScheduleActivity() {
        val intent = Intent(context, ConfirmSchedule::class.java)
        homeViewModel.doneShowingConfirmScheduleActivity()
        startActivityForResult(intent, RQ_SHOW_SCHEDULES)
    }

    private fun showCalendarDialog() {
        val pair = inflateBottomSheet(R.layout.layout_dialog_calendar)
        val bottomSheetDialog = pair.first
        var bottomSheetView: View = pair.second
        bottomSheetDialog?.setContentView(bottomSheetView)
        bottomSheetDialog?.show()
        bottomSheetDialog?.setOnDismissListener {
            homeViewModel.dismisCalendarDialog()
        }

        var events: MutableList<EventDay> = ArrayList()
        var validEvents : MutableList<EventDay> = ArrayList()

        val calendar: Calendar = Calendar.getInstance()
        events.add(EventDay(calendar, R.drawable.indicator_red, R.color.red))
        events[0].isEnabled = false

        val calendar1: Calendar = Calendar.getInstance()
        calendar1.set(2020, 2, 24)
        events.add(EventDay(calendar1, R.drawable.indicator_green, R.color.green))
        events[1].isEnabled = true


        bottomSheetView.findViewById<Button>(R.id.dismissCalendar).setOnClickListener {
            homeViewModel.dismisCalendarDialog()
            bottomSheetDialog?.dismiss()
        }


        var calendarView = bottomSheetView.findViewById<CalendarView>(R.id.myCalendar)


        events.forEach {
            if(it.isEnabled) validEvents.add(it)
        }


        calendarView.setEvents(events)

        calendarView.setOnDayClickListener(object :
            OnDayClickListener {
            override fun onDayClick(eventDay: EventDay) {
                val clickedDayCalendar = eventDay.calendar

                validEvents.forEach {validDay ->
                    if(eventDay == validDay){
                        val year = clickedDayCalendar.get(Calendar.YEAR).toString()
                        val month = clickedDayCalendar.get(Calendar.MONTH).toString()
                        val day = clickedDayCalendar.get(Calendar.DAY_OF_MONTH).toString()
                        binding.tvInputCalendarDate.editText?.setText("${day}/${month.toInt() + 1}/${year}")
                        homeViewModel.dismisCalendarDialog()
                        bottomSheetDialog?.dismiss()
                    }
                }

            }
        })

    }

    private fun showBarberBottomSheet() {
        val pair = inflateBottomSheet(R.layout.layout_bottomsheet_barbers)
        val bottomSheetDialog = pair.first
        var bottomSheetView: View = pair.second
        bottomSheetDialog?.setContentView(bottomSheetView)
        bottomSheetDialog?.show()
        bottomSheetDialog?.setOnDismissListener {
            homeViewModel.dismissBarberDialog()
        }
        var recycler = bottomSheetView.findViewById<RecyclerView>(R.id.rvBarbers)
        bottomSheetView.findViewById<Button>(R.id.btnCloseBarbers).setOnClickListener {
            bottomSheetDialog?.dismiss()
        }
        var adapter = BarberAdapter(BarberAdapter.BarberListener {
            bottomSheetDialog?.dismiss()
            binding.inputBarder.editText?.setText(it.name)
        })
        homeViewModel.itemList.value?.let { dataList ->
            adapter.data = dataList
        }
        recycler.layoutManager = GridLayoutManager(activity, 3)
        recycler.adapter = adapter
    }

    private fun sendIntentBarberActivity() {
        homeViewModel.doneBarberLocationActivity()
        var intent = Intent(activity, BarberLocationList::class.java)
        startActivityForResult(intent, RQ_PICK_LOCATION)
    }

    private fun showBottomSheet() {
        val pair = inflateBottomSheet(R.layout.layout_bottom_sheet)
        val bottomSheetDialog = pair.first
        var bottomSheetView: View = pair.second
        bottomSheetView.findViewById<Button>(R.id.btnDismiss).setOnClickListener {
            bottomSheetDialog?.dismiss()
        }
        val buttonAgendar = bottomSheetView.findViewById<Button>(R.id.btnAgendar)
        bottomSheetDialog?.setContentView(bottomSheetView)
        bottomSheetDialog?.show()
        bottomSheetDialog?.setOnDismissListener {
            homeViewModel.bottomDialogDismissed()
        }
        buttonAgendar.setOnClickListener {
            bottomSheetDialog?.dismiss()
            binding.inputService.editText?.setText("R$ ${mainViewModel.sumValues.value}")

        }

        mainViewModel.sumValues.observe(viewLifecycleOwner, Observer { serviceValue ->
            if (serviceValue == 0.0)
                buttonAgendar.text = "Agendar"
            else
                buttonAgendar.text = "R$ ${serviceValue}  Agendar"
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            RQ_PICK_LOCATION -> {
                if (resultCode == Activity.RESULT_OK) {
                    var name = data?.getStringExtra(KEY_BAR_NAME)
                    binding.tvBarberUnit.editText?.setText(name)
                }
            }
            RQ_SHOW_SCHEDULES -> {
                if (resultCode == Activity.RESULT_OK) {
                    mainViewModel.showSchedule()
                }
            }
        }
    }
}
