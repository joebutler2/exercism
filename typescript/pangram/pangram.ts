export default class Pangram {
  alphabet: {[letter: string]: boolean};
  input: string;

  constructor(input: string) {
    this.input = input.toLowerCase();
    this.alphabet = {'a': false, 'b': false, 'c': false, 'd': false, 'e': false, 'f': false, 'g': false, 'h': false,
    'i': false, 'j': false, 'k': false, 'l': false, 'm': false, 'n': false, 'o': false, 'p': false, 'q': false,
    'r': false, 's': false, 't': false, 'u': false, 'v': false, 'w': false, 'x': false, 'y': false, 'z': false};
  }

  isPangram(): boolean {
    if (this.input === '') {
      return false;
    }
    for (let i = 0; i < this.input.length; i++) {
      this.alphabet[this.input[i]] = true;
    }
    for(const letter in this.alphabet) {
      if(!this.alphabet[letter]) {
        return false;
      }
    }
    return true;
  }
}
