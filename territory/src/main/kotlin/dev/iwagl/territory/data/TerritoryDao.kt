package dev.iwagl.territory.data

import com.mongodb.client.MongoCollection
import dev.iwagl.territory.data.models.Territory

class TerritoryDao(private val collection: MongoCollection<Territory>) : BaseDao<Territory>(collection) {
    fun loadAll(): List<Territory> {
        return collection.find().toList()
    }
}