package com.abuzaio.native_ui.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.abuzaio.native_ui.data.Result

class HomeAdapterViewModel(result: Result): BaseObservable() {
    val title: String = result.title
        @Bindable get

    val overview = result.overview
        @Bindable get
}