package lib.validation.rules.integer

import lib.validation.rules.Rule
import lib.validation.rules.length

class DigitsBetween(val digitRange: IntRange): Rule<Int> {
    constructor(start: Int, end: Int): this(start..end)
    
    override fun valid(value: Int): Boolean = digitRange.contains(value.length)
}