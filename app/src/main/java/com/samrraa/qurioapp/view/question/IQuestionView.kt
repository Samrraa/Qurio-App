package com.samrraa.qurioapp.view.question

import com.samrraa.qurioapp.base.BaseView

interface IQuestionView : BaseView {
    fun onGetQuestionsSuccess(questions: List<String>)
}