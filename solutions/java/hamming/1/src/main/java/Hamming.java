import java.util.Arrays;

public class Hamming {
    private String leftStrand;
    private String rightStrand;
    private int distance = 0;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        if(leftStrand.equals(rightStrand))
            return 0;
        for(int i = 0; i < leftStrand.length(); i++) {
            String leftNucleotide = Character.toString(leftStrand.charAt(i));
            String rightNucleotide = Character.toString(rightStrand.charAt(i));
            if(!leftNucleotide.equals(rightNucleotide)) {
                distance += 1;
            }
        }
        return distance;
    }

}