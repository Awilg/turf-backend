package dev.iwagl.territories.models

import kotlinx.serialization.Serializable

@Serializable
data class Claim(
    val id : String,
    val team: String,
    val expiresAt: Double,
    val createdAt: Double
)