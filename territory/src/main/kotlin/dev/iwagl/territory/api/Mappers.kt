package dev.iwagl.territory.api

import dev.iwagl.territories.models.Claim
import dev.iwagl.territory.api.response.ClaimResponse

// function that maps a Claim to a ClaimResponse
fun Claim.toClaimResponse(): ClaimResponse {
    return ClaimResponse(
        territoryId = territoryId,
        playerId = playerId,
        teamId = teamId,
        timestamp = timestamp,
        gameId = gameId
    )
}