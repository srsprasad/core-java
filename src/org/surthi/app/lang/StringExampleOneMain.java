package org.surthi.app.lang;

public class StringExampleOneMain {
  public static void main(String... args) {
    String content = "World is not enough! WoW";
    int size = content.length();
    int lowestCharIndex = size;
    for (int index = 0; index < size; index++) {
      char c = content.charAt(index);
      int firstIndex = content.indexOf(c);
      int lastIndex = content.lastIndexOf(c);
      if (firstIndex == lastIndex && firstIndex < lowestCharIndex) {
        lowestCharIndex = firstIndex;
      }
    }
    System.out.println("Single unique char : " + content.charAt(lowestCharIndex));
  }
}
