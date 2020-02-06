package dev.maui.userapi.userapi

import dev.maui.domain.results.model.Result

interface UserAPIView {
    fun initElements()
    fun showUserData(result: Result)
}