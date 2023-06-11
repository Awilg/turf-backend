package dev.iwagl.territories.models

import dev.iwagl.models.LatLng
import kotlinx.serialization.Serializable

@Serializable
data class Territory(
    val id: String,
    val name: String,
    val boundaries: List<List<LatLng>>,
    val tier: Tier,
    val features: List<Features>,
    val simplifiedBoundaries: List<List<LatLng>>? = null
)
