package com.abuzaio.native_ui.di.builder

import androidx.lifecycle.ViewModelProvider
import com.abuzaio.native_ui.di.factory.ViewModelFactory
import com.abuzaio.native_ui.di.module.HomeModule
import com.abuzaio.native_ui.di.scope.Presentation
import com.abuzaio.native_ui.presentation.HomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}