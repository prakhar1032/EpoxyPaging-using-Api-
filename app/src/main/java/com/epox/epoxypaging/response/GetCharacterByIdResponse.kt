package com.epox.epoxypaging.response

import com.epox.epoxypaging.Location
import com.epox.epoxypaging.Origin

data class GetCharacterByIdResponse(
    var created: String,
    var episode: List<String>,
    var gender: String,
    var id: Int,
    var image: String,
    var location: Location,
    var name: String,
    var origin: Origin,
    var species: String,
    var status: String,
    var type: String,
    var url: String
)