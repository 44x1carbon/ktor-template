package routing

import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing

@Location("/") object Welcome
fun Routing.web() {
    get<Welcome> {
    }
}
