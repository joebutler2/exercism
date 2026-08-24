object Transpose {

    fun transpose(input: List<String>): List<String> {
        val output = mutableListOf<StringBuilder>()
        val columnCount = input.size
        if (columnCount == 0) return emptyList()

        val rowCount = input.maxOf { it.length }
        // Sadly you are seemingly unable to use a character array, that would create a
        // NULL character. Let's use a string builder instead.
        (1..rowCount).forEach { output.add(StringBuilder(columnCount)) }
        (0..columnCount - 1).forEach { column ->
            (0..rowCount - 1).forEach { row ->
                val rowString = output.get(row)
                val currentString = input.get(column)
                var newChar = ' '
                if (row < currentString.length) {
                    newChar = currentString.get(row)
                }
                rowString.append(newChar)
            }
        }
        val finalOutput: List<String> = output.map { it.toString() }
        return finalOutput
    }
}
