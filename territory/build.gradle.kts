group = "dev.iwagl.territory"
version = "0.0.1"

plugins {
    kotlin("plugin.serialization") version "1.8.10"
}

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.ktor.cacheheaders)
    implementation(libs.kmongo)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)
    implementation(project(mapOf("path" to ":shared")))
    testImplementation(libs.kotlin.tests)
}