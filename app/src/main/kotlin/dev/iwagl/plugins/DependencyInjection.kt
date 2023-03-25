package dev.iwagl.plugins

import dev.iwagl.territories.models.Territory
import dev.iwagl.territory.data.TerritoryDao
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection


fun Application.configureDependencyInjection() {
    val territoryModule = module {
        // TODO: determine based on env
        val connectionString = environment.config.propertyOrNull("database.prod.url")?.getString() ?: ""
        val client = KMongo.createClient(connectionString.trim('"'))
        val database = client.getDatabase("turf")
        val territoryCollection = database.getCollection<Territory>()

        single { TerritoryDao(territoryCollection) }
    }

    install(Koin) {
        slf4jLogger()
        modules(territoryModule)
    }
}
