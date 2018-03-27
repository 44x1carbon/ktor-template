package lib.validation.rules.string

import lib.validation.rules.Rule

object Alpha: Rule<String> {
    val ALPHA_REGEX = Regex("[A-z]")
    override fun valid(value: String): Boolean = value.all { ALPHA_REGEX.matches(it.toString()) }
}