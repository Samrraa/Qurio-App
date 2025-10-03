package com.samrraa.qurioapp.view.lastgames

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.databinding.LastGameBinding
import com.samrraa.qurioapp.view.lastgames.model.History

class LastGameAdapter(
    private val items: List<History>,
) : RecyclerView.Adapter<LastGameAdapter.LastGameCardViewHolder>() {

    inner class LastGameCardViewHolder(private val binding: LastGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.tvDate.text = history.date
            binding.tvTitle.text = history.subject
            binding.tvCoinsValue.text = history.coin.toString()
            binding.tvStarValue.text = history.star
            binding.tvTimeValue.text = history.time

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastGameCardViewHolder {
        val binding = LastGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LastGameCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LastGameCardViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size

}

class SpaceItemDecoration(
    private val context: Context,
    private val space: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = (space * context.resources.displayMetrics.density).toInt()
    }

}