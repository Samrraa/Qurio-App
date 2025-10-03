package com.samrraa.qurioapp.view.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGamesBinding

class GamesFragment : BaseFragment<FragmentGamesBinding>() {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGamesBinding.inflate(inflater, container, false)

    private fun setupRecycler() {
        val games = listOf(
            Game("Music", R.drawable.music),
            Game("Food & Drink", R.drawable.ic_food_and_coffe),
            Game("Geography", R.drawable.green_image),
            Game("General knowledge", R.drawable.knowladge),
            Game("Television", R.drawable.tv),
            Game("Family", R.drawable.family)
        )

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = GameCardAdapter(games) { game ->
            Toast.makeText(requireContext(), "Clicked on ${game.title}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }
}

data class Game(
    val title: String,
    val imageRes: Int
)