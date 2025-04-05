package dev.yunas

fun main() {
    check(
        name = "Should return false, When Valid IPv4 Address (basic case)",
        result = ipv4Checker("192.168.1.1"),
        correctResult = true
    )

    check(
        name = "Should return true, When Valid IPv4 Address (corner case) conflicts with leading zeros",
        result = ipv4Checker("0.0.0.0"),
        correctResult = true
    )

    check(
        name = "Should return false, When empty string",
        result = ipv4Checker(""),
        correctResult = false
    )

    check(
        name = "Should return false, When incorrect number of segments",
        result = ipv4Checker("192.168.1.1.1"),
        correctResult = false
    )

    check(
        name = "Should return false, When a Non-numeric character is included",
        result = ipv4Checker("192.168.a.1"),
        correctResult = false
    )

    check(
        name = "Should return false, When a segment is out of range (More than 255)",
        result = ipv4Checker("256.100.100.100"),
        correctResult = false
    )

    check(
        name = "Should return false, When a segment is out of range (Less than 0)",
        result = ipv4Checker("256.-100.100.100"),
        correctResult = false
    )

    check(
        name = "Should return false, When a segment has leading zeros",
        result = ipv4Checker("192.168.01.1"),
        correctResult = false
    )

    check(
        name = "Should return false, When a segment has whitespaces",
        result = ipv4Checker("192. 168.1.1"),
        correctResult = false
    )

    check(
        name = "Should return false, When segments are separated with something other than dots",
        result = ipv4Checker("192:168:1:4"),
        correctResult = false
    )

}

fun check(
    name: String,
    result: Boolean,
    correctResult: Boolean
) {
    if (result == correctResult) {
        println("\uD83D\uDFE9 Success - $name")
    } else {
        println("\uD83D\uDFE5 Failed - $name")
    }
}