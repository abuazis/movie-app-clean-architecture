package com.abuzaio.native_ui.presentation

import com.abuzaio.native_ui.data.Result

interface HomeView {
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(results: List<Result>)
    fun onFailure(error: Throwable)
}