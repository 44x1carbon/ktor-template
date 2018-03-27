package lib.validation.rules.any

import lib.validation.rules.Rule

class RequiredIf<T: Any?>(private val other: T, private val value: T): Rule<T> {
    override fun valid(value: T): Boolean {
        if (other != this.value) return true
        return Required.valid(value)
    }
}