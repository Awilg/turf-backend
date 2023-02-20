package dev.iwagl.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.registerTerritoryRoutes() {
    healthCheck()

    getTerritoryById()
    getTerritoriesByCity()
    getTerritoriesByLocation()
}

private fun Routing.healthCheck() {
    get("/") {
        call.respond("Test - healthCheck!")
    }
}

private fun Routing.getTerritoryById() {
    get("/territory/{id}") {
        val territoryId = call.parameters["id"]

        call.respond("Test - getTerritoryById for $territoryId")
    }
}

private fun Routing.getTerritoriesByCity() {
    get("/territory/city/{city_id}") {
        val cityId = call.parameters["id"]
        call.respond("Test - getTerritoriesByCity for $cityId")
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

