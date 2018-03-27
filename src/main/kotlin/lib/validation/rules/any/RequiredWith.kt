package lib.validation.rules.any

import lib.validation.rules.Rule

class RequiredWith<T: Any?>(vararg val others: Any?): Rule<T> {
    override fun valid(value: T): Boolean = others.any { Required.valid(it) } && Required.valid(value)
}