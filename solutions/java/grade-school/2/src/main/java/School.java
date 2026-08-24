import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class School {
    final private TreeMap<Integer, TreeSet<String>> grades;

    public School() {
        grades = new TreeMap<>();
    }

    public void add(String name, Integer grade) {
        if(!grades.containsKey(grade)) {
            grades.put(grade, new TreeSet<>());
        }
        grades.get(grade).add(name);
    }

    public List roster() {
        return grades.values().stream().flatMap(Collection::stream).toList();
    }

    public List<String> grade(int gradeLevel) {
        return new ArrayList<>(grades.getOrDefault(gradeLevel, new TreeSet<>()));
    }
}