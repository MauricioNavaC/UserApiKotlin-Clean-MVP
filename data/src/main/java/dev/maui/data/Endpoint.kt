package dev.maui.data

import dev.maui.data.results.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint {
  @GET("api/")
  fun getRandomUser(): Single<User>
}
