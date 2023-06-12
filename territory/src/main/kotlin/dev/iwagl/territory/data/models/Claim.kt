package dev.iwagl.territories.models

import kotlinx.serialization.Serializable

@Serializable
data class Claim(
    val territoryId: String,
    val playerId: String,
    val teamId: String,
    val timestamp: Long,
    val gameId: String)