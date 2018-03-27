package lib.validation.rules.string

import lib.validation.rules.Rule
import lib.validation.rules.string.Alpha.ALPHA_REGEX

object AlphaDash: Rule<String> {
    val DASH_REGEX = Regex("[_|-]")
    val REGEX = Regex("${DASH_REGEX.pattern}|${ALPHA_REGEX.pattern}")
    override fun valid(value: String): Boolean = value.all { REGEX.matches(it.toString()) }
}