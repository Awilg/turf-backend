group = "dev.iwagl.territory"
version = "0.0.1"

plugins {
    kotlin("plugin.serialization") version "1.8.10"
}

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.kmongo)
    testImplementation(libs.kotlin.tests)
}