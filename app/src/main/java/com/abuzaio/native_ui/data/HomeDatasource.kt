package com.abuzaio.native_ui.data

import com.abuzaio.native_ui.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {
    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Single<HomeResponse>
}