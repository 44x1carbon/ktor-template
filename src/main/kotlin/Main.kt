import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.*
import io.ktor.routing.routing
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        }
        install(Locations)

        @Location("/") data class Welcome(val p: Int? = null)

        routing {
            get<Welcome> {
                call.respond(FreeMarkerContent("welcome.ftl", mapOf<String, Any>()))
            }
        }

        return@embeddedServer
    }
    server.start(wait = true)
}