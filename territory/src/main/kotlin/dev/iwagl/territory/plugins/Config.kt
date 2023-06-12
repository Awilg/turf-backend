package dev.iwagl.territory.plugins

import dev.iwagl.territories.models.Claim
import dev.iwagl.territory.data.ClaimDao
import dev.iwagl.territory.data.TerritoryDao
import dev.iwagl.territory.data.models.Territory
import dev.iwagl.territory.service.TerritoryService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

val territoryModule = module {
    // TODO: determine based on env
    // val connectionString = environment.config.propertyOrNull("database.prod.url")?.getString() ?: ""
    val client = KMongo.createClient()
    val database = client.getDatabase("turf")
    val territoryCollection = database.getCollection<Territory>()
    val claimCollection = database.getCollection<Claim>()

    single { TerritoryDao(territoryCollection) }
    single { ClaimDao(claimCollection) }
    single { TerritoryService(get(), get()) }
}