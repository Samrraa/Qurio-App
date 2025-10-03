package com.samrraa.qurioapp.view.games

import android.view.LayoutInflater
import android.view.ViewGroup
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGamesBinding

class GamesFragment : BaseFragment<FragmentGamesBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGamesBinding.inflate(inflater, container, false)
}