package com.samrraa.qurioapp.view.home

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentHomeBinding
import com.samrraa.qurioapp.view.home.model.History
import kotlinx.datetime.LocalDateTime


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    private fun setupRecycler() {
        val historyList = listOf(
            History(
                date = "2025-10-03",
                coin = 304,
                star = "0",
                subject = "Science & Nature",
                time = LocalDateTime(2025, 10, 2, 15, 30)
            ),
            History(
                date = "2025-10-02",
                coin = 305,
                star = "1",
                subject = "Technology",
                time = LocalDateTime(2025, 10, 2, 15, 30)
            ),
            History(
                date = "2025-10-01",
                coin = 306,
                star = "5",
                subject = "Math",
                time = LocalDateTime(2025, 10, 1, 9, 0)
            ),
            History(
                date = "2025-09-30",
                coin = 307,
                star = "8",
                subject = "History",
                time = LocalDateTime(2025, 9, 30, 18, 45)
            ),
            History(
                date = "2025-09-29",
                coin = 308,
                star = "12",
                subject = "Geography",
                time = LocalDateTime(2025, 9, 29, 12, 20)
            ),
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = HomeAdapter(historyList)
        binding.recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.bottom = 12.dpToPx(requireContext())
            }
        })
    }

    private fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}