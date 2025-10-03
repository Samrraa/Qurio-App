package com.samrraa.qurioapp.view.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samrraa.qurioapp.R

class GameCardAdapter(
    private val items: List<Game>,
    private val onButtonClick: (Game) -> Unit
) : RecyclerView.Adapter<GameCardAdapter.GameCardViewHolder>() {

    inner class GameCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textTitle)
        val button: Button = itemView.findViewById(R.id.startGameButton)
        val image: ImageView = itemView.findViewById(R.id.cardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.small_game_card, parent, false)
        return GameCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameCardViewHolder, position: Int) {
        val game = items[position]
        holder.title.text = game.title
        holder.image.setImageResource(game.imageRes)
        holder.button.setOnClickListener {
            onButtonClick(game)
        }
    }

    override fun getItemCount(): Int = items.size
}