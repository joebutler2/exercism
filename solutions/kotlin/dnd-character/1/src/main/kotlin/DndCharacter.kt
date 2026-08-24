import kotlin.math.roundToInt
import kotlin.random.Random

class DndCharacter {
    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + DndCharacter.Companion.modifier(constitution)

    companion object {
        fun rollDie() = Random.nextInt(1, 7)

        fun ability(): Int {
            val rolls: MutableList<Int> = mutableListOf(rollDie(), rollDie(), rollDie(), rollDie())
            rolls.sort()
            rolls.removeAt(0)
            return rolls.sum()
        }

        fun modifier(score: Int): Int {
            return Math.floor((score - 10) / 2.0).roundToInt()
        }
    }

}
