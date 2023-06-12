package dev.iwagl.territory.service

import dev.iwagl.territories.models.Claim
import dev.iwagl.territory.api.request.ClaimRequest
import dev.iwagl.territory.data.TerritoryDao

class TerritoryService(
    private val territoryDao: TerritoryDao
) {

    /**
     * Creates a claim object for a territory.
     */
    fun claimTerritory(request: ClaimRequest) : Claim {
        return Claim(
            territoryId = request.territoryId,
            playerId = request.playerId,
            teamId = request.teamId,
            timestamp = request.timestamp,
            gameId = request.gameId
        )
    }
}