package com.abuzaio.native_ui

import com.abuzaio.native_ui.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NativeUi : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@NativeUi) }
    }
}