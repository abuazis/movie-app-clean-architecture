package com.abuzaio.native_ui.presentation

import com.abuzaio.native_ui.NetworkProvider
import com.abuzaio.native_ui.data.HomeDatasource
import com.abuzaio.native_ui.data.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView) {
    fun discoverMovie() {
        view.onShowLoading()

        val datasource = NetworkProvider().providesHttpAdapter().create(HomeDatasource::class.java)
        datasource.discoverMovie().enqueue(object: Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onHideLoading()
                view.onResponse(response.body()?.results ?: emptyList())
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }
        })
    }
}