package dev.maui.data.results.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("coordinates")
    @Expose
    val coordinates: Coordinates,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("postcode")
    @Expose
    val postcode: Int,
    @SerializedName("state")
    @Expose
    val state: String,
    @SerializedName("street")
    @Expose
    val street: Street
)