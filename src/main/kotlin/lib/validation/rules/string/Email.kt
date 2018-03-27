package lib.validation.rules.string

import lib.validation.rules.Rule

object Email: Rule<String> {
    val EMAIL_REGEX = Regex("^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\$")
    override fun valid(value: String): Boolean = Regex(EMAIL_REGEX).valid(value)
}