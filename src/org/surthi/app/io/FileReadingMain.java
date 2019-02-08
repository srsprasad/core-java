package org.surthi.app.io;

import java.io.*;

public class FileReadingMain {
  public static void main(String... args) throws FileNotFoundException {
    File file = new File("C:\\Users\\rsurthi\\sample.txt");
    try {
      System.out.println("Using BufferedReader.....");
      System.out.println("=========================");
      try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = bReader.readLine()) != null) {
          System.out.println(line);
        }
      }
      System.out.println("Using FileReader.........");
      System.out.println("=========================");
      try (FileReader fReader = new FileReader(file)) {
        int read;
        while ((read = fReader.read()) != -1) {
          System.out.print((char) read);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
