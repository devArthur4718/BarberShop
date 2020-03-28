package com.example.barbershop.ui.schedules.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.barbershop.R
import com.example.barbershop.databinding.FragmentProfileBinding
import com.example.barbershop.utils.BaseFragment


class ProfileFragment : BaseFragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding : FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        setObservables()
    }

    private fun setObservables() {

        mainViewModel.doMockedLogin.observe(viewLifecycleOwner, Observer {
            if(it)
                findNavController().navigate(R.id.action_navigation_dashboard_to_login)

         })


        binding.btnLogin.setOnClickListener {
            mainViewModel.performLogin()
        }

    }
}
