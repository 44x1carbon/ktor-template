package lib.validation.rules.integer

import lib.validation.rules.Rule
import lib.validation.rules.length

class Digits(val digit: Int): Rule<Int> {
    override fun valid(value: Int): Boolean = value.length == digit
}