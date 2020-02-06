package dev.maui.userapi

import android.app.Application
import dev.maui.userapi.di.component.AppComponent
import dev.maui.userapi.di.component.DaggerAppComponent
import dev.maui.userapi.di.module.AppModule

class App : Application() {
  val applicationComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
      .appModule(AppModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    initInjector()
  }

  private fun initInjector() {
    applicationComponent.inject(this)
  }
}
