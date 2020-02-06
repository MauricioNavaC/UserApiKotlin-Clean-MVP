package dev.maui.userapi.userapi.di.component

import dagger.Component
import dev.maui.mvp.di.scope.PerActivity
import dev.maui.userapi.di.component.AppComponent
import dev.maui.userapi.userapi.UserAPIActivity
import dev.maui.userapi.userapi.di.module.ResultsModule

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ResultsModule::class])
interface ResultsComponent {
    fun inject(userAPIActivity: UserAPIActivity)
}