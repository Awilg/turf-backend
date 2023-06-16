package dev.iwagl.territory.data

import com.mongodb.client.MongoCollection
import dev.iwagl.territory.data.models.Claim
import org.litote.kmongo.eq
import org.litote.kmongo.find

class ClaimDao(private val collection: MongoCollection<Claim>) : BaseDao<Claim>(collection) {
    fun loadAll(): List<Claim> {
        return collection.find().toList()
    }
    fun loadByTerritoryId(territoryId: String): List<Claim> {
        return collection.find(Claim::territoryId eq territoryId).toList()
    }

    fun loadByTerritoryIdAndGameId(territoryId: String, gameId: String): List<Claim> {
        return collection.find(Claim::territoryId eq territoryId, Claim::gameId eq gameId).toList()
    }
}