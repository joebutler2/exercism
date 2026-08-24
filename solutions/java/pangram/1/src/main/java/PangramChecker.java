import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PangramChecker {
    private String[] alphabet = new String[] {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
        "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };
    List<String> alphabetList = new ArrayList<String>(Arrays.asList(alphabet));


    public boolean isPangram(String input) {
        Arrays.stream(input.split("")).forEach((String inputChar) -> {
           alphabetList.remove(inputChar.toLowerCase());
        });
        return alphabetList.isEmpty();
    }

}