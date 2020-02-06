package dev.maui.data.results.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    @Expose
    val first: String,
    @SerializedName("last")
    @Expose
    val last: String,
    @SerializedName("title")
    @Expose
    val title: String
)