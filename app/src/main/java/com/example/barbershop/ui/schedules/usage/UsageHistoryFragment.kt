package com.example.barbershop.ui.schedules.usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.barbershop.R
import com.example.barbershop.data.adapter.ProfileAdapter
import com.example.barbershop.data.items.HistoryTabItem
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_usage_history.*

class UsageHistoryFragment : Fragment() {

    private lateinit var notificationsViewModel: UsageHistoryViewModel
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(UsageHistoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_usage_history, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var historyTabItem = listOf(
            HistoryTabItem(getString(R.string.scheduled)),
            HistoryTabItem(getString(R.string.history))
        )

        adapter = ProfileAdapter()
        adapter.data = historyTabItem

        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = historyTabItem[position].title

        }.attach()
    }
}
