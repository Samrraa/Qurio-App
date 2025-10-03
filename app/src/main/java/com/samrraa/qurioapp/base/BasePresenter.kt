package com.samrraa.qurioapp.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BasePresenter<VIEW : BaseView>(
    protected val view: VIEW,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
) {
    protected fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccess: ((T) -> Unit) = {},
        onError: (Throwable) -> Unit = {},
        onStart: suspend () -> Unit = {},
        onFinally: () -> Unit = {},
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
    ): Job {
        val handler = CoroutineExceptionHandler { _, throwable ->
            onError(throwable)
        }

        return scope.launch(dispatcher + handler) {
            onStart()
            runCatching { execute() }
                .onSuccess { result -> onSuccess.invoke(result) }
                .onFailure { throwable -> onError(throwable) }
            onFinally()
        }
    }
}