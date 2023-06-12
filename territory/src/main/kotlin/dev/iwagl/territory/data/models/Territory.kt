package dev.iwagl.territory.data.models

import dev.iwagl.models.LatLng
import dev.iwagl.territories.models.Features
import dev.iwagl.territories.models.Tier
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
