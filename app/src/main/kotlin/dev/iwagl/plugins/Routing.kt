package dev.iwagl.plugins

import dev.iwagl.game.api.routes.registerGameRoutes
import dev.iwagl.territory.api.routes.registerTerritoryRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        registerTerritoryRoutes()
        registerGameRoutes()
    }
}
