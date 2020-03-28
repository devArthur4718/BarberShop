package com.example.barbershop.ui.schedules.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.barbershop.R
import com.example.barbershop.data.adapter.BarberTimelineAdapter
import com.example.barbershop.data.adapter.BarbersFeedAdapter
import com.example.barbershop.data.items.Barber
import com.example.barbershop.data.items.BarberTimeline
import com.example.barbershop.databinding.FragmentFeedBinding
import com.example.barbershop.ui.schedules.barber.barberdetail.BarberDetail
import com.example.barbershop.utils.BaseFragment


class Feed : BaseFragment() {

    private lateinit var binding : FragmentFeedBinding
    private lateinit var feedViewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_feed,
            container,
            false)

       return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        binding.viewModel = feedViewModel
        setObservables()
    }

    private fun setObservables() {
        feedViewModel.itemList.observe(viewLifecycleOwner, Observer { barberList ->
            setMockedBarberList(barberList)
        })

        feedViewModel.timeline.observe(viewLifecycleOwner, Observer {
            setMockedTimeline(it)
        })
    }

    private fun setMockedTimeline(barberList: List<BarberTimeline>?) {
        val adapter = BarberTimelineAdapter(BarberTimelineAdapter.BarberTimelineListener {

        })

        barberList?.let {
            adapter.data = it
        }


        binding.rvBarberTimeline.adapter = adapter
    }

    private fun setMockedBarberList(barberList: List<Barber>?) {
        val adapter = BarbersFeedAdapter(BarbersFeedAdapter.BarberFeedListener{
            var intent = Intent(activity, BarberDetail::class.java)
            startActivity(intent)
        })
        barberList?.let {
            adapter.data = it
        }
        binding.rvBarbersFeed.adapter = adapter
    }
}
