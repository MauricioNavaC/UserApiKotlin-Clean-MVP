package dev.maui.data.results.model

data class Result(val cell: String, val email: String, val location: Location, val name: Name, val picture: Picture)

data class Coordinates(val latitude: String, val longitude: String)

data class Location(val city: String, val coordinates: Coordinates, val country: String, val postcode: Int,
                    val state: String, val street: Street)

data class Name(val first: String, val last: String, val title: String)

data class Picture(val large: String, val medium: String, val thumbnail: String)

data class Street(val name: String, val number: Int)

data class User(val results: List<Result>)