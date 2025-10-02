package com.samrraa.qurioapp.view.gameresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.samrraa.qurioapp.databinding.FragmentGameResultBinding

class GameResultFragment : Fragment() {
    private lateinit var binding: FragmentGameResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameResultBinding.inflate(inflater, container, false)
        return binding.root
    }
}