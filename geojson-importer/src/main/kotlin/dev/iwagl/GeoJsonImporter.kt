package main.kotlin.dev.iwagl

import dev.iwagl.models.LatLng
import dev.iwagl.territories.models.Features
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
    val client = KMongo.createClient("mongodb+srv://admin:B8KuFSKr3NKOzpiM@dev.u9ivllf.mongodb.net/?retryWrites=true&w=majority")
    val database = client.getDatabase("turf")
    val col = database.getCollection<Territory>()

    val features = jojo.jsonObject["features"]?.jsonArray

    features?.forEach {
        feature ->
        if (feature.jsonObject["type"].toString() == "\"Feature\"" && feature.jsonObject.containsKey("geometry")) {
            val geometry = feature.jsonObject["geometry"]
            val polygons = mutableListOf<List<LatLng>>()
            geometry?.let {

                val isMultiPolygon = geometry.jsonObject["type"].toString() == "\"MultiPolygon\""
                val isPolygon = geometry.jsonObject["type"].toString() == "\"Polygon\""
                if ((isMultiPolygon || isPolygon)  && geometry.jsonObject.containsKey("coordinates")) {

                    val polys = geometry.jsonObject["coordinates"]?.jsonArray

                    polys?.forEach {
                        val polygonCoordinates = mutableListOf<LatLng>()

                        val polyCoords = if (isMultiPolygon) it.jsonArray[0].jsonArray else it.jsonArray
                        polyCoords.forEach { pCord ->
                            val latty = LatLng(
                                pCord.jsonArray[1].toString().toDouble(),
                                pCord.jsonArray[0].toString().toDouble()
                            )
                            polygonCoordinates.add(latty)
                        }

                        polygons.add(polygonCoordinates)
                    }
                }
            }

            val territory = Territory(
                id = "sea_" + feature.jsonObject["properties"]!!.jsonObject["OBJECTID"].toString(),
                name = feature.jsonObject["properties"]!!.jsonObject["S_HOOD"].toString().trim('"'),
                boundaries = polygons,
                tier = Tier.Common,
                features = listOf(Features.Normal)
            )

            //async now
            col.insertOne(territory)
        }
    }
}
