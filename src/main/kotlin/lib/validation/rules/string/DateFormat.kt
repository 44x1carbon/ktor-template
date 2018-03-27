package lib.validation.rules.string

import lib.validation.rules.Rule
import java.text.ParseException
import java.text.SimpleDateFormat

class DateFormat(val format: String): Rule<String> {
    override fun valid(value: String): Boolean {
        try {
            SimpleDateFormat(format).parse(value)
            return true
        } catch (e: ParseException) {
            return false
        }
    }
}