package com.abuzaio.native_ui.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.abuzaio.native_ui.BR
import com.abuzaio.native_ui.data.HomeDatasource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomeViewModel(
    private val callback: HomeViewModelCallback,
    private val datasource: HomeDatasource,
): BaseObservable(), HomeView {
    var progressBarVisibility: Int = View.GONE
        @Bindable get

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun discoverMovie() {
        progressBarVisibility = View.VISIBLE
        notifyPropertyChanged(BR.progressBarVisibility)

        datasource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onSuccess(response.results)
            }, { error ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onError(error)
            })
            .addTo(disposable)
    }

    override fun onDetach() {
        disposable.clear()
    }
}