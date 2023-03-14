package main.kotlin.dev.iwagl

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import java.io.File

fun main() {
    println("Hello world!")
    parseGeoJSON(File("geojson-importer/src/main/resources/seattle_neighborhoods.geojson"))
}
//collection: MongoCollection<Document>
fun parseGeoJSON(file: File) {
    val json = file.readText()
    val jojo = Json.parseToJsonElement(json)
    val features = jojo.jsonObject["features"]?.jsonArray

    features?.forEach {
        feature ->
        if (feature.jsonObject["type"].toString() == "\"Feature\"" && feature.jsonObject.containsKey("geometry")) {
            val geos = mutableListOf<List<String>>()
            val geometry = feature.jsonObject["geometry"]
            geometry?.let {
                val polygonCoordinates = mutableListOf<List<String>>()
                if (geometry.jsonObject["type"].toString() == "\"Polygon\"" && geometry.jsonObject.containsKey("coordinates")) {
                    val polyCoords = geometry.jsonObject["coordinates"]?.jsonArray?.get(0)?.jsonArray
                    polyCoords?.forEach { pCord ->
                        val latLng = mutableListOf<String>()
                        latLng.add(pCord.jsonArray[0].toString())
                        latLng.add(pCord.jsonArray[1].toString())
                        polygonCoordinates.add(latLng)
                    }
                }
            }
        }
    }
}