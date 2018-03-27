package lib.validation.rules

interface Rule<Target: Any?> {
    val name: String get() = this::class.simpleName ?: throw Throwable("")
    fun valid(value: Target): Boolean
}

object NotSupportClass: Throwable("not support class")