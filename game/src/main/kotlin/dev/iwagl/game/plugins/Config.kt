package dev.iwagl.game.plugins

import org.koin.dsl.module
import org.litote.kmongo.KMongo

val gameModule = module {
    // TODO: determine based on env
    // val connectionString = environment.config.propertyOrNull("database.prod.url")?.getString() ?: ""
    val connectionString = System.getenv("DATABASE_URL")
    val client = KMongo.createClient(connectionString)
    val database = client.getDatabase("turf")

//    val territoryCollection = database.getCollection<Game>()
//
//    single { TerritoryDao(territoryCollection) }
//    single { ClaimDao(claimCollection) }
//    single { TerritoryService(get(), get()) }
}