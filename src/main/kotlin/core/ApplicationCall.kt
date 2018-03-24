package core

import io.ktor.application.ApplicationCall
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.http.withCharset
import io.ktor.response.respond

suspend fun ApplicationCall.respondView(template: String, model: Any = mapOf<String, Any>(), etag: String? = null, contentType: ContentType = ContentType.Text.Html.withCharset(Charsets.UTF_8))
    = this.respond(FreeMarkerContent(template, model, etag, contentType))