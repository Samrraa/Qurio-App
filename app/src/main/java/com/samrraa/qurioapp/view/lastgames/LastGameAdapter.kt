package com.samrraa.qurioapp.view.lastgames

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.databinding.LastGameBinding
import com.samrraa.qurioapp.view.lastgames.model.History


class HomeAdapter(
    private val items: List<History>,
) : RecyclerView.Adapter<HomeAdapter.HomeCardViewHolder>() {

    inner class HomeCardViewHolder(private val binding: LastGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.tvDate.text = history.date
            binding.tvTitle.text = history.subject
            binding.tvCoinsValue.text = history.coin.toString()
            binding.tvStarValue.text = history.star
            binding.tvTimeValue.text = history.time

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        val binding = LastGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size

}
class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = space
    }
}