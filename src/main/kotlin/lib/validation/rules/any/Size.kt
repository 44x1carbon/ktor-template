package lib.validation.rules.any

import lib.validation.rules.Rule
import lib.validation.rules.size

class Size<T: Any?>(val size: Int): Rule<T> {
    override fun valid(value: T): Boolean {
        return when(value) {
            null -> false
            else -> value.size == size
        }
    }
}