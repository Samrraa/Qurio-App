package com.samrraa.qurioapp.view.lastgames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.samrraa.qurioapp.databinding.FragmentLastGamesBinding

class LastGamesFragment : Fragment() {
    private lateinit var binding: FragmentLastGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLastGamesBinding.inflate(inflater, container, false)
        return binding.root
    }
}