package dev.maui.userapi.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.maui.data.Endpoint
import dev.maui.userapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class IOModule {
  private val endpoint: Endpoint

  init {
    val loggin = HttpLoggingInterceptor()
    val okHttpBuilder = OkHttpClient.Builder()

    loggin.level = HttpLoggingInterceptor.Level.BODY

    okHttpBuilder.addInterceptor(loggin)

    okHttpBuilder.addInterceptor { chain ->
      println(chain.request())
      chain.proceed(chain.request())
    }

    val okHttpClient = okHttpBuilder.build()

    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .baseUrl(BuildConfig.ENDPOINT)
      .client(okHttpClient)
      .build()

    endpoint = retrofit.create(Endpoint::class.java)
  }

  @Provides
  @Singleton
  internal fun provideEndpoint(): Endpoint = endpoint
}