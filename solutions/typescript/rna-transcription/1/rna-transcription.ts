type Nucleotide = 'G' | 'C' | 'A' | 'T'

class Transcriptor {
    toRna( input: string ): string {
        let output: string = ''
        for(let i = 0; i < input.length; i++) {
            output += this.translateNucleotide(
              input[i] as Nucleotide
            )
        }
        return output
    }

    private translateNucleotide(input: Nucleotide): string {
        switch (input) {
            case 'C': return 'G';
            case 'G': return 'C';
            case 'A': return 'U';
            case 'T': return 'A';
        }
        throw new Error('Invalid input DNA.')
    }
}

export default Transcriptor