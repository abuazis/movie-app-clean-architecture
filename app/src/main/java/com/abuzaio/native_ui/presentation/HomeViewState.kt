package com.abuzaio.native_ui.presentation

import com.abuzaio.native_ui.data.HomeResponse

sealed class HomeViewState {
    object Loading: HomeViewState()

    data class Success(val response: HomeResponse) : HomeViewState()
    data class Error(val error: Throwable) : HomeViewState()
}