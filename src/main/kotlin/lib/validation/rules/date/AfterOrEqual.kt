package lib.validation.rules.date

import lib.validation.rules.Rule
import java.util.*

class AfterOrEqual(val other: Date): Rule<Date> {
    override fun valid(value: Date): Boolean = value.after(other) || value == other
}