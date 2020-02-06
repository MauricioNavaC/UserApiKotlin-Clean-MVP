package dev.maui.userapi.di.module

import dagger.Module
import dagger.Provides
import dev.maui.data.results.repository.UserRepository
import dev.maui.domain.results.GetUserUseCase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
  @Provides
  @Singleton
  @Named("ioScheduler")
  internal fun provideIoScheduler() = Schedulers.io()

  @Provides
  @Singleton
  @Named("mainThreadScheduler")
  internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()

  @Provides
  @Singleton
  internal fun provideGetUsersListUseCase(userRepository: UserRepository, @Named("ioScheduler") ioScheduler: Scheduler, @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetUserUseCase =
    GetUserUseCase(userRepository, ioScheduler, mainThreadScheduler)
}
