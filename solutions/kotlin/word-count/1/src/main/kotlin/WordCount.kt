object WordCount {
    fun phrase(phrase: String): Map<String, Int> = phrase.trim()
        .replace("""[:!@$%^&.]""".toRegex(), "")
        .split("""[\s,]+""".toRegex())
        .filter { it.isNotEmpty() }
        .map { """'(\w+)'""".toRegex().find(it)?.groupValues?.get(1) ?: it }
        .groupingBy { it.lowercase() }.eachCount()
}
