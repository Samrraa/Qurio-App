package com.samrraa.qurioapp.presenter

import com.samrraa.qurioapp.base.BasePresenter
import com.samrraa.qurioapp.model.FakeQuizRepository
import com.samrraa.qurioapp.view.question.IQuestionView
import kotlinx.coroutines.CoroutineScope

class QuestionPresenter(
    view: IQuestionView,
    scope: CoroutineScope,
    private val repository: FakeQuizRepository = FakeQuizRepository()
) : BasePresenter<IQuestionView>(view, scope) {
    fun getQuestions() {
        tryToExecute(
            execute = repository::getQuestions,
            onSuccess = view::onGetQuestionsSuccess,
        )
    }
}

