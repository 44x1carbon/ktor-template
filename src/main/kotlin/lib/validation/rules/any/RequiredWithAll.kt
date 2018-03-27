package lib.validation.rules.any

import lib.validation.rules.Rule

class RequiredWithAll<T: Any?>(vararg val others: Any?): Rule<T> {
    override fun valid(value: T): Boolean = others.all { Required.valid(it) } && Required.valid(value)
}