package dev.maui.domain.results

import dev.maui.data.results.repository.UserRepository
import dev.maui.domain.results.model.Result
import dev.maui.domain.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository, subscribeScheduler: Scheduler,
    postExecutionScheduler: Scheduler): UseCase<List<Result>, Unit>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Unit?): Single<List<Result>> = userRepository.user().map { it ->
        it.map { Result(it.cell, it.email, it.location, it.name, it.picture) }
    }

}