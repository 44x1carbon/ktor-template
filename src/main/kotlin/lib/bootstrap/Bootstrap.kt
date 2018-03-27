package lib.bootstrap

import io.ktor.application.Application
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.http.Parameters
import io.ktor.locations.Locations
import io.ktor.request.ContentTransformationException
import io.ktor.request.receive
import io.ktor.routing.Routing
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.transactions.transaction
import routing.web
import java.io.File
import java.sql.Connection

fun Application.bootstrap() {
    databaseSetup()
    install(Locations)
    install(Routing) {
        web()
    }
}