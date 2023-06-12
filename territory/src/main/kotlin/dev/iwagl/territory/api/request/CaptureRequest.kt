package dev.iwagl.territory.api.request

import kotlinx.serialization.Serializable

@Serializable
data class ClaimRequest(
    val territoryId: String,
    val playerId: String,
    val teamId: String,
    val timestamp: Long,
    val gameId: String)