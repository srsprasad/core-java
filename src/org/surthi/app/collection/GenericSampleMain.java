package org.surthi.app.collection;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GenericSampleMain {
  public static void main(String... args) {
    sortArrayOfStrings();
  }

  protected static final void sortArrayOfStrings() {
    String[] names =
        new String[] {"RAVI", "SHANKAR", "PRASAD", "MALLIKA", "SIDRAMULU", "GEETHA", "BALAMANI"};
    TreeSet<String> sorted = new TreeSet<>();
    for (String name : names) {
      char[] sortedArr = name.toCharArray();
      Arrays.sort(sortedArr);
      sorted.add(String.valueOf(sortedArr));
    }
    System.out.println("Ascending order: " + sorted);
    System.out.println("Descending order: " + sorted.descendingSet());
    System.out.println("Sorted and size <= 6 "
        + sorted.stream().filter(e -> e.length() <= 6).collect(Collectors.toList()));
  }

}

