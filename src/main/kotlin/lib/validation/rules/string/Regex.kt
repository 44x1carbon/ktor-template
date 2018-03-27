package lib.validation.rules.string

import lib.validation.rules.Rule
import kotlin.text.Regex

class Regex(private val regex: Regex): Rule<String> {
    override fun valid(value: String): Boolean = regex.matches(value)
}