package dev.maui.data

import dev.maui.data.results.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint {
  companion object {
    const val apiUserEndpoint = "api/"
  }

  @GET(apiUserEndpoint)
  fun getRandomUser(): Single<User>
}
