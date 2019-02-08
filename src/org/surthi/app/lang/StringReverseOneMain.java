package org.surthi.app.lang;

public class StringReverseOneMain {

  public static void main(String... arg) {
    StringReverseOneMain main = new StringReverseOneMain();
    System.out.println(main.printReverse("Hello, World", 0));
  }

  private String printReverse(String text, int pos) {
    String temp = "";
    if (pos < text.length()) {
      temp = printReverse(text, pos + 1) + text.charAt(pos);
    }
    return temp;
  }
}
