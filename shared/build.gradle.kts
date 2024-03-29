plugins {
    kotlin("plugin.serialization") version "1.8.10"
}

group = "dev.iwagl.shared"
version = "0.0.1"

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.kmongo)
    testImplementation(libs.kotlin.tests)
}