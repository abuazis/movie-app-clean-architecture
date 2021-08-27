package com.abuzaio.native_ui.presentation

import com.abuzaio.native_ui.data.HomeDatasource
import com.abuzaio.native_ui.data.HomeResponse
import com.abuzaio.native_ui.di.module.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView, private val datasource: HomeDatasource) {
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun discoverMovie() {
        view.onShowLoading()

        datasource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.onHideLoading()
                view.onResponse(response.results)
            }, { error ->
                view.onHideLoading()
                view.onFailure(error)
            })
            .addTo(disposable)
    }

    fun onDetach() {
        disposable.clear()
    }
}