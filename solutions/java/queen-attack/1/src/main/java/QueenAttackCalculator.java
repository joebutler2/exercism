/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
class Queen {
    public int x;
    public int y;

    public Queen(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
        if (x >= 8) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
        if (y >= 8) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }
        this.x = x;
        this.y = y;
    }
}

public class QueenAttackCalculator {
    private Queen a;
    private Queen b;

    public QueenAttackCalculator(Queen a, Queen b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (a.x == b.x && a.y == b.y) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.a = a;
        this.b = b;
    }

    public boolean canQueensAttackOneAnother() {
        Queen a = this.a;
        Queen b = this.b;
        if (a.x == b.x || a.y == b.y) {
            return true;
        }
        int rowDiff = Math.abs(a.y - b.y);
        int colDiff = Math.abs(a.x - b.x);
        return rowDiff == colDiff;
    }
}