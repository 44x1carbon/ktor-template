package lib.validation.rules

val Any.size get() =  when(this) {
    is String -> this.toString().length
    is Int -> this.toInt()
    is Double -> this.toInt()
    is Float -> this.toInt()
    is Iterable<*> -> this.toList().size
    else -> throw NotSupportClass
}

val Int.length: Int
    get() = when(this) {
        0 -> 1
        else -> Math.log10(Math.abs(toDouble())).toInt() + 1
    }