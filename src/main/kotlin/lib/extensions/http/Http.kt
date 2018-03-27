package lib.extensions.http

import io.ktor.http.Parameters
import io.ktor.util.ConversionService
import io.ktor.util.DefaultConversionService
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.javaType

inline fun <reified T: Any?> Parameters.to(): T {
    val klass: KClass<*> = T::class
    val constructor = klass.primaryConstructor ?: klass.constructors.single()
    val arguments = constructor.parameters.map { parameter ->
        val type = parameter.type
        val name = parameter.name!!
        val value = conversionValue(name, type.javaType)
        parameter to value
    }.filterNot { it.first.isOptional && it.second == null }.toMap()

    return constructor.callBy(arguments) as T
}

fun Parameters.conversionValue(name: String, type: Type, conversionService: ConversionService = DefaultConversionService): Any?{
    val values = getAll(name)
    return values?.let { conversionService.fromValues(values, type) }
}