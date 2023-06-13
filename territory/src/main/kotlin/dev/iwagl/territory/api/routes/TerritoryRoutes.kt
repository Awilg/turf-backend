package dev.iwagl.territory.api.routes

import dev.iwagl.territory.api.request.ClaimRequest
import dev.iwagl.territory.api.toClaimResponse
import dev.iwagl.territory.data.ClaimDao
import dev.iwagl.territory.data.TerritoryDao
import dev.iwagl.territory.service.TerritoryService
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.registerTerritoryRoutes() {
    install(CachingHeaders) {
        options { call, content -> CachingOptions(CacheControl.NoCache(CacheControl.Visibility.Private)) }
    }
    healthCheck()

    //getTerritoryById()
    getTerritoriesByCity()
    captureTerritory()
    listTerritories()
    listClaims()
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

private fun Routing.listTerritories() {
    val territoryDao by inject<TerritoryDao>()

    get("/territory/list") {
        val territories = territoryDao.loadAll()
        call.respond(territories)
    }
}

private fun Routing.captureTerritory() {
    val territoryService by inject<TerritoryService>()

    post("/territory/claim") {
        val request = call.receive<ClaimRequest>()
        val claim = territoryService.claimTerritory(request)

        call.respond(claim.toClaimResponse())
    }
}

private fun Routing.listClaims() {
    val claimDao by inject<ClaimDao>()

    get("/territory/claim/list") {
        val claims = claimDao.loadAll()
        call.respond(claims)
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

