package dev.maui.userapi.di.component

import android.content.Context
import dagger.Component
import dev.maui.data.Endpoint
import dev.maui.domain.results.GetUserUseCase
import dev.maui.userapi.App
import dev.maui.userapi.di.module.AppModule
import dev.maui.userapi.di.module.IOModule
import dev.maui.userapi.di.module.RepositoryModule
import dev.maui.userapi.di.module.UseCaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
  fun inject(app: App)
  fun getApplicationContext(): Context
  fun getEndpoint(): Endpoint
  fun getResultsListUseCase(): GetUserUseCase
}
