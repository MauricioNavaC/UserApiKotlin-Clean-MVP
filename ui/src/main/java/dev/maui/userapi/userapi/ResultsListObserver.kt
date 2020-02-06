package dev.maui.userapi.userapi

import android.util.Log
import dev.maui.domain.results.model.Result
import io.reactivex.observers.DisposableSingleObserver

class ResultsListObserver(private val presenter: UserAPIPresenter): DisposableSingleObserver<List<Result>>() {
    private val TAG = ResultsListObserver::class.java.simpleName

    override fun onSuccess(t: List<Result>) {
        presenter.showResultList(t)
    }

    override fun onError(e: Throwable) {
        Log.e(TAG, e.message)
    }

}