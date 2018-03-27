package lib.validation.rules.any

import lib.validation.rules.Rule
import lib.validation.rules.size

class Max<T: Any?>(private val size: Int): Rule<T> {
    override fun valid(value: T): Boolean = when(value) {
        null -> false
        else -> value.size <= size
    }
}