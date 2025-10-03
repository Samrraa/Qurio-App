package com.samrraa.qurioapp.view.lastgames

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.view.lastgames.model.History


class HomeAdapter(
    private val items: List<History>,
) : RecyclerView.Adapter<HomeAdapter.HomeCardViewHolder>() {

    inner class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val category: TextView = itemView.findViewById(R.id.tv_title)
        val coins: TextView = itemView.findViewById(R.id.tv_coins_value)
        val star: TextView = itemView.findViewById(R.id.tv_star_value)
        val time: TextView = itemView.findViewById(R.id.tv_time_value)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.last_game, parent, false)
        return HomeCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        val history = items[position]
        holder.date.text = history.date
        holder.category.text = history.subject
        holder.coins.text = history.coin.toString()
        holder.star.text = history.star
        holder.time.text = history.time.toString()
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