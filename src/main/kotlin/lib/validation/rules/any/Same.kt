package lib.validation.rules.any

import lib.validation.rules.Rule

class Same<T: Any?>(val other: T): Rule<T> {
    override fun valid(value: T): Boolean = value == other
}