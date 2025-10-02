package com.samrraa.qurioapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VIEW_BINDING : ViewBinding, VIEW : BaseView, PRESENTER : BasePresenter<VIEW>> :
    Fragment() {
    private lateinit var _binding: VIEW_BINDING
    protected val binding: VIEW_BINDING
        get() = _binding

    private lateinit var _presenter: PRESENTER
    protected val presenter: PRESENTER
        get() = _presenter

    abstract fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): VIEW_BINDING

    abstract fun initPresenter(): PRESENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _presenter = initPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = initViewBinding(inflater, container)
        return _binding.root
    }
}