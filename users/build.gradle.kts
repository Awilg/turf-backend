plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "dev.iwagl"
version = "0.0.1"

dependencies {
    implementation(libs.ktor.core)
    testImplementation(libs.ktor.tests)
    testImplementation(libs.kotlin.tests)
}