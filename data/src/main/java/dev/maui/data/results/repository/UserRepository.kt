package dev.maui.data.results.repository

import dev.maui.data.results.model.Result
import dev.maui.data.Endpoint
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(private val endpoint: Endpoint) {
    fun user(): Single<List<Result>> = endpoint.getRandomUser().map {
        it.results
    }
}