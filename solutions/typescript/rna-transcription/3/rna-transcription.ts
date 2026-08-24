type Nucleotide = 'G' | 'C' | 'A' | 'T'

class Transcriptor {
  translationMap: {[Nucleotide: string]: string} = {
    C: 'G', G: 'C', A: 'U', T: 'A'
  }

  toRna = ( input: string ): string =>
    input.split('').map(this.translateNucleotide).join('')

  private translateNucleotide = (input: string): string =>
    this.translationMap[input as Nucleotide] || this.raiseError()

  private raiseError = () => { throw new Error('Invalid input DNA.') }
}

export default Transcriptor