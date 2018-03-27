package lib.validation

import lib.validation.rules.Rule
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

interface Verifiable {
    val rules: Map<String, List<Rule<*>>>

    fun valid() = validateProperties.map {
        val rules: List<Rule<Any?>> = rules.get(it.name)?.map { it as Rule<Any?> } ?: listOf()
        val value: Any? = it.get(this)
        it.name to rules.filter { it.valid(value).not() }.map { it.name }
    }.toMap()

    private val validateProperties: List<KProperty1<Verifiable, Any?>>
        get() = this::class.memberProperties.filter { Verifiable::class.memberProperties.map { it.name }.contains(it.name).not() }.map { it as KProperty1<Verifiable, Any?> }
}