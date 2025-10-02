package com.samrraa.qurioapp.view.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentQuestionBinding
import com.samrraa.qurioapp.presenter.QuestionPresenter

class QuestionFragment : BaseFragment<FragmentQuestionBinding, IQuestionView, QuestionPresenter>(),
    IQuestionView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentQuestionBinding.inflate(inflater, container, false)

    override fun initPresenter() = QuestionPresenter(this, lifecycleScope)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getQuestions()
    }

    override fun onGetQuestionsSuccess(questions: List<String>) {
        binding.textView.text = questions.joinToString("\n\n") { it }
    }
}