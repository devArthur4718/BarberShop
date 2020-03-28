package com.example.barbershop.ui.dialog


import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.barbershop.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {
     var bottomSheet: View? = null
    private var bottomSheetPeekHeight = 0
    override fun getTheme(): Int {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater
            .inflate(R.layout.bottom_sheet_item, container, false)
        bottomSheet = view.findViewById(R.id.bottomSheet)
        // 86dp
        bottomSheetPeekHeight = resources
            .getDimensionPixelSize(R.dimen.bottom_sheet_default_peek_height)
        return view
    }

    override fun onResume() {
        super.onResume()
        setUpBottomSheet()
    }

    private fun setUpBottomSheet() {
        val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior
            .from(view!!.parent as View)
        bottomSheetBehavior.peekHeight = bottomSheetPeekHeight

        val childLayoutParams = bottomSheet!!.layoutParams
        val displayMetrics = DisplayMetrics()

        requireActivity()
            .getWindowManager()
            .getDefaultDisplay()
            .getMetrics(displayMetrics)

        childLayoutParams.height = displayMetrics.heightPixels

        bottomSheet!!.setLayoutParams(childLayoutParams)

    }

    companion object {
        fun newInstance(): BottomSheetFragment {
            return BottomSheetFragment()
        }
    }
}