package com.abuzaio.native_ui.di.module

import androidx.lifecycle.ViewModel
import com.abuzaio.native_ui.data.HomeDatasource
import com.abuzaio.native_ui.di.scope.ViewModelkKey
import com.abuzaio.native_ui.presentation.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class HomeModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource
        = retrofit.create(HomeDatasource::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelkKey(HomeViewModel::class)
    abstract fun bindHomeViewModelCallback(viewModel: HomeViewModel): ViewModel
}