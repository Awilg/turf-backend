package dev.iwagl.routes

import dev.iwagl.territory.data.TerritoryDao
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.registerTerritoryRoutes() {
    healthCheck()

    getTerritoryById()
    getTerritoriesByCity()
    ListTerritories()
}

private fun Routing.healthCheck() {
    get("/territory") {
        call.respond("Test - healthCheck!")
    }
}

private fun Routing.getTerritoryById() {
    val territoryDao by inject<TerritoryDao>()

    get("/territory/{id}") {
        val territoryId = call.parameters["id"]

        val t = territoryDao.load(territoryId!!)
        call.respond("Test - getTerritoryById for $territoryId: $t")
    }
}

private fun Routing.getTerritoriesByCity() {
    get("/territory/city/{city_id}") {
        val cityId = call.parameters["id"]
        call.respond("Test - getTerritoriesByCity for $cityId")
    }
}

private fun Routing.ListTerritories() {
    val territoryDao by inject<TerritoryDao>()

    get("/territory/list") {
        val territories = territoryDao.loadAll()
        call.respond(territories)
    }
}

private fun Routing.getTerritoriesByLocation() {
    get("/") {
        call.respond("Test - getTerritoriesByLocation!")

//            val request = call.receive<LooByLocRequest>()
//            val filterParams: List<String>? = call.request.queryParameters.getAll("filter")
//
//            val results = looRepository.findByLocation(
//                request.latitude,
//                request.longitude,
//                request.minDistance,
//                request.maxDistance,
//                filterParams
//            ).map { loo -> loo.toInfo() }
//
//            call.respond(results)
    }
}

