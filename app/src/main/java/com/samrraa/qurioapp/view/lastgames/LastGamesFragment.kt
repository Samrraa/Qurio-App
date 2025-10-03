package com.samrraa.qurioapp.view.lastgames

import android.view.LayoutInflater
import android.view.ViewGroup
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentLastGamesBinding

class LastGamesFragment : BaseFragment<FragmentLastGamesBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLastGamesBinding.inflate(inflater, container, false)
}