plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "dev.iwagl.territory"
version = "0.0.1"

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.kmongo)
    testImplementation(libs.kotlin.tests)
}