plugins {
    kotlin("plugin.serialization") version "1.8.10"
}

group = "dev.iwagl.geojsonimporter"
version = "0.0.1"

dependencies {
    implementation(project(":territory"))
    implementation(project(":shared"))

    implementation(libs.ktor.core)
    implementation(libs.kmongo)
    testImplementation(libs.kotlin.tests)
}