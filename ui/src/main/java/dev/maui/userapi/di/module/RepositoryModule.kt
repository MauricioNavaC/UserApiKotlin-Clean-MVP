package dev.maui.userapi.di.module

import dagger.Module
import dagger.Provides
import dev.maui.data.Endpoint
import dev.maui.data.results.repository.UserRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideResultsRepository(endpoint: Endpoint): UserRepository = UserRepository(endpoint)
}