package dev.iwagl.brokie

import dev.iwagl.brokie.plugins.configureDependencyInjection
import dev.iwagl.brokie.plugins.configureRouting
import dev.iwagl.brokie.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}
@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.

fun Application.module() {
    configureDependencyInjection()
    configureSerialization()
    configureRouting()
}

