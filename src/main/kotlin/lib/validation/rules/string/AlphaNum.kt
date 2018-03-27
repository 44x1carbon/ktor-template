package lib.validation.rules.string

import lib.validation.rules.Rule

object AlphaNum: Rule<String> {
    val NUM_REGEX = Regex("[0-9]")
    val REGEX = Regex("${NUM_REGEX.pattern}|${Alpha.ALPHA_REGEX.pattern}")
    override fun valid(value: String): Boolean = value.all { REGEX.matches(it.toString()) }
}