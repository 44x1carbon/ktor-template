package lib.validation.rules.any

import lib.validation.rules.Rule

class In<T: Any?>(vararg val others: T): Rule<T> {
    override fun valid(value: T): Boolean = others.contains(value)
}