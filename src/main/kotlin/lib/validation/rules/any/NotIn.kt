package lib.validation.rules.any

import lib.validation.rules.Rule

class NotIn<T: Any?>(vararg val others: T): Rule<T> {
    override fun valid(value: T): Boolean = others.contains(value).not()
}