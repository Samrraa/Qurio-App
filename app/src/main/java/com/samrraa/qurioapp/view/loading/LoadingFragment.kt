package com.samrraa.qurioapp.view.loading

import android.annotation.SuppressLint
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentLoadingBinding

class LoadingFragment : BaseFragment<FragmentLoadingBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoadingBinding = FragmentLoadingBinding.inflate(inflater, container, false)

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loadingAnimation =
            resources.getDrawable(R.drawable.ic_loading, null) as? AnimatedImageDrawable
        binding.gifImageView.setImageDrawable(loadingAnimation)
        loadingAnimation?.start()

    }
}