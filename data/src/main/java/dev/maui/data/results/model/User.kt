package dev.maui.data.results.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import dev.maui.data.results.model.Result

data class User(
    @SerializedName("results")
    @Expose
    val results: List<Result>
)