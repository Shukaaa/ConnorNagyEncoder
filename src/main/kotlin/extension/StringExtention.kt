package rip.shuka.extension

fun String.toBinary(): String {
    return this
        .toCharArray()
        .joinToString("") {
            String.format("%8s", Integer.toBinaryString(it.toInt())).replace(' ', '0')
        }
}

fun String.binaryAsciiToText(): String {
    return this
        .chunked(8)
        .map { it.toInt(2).toChar() }
        .joinToString("")
}