package routing

import core.respondView
import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing

@Location("/") object Welcome
fun Routing.web() {
    get<Welcome> {
        call.respondView("welcome.ftl")
    }
}
