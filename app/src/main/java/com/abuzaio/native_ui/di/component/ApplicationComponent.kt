package com.abuzaio.native_ui.di.component

import com.abuzaio.native_ui.NativeUi
import com.abuzaio.native_ui.di.builder.ActivityBuilder
import com.abuzaio.native_ui.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class,
])

interface ApplicationComponent : AndroidInjector<NativeUi>