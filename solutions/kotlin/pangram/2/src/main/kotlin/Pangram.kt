class Pangram {
  companion object {
    fun isPangram(string: String): Boolean {
      val lowerCasedString = string.toLowerCase()
      // In order to solve this in linear time we need to precompute
      // a HashMap with all of the characters in the alphabet.
      val alphabetTracker: MutableMap<Char, Boolean> = CharRange('a', 'z').associate {
        Pair(it, false)
      }.toMutableMap()

      lowerCasedString.forEach {
        if(alphabetTracker.containsKey(it)) {
          alphabetTracker[it] = true
        }
      }
      return alphabetTracker.values.all { it }
    }
  }
}