package com.example.barbershop.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.barbershop.R
import com.example.barbershop.ui.schedules.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_item.*


open class BaseFragment : Fragment(){

    lateinit var mainViewModel: MainViewModel

    companion object {
        const val RQ_PICK_LOCATION = 1
        const val RQ_SHOW_SCHEDULES = 2
        const val KEY_BAR_NAME = "BAR_NAME"
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw  Throwable("Invalid activity")
    }


    fun inflateBottomSheet(layout : Int): Pair<BottomSheetDialog?, View> {
        val bottomSheetDialog =
            context?.let { BottomSheetDialog(it, R.style.BottomSheetDialogTheme) }
        var bottomSheetView: View = LayoutInflater.from(context)
            .inflate(
                layout,
                bottomSheetContainer
            )
        return Pair(bottomSheetDialog, bottomSheetView)
    }


}