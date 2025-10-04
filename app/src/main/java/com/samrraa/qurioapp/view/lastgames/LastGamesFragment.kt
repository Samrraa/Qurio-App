package com.samrraa.qurioapp.view.lastgames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentLastGamesBinding
import com.samrraa.qurioapp.view.lastgames.model.History

class LastGamesFragment : BaseFragment<FragmentLastGamesBinding>() {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLastGamesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupClickListeners()
    }

    private fun setupRecycler() {
        val historyList = getHistoryList()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = LastGameAdapter(historyList)
            addItemDecoration(SpaceItemDecoration(requireContext(), 12))
        }
    }

    private fun setupClickListeners() {
        binding.backArrow.setOnClickListener {
        }
    }

    private fun getHistoryList() = listOf(
        History(
            date = "2025-10-03",
            coin = 304,
            star = "0",
            subject = "Science & Nature",
            time = "2025, 10, 2, 15, 30"
        ),
        History(
            date = "2025-10-02",
            coin = 305,
            star = "1",
            subject = "Technology",
            time = "2025, 10, 2, 15, 30"
        ),
        History(
            date = "2025-10-01",
            coin = 306,
            star = "5",
            subject = "Math",
            time = "2025, 10, 1, 9, 0"
        ),
        History(
            date = "2025-09-30",
            coin = 307,
            star = "8",
            subject = "History",
            time = "2025, 9, 30, 18, 45"
        ),
        History(
            date = "2025-09-29",
            coin = 308,
            star = "12",
            subject = "Geography",
            time = "2025, 9, 29, 12, 20"
        )
    )


}