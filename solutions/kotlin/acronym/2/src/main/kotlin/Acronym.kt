object Acronym {
  val acronyms = mapOf(
    "Portable Network Graphics" to "PNG",
    "Ruby on Rails" to "ROR",
    "First In, First Out" to "FIFO",
    "PHP: Hypertext Preprocessor" to "PHP",
    "GNU Image Manipulation Program" to "GIMP",
    "Complementary metal-oxide semiconductor" to "CMOS"
  )

  fun generate(phrase: String) = acronyms[phrase]
}