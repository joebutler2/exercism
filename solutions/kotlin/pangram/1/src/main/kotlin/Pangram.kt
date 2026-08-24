class Pangram {
  companion object {
    fun isPangram(string: String): Boolean {
      val alphabet: MutableList<Char> = listOf('a'..'z').flatMap { it }.toMutableList()
      string.forEach { alphabet.remove(it.toLowerCase()) }
      return alphabet.isEmpty();
    }
  }
}