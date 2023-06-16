package dev.iwagl.game.api.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.registerGameRoutes() {
    healthCheck()
    getGameById()
}

private fun Routing.healthCheck() {
    get("/game") {
        call.respond("Test - healthCheck!")
    }
}

private fun Routing.getGameById() {
    get("/game/{id}") {
        val territoryId = call.parameters["id"]

        call.respond("Test - getTerritoryById for $territoryId")
    }
}