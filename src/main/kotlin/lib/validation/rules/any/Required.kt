package lib.validation.rules.any

import lib.validation.rules.NotSupportClass
import lib.validation.rules.Rule

object Required: Rule<Any?> {
    override fun valid(value: Any?): Boolean {
        return when(value) {
            null -> false
            is String -> value != ""
            is Iterable<*> -> value.toList().isEmpty().not()
            else -> throw NotSupportClass
        }
    }
}