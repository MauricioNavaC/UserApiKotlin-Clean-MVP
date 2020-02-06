package dev.maui.data.results.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("value")
    @Expose
    val value: String
)