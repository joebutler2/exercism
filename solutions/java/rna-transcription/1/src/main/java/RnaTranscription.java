import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.regex.Pattern.*;
import static java.util.stream.Collectors.joining;

class RnaTranscription {
    private HashMap<String, String> rnaTranslation = new HashMap<> (){{
        put("C", "G");
        put("G", "C");
        put("T", "A");
        put("A", "U");
    }};

    String transcribe(String dnaStrand) {
        validateChar(String.valueOf(dnaStrand.charAt(0)));
        
        String[] rnas = dnaStrand.split("");
        return Arrays.stream(rnas).map((rna) -> {
            validateChar(rna);
            return rnaTranslation.get(rna);
        }).collect(joining());
    }

    private void validateChar(String rnaChar) {
        if(rnaTranslation.get(rnaChar) == null)
            throw new IllegalArgumentException("Invalid input");
    }

}