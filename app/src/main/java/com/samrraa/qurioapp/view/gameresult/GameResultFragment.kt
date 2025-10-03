package com.samrraa.qurioapp.view.gameresult

import android.view.LayoutInflater
import android.view.ViewGroup
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentGameResultBinding

class GameResultFragment : BaseFragment<FragmentGameResultBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGameResultBinding.inflate(inflater, container, false)
}