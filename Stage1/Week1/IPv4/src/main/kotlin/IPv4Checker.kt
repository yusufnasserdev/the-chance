package dev.yunas

fun ipv4Checker(ip: String): Boolean {
    val segments = ip.split('.')
    if (segments.size != 4) return false

    for (seg in segments) {
        if (seg.isEmpty()) return false
        if (seg.length > 3) return false

        // Checks for all possible invalid inputs
        seg.forEach {
            if (!it.isDigit()) return false
        }

        // Checks for leading zeros
        if (seg[0] == '0' && seg.length > 1) return false

        // Checks the numeric limits
        val num = seg.toInt()
        if (num < 0 || num > 255) return false
    }

    return true
}