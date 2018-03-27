package lib.validation.rules.string

import lib.validation.rules.Rule
import kotlin.text.Regex

class NotRegex(private val regex: Regex): Rule<String> {
    override fun valid(value: String): Boolean = regex.matches(value).not()
}