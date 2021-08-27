package com.abuzaio.native_ui.di.module

import com.abuzaio.native_ui.data.HomeDatasource
import com.abuzaio.native_ui.presentation.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class HomeModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource
        = retrofit.create(HomeDatasource::class.java)

        @JvmStatic
        @Provides
        fun providesHomeViewModel(
            callback: HomeViewModelCallback,
            datasource: HomeDatasource,
        ): HomeViewModel = HomeViewModel(callback, datasource)
    }

    @Binds
    abstract fun bindHomeViewModelCallback(activity: HomeActivity): HomeViewModelCallback
}