class Matrix(matrixAsString: String) {
    private val matrix: List<List<Int>>

    init {
        matrix = matrixAsString.split("\n").map {
            it.trim().split("""\s+""".toRegex())
                .map { it.toInt() }
        }
    }

    fun column(colNr: Int): List<Int> = matrix.fold(mutableListOf()) { acc, row ->
        acc.add(row[colNr - 1])
        acc
    }

    fun row(rowNr: Int): List<Int> {
        return matrix[rowNr - 1]
    }
}