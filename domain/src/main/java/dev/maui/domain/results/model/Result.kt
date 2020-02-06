package dev.maui.domain.results.model

import dev.maui.data.results.model.*

data class Result(
    var cell: String? = null,
    var dob: Dob? = null,
    var email: String? = null,
    var id: Id? = null,
    var location: Location? = null,
    var name: Name? = null,
    var phone: String? = null,
    var picture: Picture? = null
)
