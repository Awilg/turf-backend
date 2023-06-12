package dev.iwagl.territory.plugins

import dev.iwagl.territory.data.TerritoryDao
import dev.iwagl.territory.data.models.Territory
import dev.iwagl.territory.service.TerritoryService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

val territoryModule = module {
    // Singleton ComponentA
    // TODO: determine based on env
    // val connectionString = environment.config.propertyOrNull("database.prod.url")?.getString() ?: ""
    val client = KMongo.createClient()
    val database = client.getDatabase("turf")
    val territoryCollection = database.getCollection<Territory>()

    single { TerritoryDao(territoryCollection) }
    single { TerritoryService(get()) }
}