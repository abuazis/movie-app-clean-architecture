package com.abuzaio.native_ui.di.builder

import com.abuzaio.native_ui.di.module.HomeModule
import com.abuzaio.native_ui.di.scope.Presentation
import com.abuzaio.native_ui.presentation.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}