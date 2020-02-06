package dev.maui.data.results.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import dev.maui.data.results.model.*

data class Result(
    @SerializedName("cell")
    @Expose
    val cell: String,
    @SerializedName("dob")
    @Expose
    val dob: Dob,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("id")
    @Expose
    val id: Id,
    @SerializedName("location")
    @Expose
    val location: Location,
    @SerializedName("name")
    @Expose
    val name: Name,
    @SerializedName("phone")
    @Expose
    val phone: String,
    @SerializedName("picture")
    @Expose
    val picture: Picture
)