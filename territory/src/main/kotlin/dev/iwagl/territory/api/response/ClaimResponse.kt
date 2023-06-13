package dev.iwagl.territory.api.response

import kotlinx.serialization.Serializable

@Serializable
data class ClaimResponse(
    val territoryId: String,
    val playerId: String,
    val teamId: String,
    val timestamp: Long,
    val gameId: String)