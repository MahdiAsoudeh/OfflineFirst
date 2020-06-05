package com.mahdi20.offlinefirst

import com.mahdi20.offlinefirst.ui.screens.main.MainActivityModule
import com.mahdi20.offlinefirst.utility.di.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelBuilder::class,
        MainActivityModule::class]
)

interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()
}