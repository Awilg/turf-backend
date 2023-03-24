package main.kotlin.dev.iwagl

import dev.iwagl.territories.models.Features
import dev.iwagl.territories.models.LatLng
import dev.iwagl.territories.models.Territory
import dev.iwagl.territories.models.Tier
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.io.File

fun main() {
    println("Hello world!")

    parseGeoJSON(File("geojson-importer/src/main/resources/seattle_neighborhoods.geojson"))

    println("Success!")
}
//collection: MongoCollection<Document>
fun parseGeoJSON(file: File) {
    val json = file.readText()
    val jojo = Json.parseToJsonElement(json)

    // Create a client to a MongoDB server running on localhost on port 27017
    val client = KMongo.createClient()
    val database = client.getDatabase("turf")
    val col = database.getCollection<Territory>()

    val features = jojo.jsonObject["features"]?.jsonArray

    features?.forEach {
        feature ->
        if (feature.jsonObject["type"].toString() == "\"Feature\"" && feature.jsonObject.containsKey("geometry")) {
            val geos = mutableListOf<List<String>>()
            val geometry = feature.jsonObject["geometry"]
            val polygonCoordinates = mutableListOf<LatLng>()
            geometry?.let {
                if (geometry.jsonObject["type"].toString() == "\"Polygon\"" && geometry.jsonObject.containsKey("coordinates")) {
                    val polyCoords = geometry.jsonObject["coordinates"]?.jsonArray?.get(0)?.jsonArray
                    polyCoords?.forEach { pCord ->
                        val latty = LatLng(
                            pCord.jsonArray[1].toString().toDouble(),
                            pCord.jsonArray[0].toString().toDouble()
                        )
                        polygonCoordinates.add(latty)
                    }
                }
            }

            val territory = Territory(
                "sea_" + feature.jsonObject["properties"]!!.jsonObject["OBJECTID"].toString(),
                feature.jsonObject["properties"]!!.jsonObject["S_HOOD"].toString().trim('"'),
                polygonCoordinates,
                Tier.Common,
                listOf(Features.Normal)
            )

            // print out the territory
            println(territory)

            //async now
            col.insertOne(territory)
        }
    }
}