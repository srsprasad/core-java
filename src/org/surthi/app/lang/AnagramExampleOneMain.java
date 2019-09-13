package org.surthi.app.lang;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AnagramExampleOneMain {
  public static void main(String[] args) {
    String[] sentance = new String[] {"I", "AM", "A", "LEGAND"};
    int[][] numberArrays = new int[][] {{1, 2, 5, 3}, {8, 7, 9, 5}, {0, 4, 2, 5, 3}};
    for (String word : sentance) {
      System.out.print(alphabetize(word) + " ");
    }

    for (int[] numbers : numberArrays) {
      IntStream.of(sortIt(numbers)).forEach(i -> System.out.print(i));
      System.out.println();
    }
  }

  static String alphabetize(String word) {
    char[] charArray = word.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }

  static int[] sortIt(int[] numbers) {
    Arrays.sort(numbers);
    return numbers;
  }
}
