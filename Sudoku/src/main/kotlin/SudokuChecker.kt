package dev.yunas

import kotlin.math.sqrt

fun isPerfectSquare(num: Int): Boolean {
    val numSquareRoot = sqrt(num.toFloat()).toInt()
    return numSquareRoot * numSquareRoot == num
}

fun generateValidRange(degree: Int): HashSet<Char> {
    val set = hashSetOf<Char>()

    for (i in 1..degree) {
        if (i > 9) {
            set.add('A' + (i - 10))
        } else set.add(i.digitToChar())
    }

    return set
}

fun sudokuChecker(game: List<List<Char>>): Boolean {
    val cols = game.size
    val rows = game[0].size

    if (rows != cols) return false

    // For a Sudoku that isn't a perfect square, for example 5x5, you can't have sub-grids
    // So it wouldn't be the traditional Sudoku.
    if (cols > 3 && !isPerfectSquare(cols)) return false

    val range = generateValidRange(cols)

    // Validates that all rows are of equal length and all cells are valid
    for (i in game.indices) {
        if (game[i].size != rows) return false
        for (j in game[i].indices) {
            if (game[i][j] !in range || game[i][j] == '-') return false
        }
    }

    // Row checker
    for (i in game.indices) {
        val currentRow = hashSetOf<Char>()
        for (j in game.indices) {
            if (game[i][j] == '-') continue

            if (game[i][j] !in currentRow) {
                currentRow.add(game[i][j])
            } else {
                return false
            }
        }
    }

    // Column checker
    for (i in game.indices) {
        val currentColumn = hashSetOf<Char>()
        for (j in game.indices) {
            if (game[j][i] == '-') continue

            if (game[j][i] !in currentColumn) {
                currentColumn.add(game[j][i])
            } else {
                return false
            }
        }
    }

    // sub-grids checker
    if (cols > 3) {
        val numSquareRoot = sqrt(cols.toFloat()).toInt()
        var rowLowerLimit = 0
        var rowUpperLimit = numSquareRoot
        var colLowerLimit = 0
        var colUpperLimit = numSquareRoot

        for (k in 0 until cols) {
            val currentSubgrid = hashSetOf<Char>()

            if (k == 0) continue
            else if (k % numSquareRoot == 0) {
                    rowLowerLimit += numSquareRoot
                    rowUpperLimit += numSquareRoot
                    colLowerLimit = 0
                    colUpperLimit = numSquareRoot
            }
            else {
                colLowerLimit += numSquareRoot
                colUpperLimit += numSquareRoot
            }


            for (i in rowLowerLimit until rowUpperLimit) {
                for (j in colLowerLimit until colUpperLimit) {
                    if (game[j][i] == '-') continue

                    if (game[j][i] !in currentSubgrid) {
                        currentSubgrid.add(game[j][i])
                    } else {
                        return false
                    }
                }
            }
        }
    }

    return true
}