package com.abuzaio.native_ui.presentation

import androidx.lifecycle.LiveData

interface HomeView {
    val states: LiveData<HomeViewState>

    fun discoverMovie()
}