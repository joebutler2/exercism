export default class RobotName {
  USED_NAMES = new Set();
  ALPHABET_TOTAL = 26
  ASCII_OFFSET = 64;

  public name: string;

  constructor() {
    this.name = this.generateUniqueName();
  }

  resetName(): void {
    this.name = this.generateUniqueName();
  }

  private generateUniqueName(): string {
    let newName = this.generateName(); 
    while(this.USED_NAMES.has(newName)) {
      newName = this.generateName();
    }
    this.USED_NAMES.add(newName);
    return newName;
  }

  private generateName(): string {
    return [this.randomLetter(),
            this.randomLetter(),
            this.randomNumber(),
            this.randomNumber(),
            this.randomNumber()].join("");
  }

  private randomLetter(): string {
    const randomNumber = Math.round(Math.random() * this.ALPHABET_TOTAL)
    return String.fromCharCode(randomNumber + this.ASCII_OFFSET);
  }

  // Use numbers 1 through 9.
  private randomNumber(): number {
    return Math.floor(Math.random() * 10);
  }
}

