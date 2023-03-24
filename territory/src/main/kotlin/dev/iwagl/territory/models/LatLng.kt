package dev.iwagl.territories.models

import kotlinx.serialization.Serializable

@Serializable
data class LatLng(
    val latitude : Double,
    val longitude : Double
)

typealias Latitude = Double
typealias Longitude = Double
