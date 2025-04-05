package dev.yunas

fun main() {

    check(
        name = "Should return true When valid sudoku (basic case)",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '1', '2'),
                listOf('2', '3', '1')
            )
        ),
        correctResult = true,
    )

    check(
        name = "Should return false When number of rows doesn't equal number of columns",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '1', '2'),
                listOf('2', '3', '1'),
                listOf('-', '-', '-')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When number of rows aren't similar",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '1', '2', '-'),
                listOf('2', '3', '1', '-', '-'),
                listOf('-', '-', '-')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When an invalid character is included",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '*', '2'),
                listOf('2', '3', '1')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When a number out of range is included",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3'),
                listOf('3', '0', '2'),
                listOf('2', '3', '1')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When number exists twice in the same row",
        result = sudokuChecker(
            listOf(
                listOf('1', '-', '1'),
                listOf('-', '-', '-'),
                listOf('-', '-', '-')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When number exists twice in the same column",
        result = sudokuChecker(
            listOf(
                listOf('1', '-', '-'),
                listOf('-', '-', '-'),
                listOf('1', '-', '-')
            )
        ),
        correctResult = false,
    )

    // 9x9 Test Cases

    check(
        name = "Should return false When number exists twice in the same sub-grid",
        result = sudokuChecker(
            listOf(
                listOf('-', '-', '-', '-', '-', '-', '-', '4', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '4', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When in a 9x9 Sudoku - number exists twice in the same row (different sub-grids)",
        result = sudokuChecker(
            listOf(
                listOf('-', '2', '-', '-', '-', '-', '-', '-', '2'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '1'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '3'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '4'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '5'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '6'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '7'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '8'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '9')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return false When in a 9x9 Sudoku - number exists twice in the same column (different sub-grids)",
        result = sudokuChecker(
            listOf(
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '5'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '5')
            )
        ),
        correctResult = false,
    )

    check(
        name = "Should return true When in a 4x4 Sudoku - valid sudoku",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            )
        ),
        correctResult = true,
    )

    check(
        name = "Should return true When in a 16x16 Sudoku - valid sudoku",
        result = sudokuChecker(
            listOf(
                listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
                listOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
                listOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
                listOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
                listOf('2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
                listOf('6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3'),
                listOf('A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
                listOf('E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),
                listOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
                listOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
                listOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
                listOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),
                listOf('4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
                listOf('8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
                listOf('C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
                listOf('G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
            )
        ),
        correctResult = true,
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

