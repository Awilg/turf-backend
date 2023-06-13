rootProject.name = "turf"

include("app")
include("users")
include("territory")
include("geojson-importer")
include("migrations")
include("shared")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("ktor-core", "io.ktor:ktor-server-core-jvm:2.2.2")
            library("ktor-cacheheaders", "io.ktor:ktor-server-caching-headers:2.2.2")
            library("ktor-contentnegotiation", "io.ktor:ktor-server-content-negotiation-jvm:2.2.2")
            library("ktor-serialization", "io.ktor:ktor-serialization-kotlinx-json-jvm:2.2.2")
            library("ktor-server", "io.ktor:ktor-server-netty-jvm:2.2.2")
            library("ktor-tests",  "io.ktor:ktor-server-tests-jvm:2.2.2")

            library("kmongo", "org.litote.kmongo:kmongo:4.8.0")

            library("koin-logger", "io.insert-koin:koin-logger-slf4j:3.3.0")
            library("koin-core", "io.insert-koin:koin-core:3.3.3")
            library("koin-ktor", "io.insert-koin:koin-ktor:3.3.1")

            library("logback-classic", "ch.qos.logback:logback-classic:1.2.11")
            library("kotlin-tests",  "org.jetbrains.kotlin:kotlin-test-junit:1.8.0")
            library("kotlin-serialization", "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
        }
    }
}