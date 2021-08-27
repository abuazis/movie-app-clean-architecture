package com.abuzaio.native_ui.di.module

import com.abuzaio.native_ui.data.HomeDatasource
import com.abuzaio.native_ui.presentation.HomeActivity
import com.abuzaio.native_ui.presentation.HomePresenter
import com.abuzaio.native_ui.presentation.HomeView
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
        fun providesHomePresenter(
            view: HomeView,
            datasource: HomeDatasource,
        ): HomePresenter = HomePresenter(view, datasource)
    }

    @Binds
    abstract fun bindHomeView(activity: HomeActivity): HomeView
}