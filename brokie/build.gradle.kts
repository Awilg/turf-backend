plugins {
    id("io.ktor.plugin") version "2.2.4"
    application
}

group = "dev.iwagl"
version = "0.0.1"

ktor {
    fatJar {
        archiveFileName.set("brokie-app.jar")
    }
}

application {
    mainClass.set("dev.iwagl.ApplicationKt")

    applicationName = "brokie-app"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(libs.ktor.core)
    implementation(libs.ktor.server)
    implementation(libs.ktor.contentnegotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.logback.classic)

    implementation(libs.kmongo)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)

    testImplementation(libs.ktor.tests)
    testImplementation(libs.kotlin.tests)
}