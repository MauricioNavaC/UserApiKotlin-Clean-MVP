package dev.maui.userapi.userapi

import dev.maui.domain.results.GetUserUseCase
import dev.maui.mvp.BasePresenter
import dev.maui.domain.results.model.Result
import javax.inject.Inject

class UserAPIPresenter @Inject constructor(private val getUserUseCase: GetUserUseCase): BasePresenter<UserAPIView>() {
    override fun initialise() {
        getView()?.initElements()
        getUserUseCase.execute(ResultsListObserver(this))
    }

    override fun disposeSubscriptions() {
        getUserUseCase.dispose()
    }

    fun showResultList(resultList: List<Result>) {
        getView()?.showUserData(resultList[0])
    }
}