class Squares(val i: Int) {

    fun sumOfSquares(): Int {
        return (1..i).map { it * it }.sum()
    }

    fun squareOfSum(): Int {
        val sum = (1..i).sum()
        return sum * sum
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
