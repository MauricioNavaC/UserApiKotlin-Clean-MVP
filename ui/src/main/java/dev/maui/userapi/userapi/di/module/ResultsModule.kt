package dev.maui.userapi.userapi.di.module

import dagger.Module
import dagger.Provides
import dev.maui.domain.results.GetUserUseCase
import dev.maui.mvp.di.scope.PerActivity
import dev.maui.userapi.userapi.UserAPIPresenter

@Module
class ResultsModule {
    @PerActivity
    @Provides
    internal fun provideUserAPIPresenter(getUserUseCase: GetUserUseCase) = UserAPIPresenter(getUserUseCase)
}