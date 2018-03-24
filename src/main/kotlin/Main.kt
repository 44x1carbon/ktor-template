import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }

        routing {
            get("/") {
                call.respond(FreeMarkerContent("welcome.ftl", mapOf<String, Any>()))
            }
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }
        }

        return@embeddedServer
    }
    server.start(wait = true)
}