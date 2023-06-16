package dev.iwagl.brokie.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/brokie") {
            call.respondText("Hello World!")
        }
    }
}
