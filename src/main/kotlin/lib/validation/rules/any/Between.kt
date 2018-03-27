package lib.validation.rules.any

import lib.validation.rules.Rule
import lib.validation.rules.size

class Between<T: Any?>(val range: IntRange): Rule<T> {
    override fun valid(value: T): Boolean = when(value) {
        null -> false
        else -> range.contains(value.size)
    }
}