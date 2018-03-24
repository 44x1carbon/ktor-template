import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.transactions.transaction
import routing.web
import java.io.File
import java.sql.Connection

fun main(args: Array<String>) {
    Database.connect("jdbc:sqlite:${File("src/resources/database.sqlite").absolutePath}", "org.sqlite.JDBC")
    transaction(transactionIsolation = Connection.TRANSACTION_SERIALIZABLE, repetitionAttempts = 3) {
        logger.addLogger(StdOutSqlLogger)
    }

    val server = embeddedServer(Netty, port = 8080) {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }
        install(Locations)
        install(Routing) {
            web()
        }

        return@embeddedServer
    }
    server.start(wait = true)
}