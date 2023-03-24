package dev.iwagl.plugins

import dev.iwagl.territories.models.Territory
import dev.iwagl.territory.data.TerritoryDao
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

val territoryModule = module {
    val client = KMongo.createClient()
    val database = client.getDatabase("turf")
    val territoryCollection = database.getCollection<Territory>()

    single { TerritoryDao(territoryCollection) }
}

fun Application.configureDependencyInjection() {
    install(Koin) {
        slf4jLogger()
        modules(territoryModule)
    }
}
