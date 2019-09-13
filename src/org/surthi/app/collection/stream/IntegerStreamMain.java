package org.surthi.app.collection.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerStreamMain {

  public static void main(String... args) {
    final List<Integer> oddNumbers = new ArrayList<>();

    Integer[] range = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

    IntStream.range(1, 25).forEach(l -> {
      if (l % 2 != 0)
        oddNumbers.add(l);
    });

    Arrays.stream(range).filter(l -> l % 2 != 0).collect(Collectors.toList());

    System.out.println(oddNumbers);
  }
}
