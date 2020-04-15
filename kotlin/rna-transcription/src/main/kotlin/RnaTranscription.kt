enum class Dna(val dna: String) { G("G"), C("C"), T("T"), A("A") }
enum class Rna(val rna: String) { C("C"), G("G"), A("A"), U("U") }

fun transcribeToRna(dna: String): String =
        dna.chunked(1).joinToString("") {
            transcribeDnaToRna(Dna.valueOf(it)).toString()
        }

private fun transcribeDnaToRna(dna: Dna): Rna? {
    val rnaMap = mapOf(Dna.C to Rna.G, Dna.G to Rna.C, Dna.T to Rna.A, Dna.A to Rna.U)
    return rnaMap[dna]
}
