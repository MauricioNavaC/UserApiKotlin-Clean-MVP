package dev.maui.domain.results.model

import dev.maui.data.results.model.Location
import dev.maui.data.results.model.Name
import dev.maui.data.results.model.Picture

data class Result(var cell: String? = null, var email: String? = null, var location: Location? = null,
                  var name: Name? = null, var picture: Picture? = null)
