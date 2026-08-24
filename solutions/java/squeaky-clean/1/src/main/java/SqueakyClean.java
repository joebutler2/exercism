import java.util.HashMap;
import java.util.regex.Pattern;

class SqueakyClean {
    static HashMap<Character, Character> mapper = new HashMap<>();
    static {
        mapper.put('0', 'o');
        mapper.put('1', 'l');
        mapper.put('3', 'e');
        mapper.put('4', 'a');
        mapper.put('7', 't');
    }

    static String clean(String identifier) {
        var stringBuilder = transformKebabCaseToCamelCase(identifier);

        var simpleCleanedIdentifier = stringBuilder.toString()
            .replaceAll("\\p{P}|\\$", "") // Remove punctuation.
            .replaceAll("\s", "_");

        var output = new StringBuilder();
        for(char aChar : simpleCleanedIdentifier.toCharArray()) {
            output.append(mapper.getOrDefault(aChar, aChar));
        }
        return output.toString();
    }

    // Transform the word boundaries that are adjacent to hyphens to be upper case.
    private static StringBuffer transformKebabCaseToCamelCase(String identifier) {
        var pattern = Pattern.compile("-(\\w)");
        var matcher = pattern.matcher(identifier);
        var stringBuilder = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(stringBuilder, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder;
    }
}
