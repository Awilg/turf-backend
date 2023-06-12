package dev.iwagl.territory.service

import dev.iwagl.territories.models.Claim
import dev.iwagl.territory.api.request.ClaimRequest
import dev.iwagl.territory.data.ClaimDao
import dev.iwagl.territory.data.TerritoryDao
import io.ktor.util.date.*

class TerritoryService(
    private val territoryDao: TerritoryDao,
    private val claimDao: ClaimDao
) {
    /**
     * Creates a claim object for a territory.
     */
    fun claimTerritory(request: ClaimRequest) : Claim {

        // TODO:
        // 1. Ensure territory exists and is not already captured
        // 2. Ensure player exists, team, and game are correct

        val claim = Claim(
            territoryId = request.territoryId,
            playerId = request.playerId,
            teamId = request.teamId,
            timestamp = getTimeMillis(),
            gameId = request.gameId
        )

        claimDao.save(claim)

        return claim
    }
}