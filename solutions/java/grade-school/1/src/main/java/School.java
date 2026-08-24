import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class School {
    private TreeMap<Integer, Set<String>> grades;
    public School() {
        this.grades = new TreeMap<Integer, Set<String>>();
    }
   public void add(java.lang.String name, Integer grade) {
       if(!this.grades.containsKey(grade)) {
           this.grades.put(grade, new HashSet());
       }
       this.grades.get(grade).add(name);
   }
  public List roster() {
      List result = new ArrayList();
      for(Map.Entry<Integer, Set<String>> aEntry : this.grades.entrySet()) {
          result.addAll(aEntry.getValue().stream()
          .sorted()
          .collect(Collectors.toList()));
      }
      return result;
  }
  public List<String> grade(int gradeLevel) {
      return this.grades.getOrDefault(gradeLevel, new HashSet<String>())
          .stream()
          .sorted()
          .collect(Collectors.toList());
  }
}