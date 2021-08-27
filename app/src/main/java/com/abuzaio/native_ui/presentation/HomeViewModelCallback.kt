package com.abuzaio.native_ui.presentation

import com.abuzaio.native_ui.data.Result

interface HomeViewModelCallback {
    fun onSuccess(results: List<Result>)
    fun onError(error: Throwable)
}