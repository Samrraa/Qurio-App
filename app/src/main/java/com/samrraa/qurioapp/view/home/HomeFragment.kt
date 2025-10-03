package com.samrraa.qurioapp.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuestionFragment())
        }
    }
}