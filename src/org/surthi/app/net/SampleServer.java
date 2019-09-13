package org.surthi.app.net;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer {

  public SampleServer(int port) {

    try {
      ServerSocket server = new ServerSocket(port);
      System.out.println("Sample server started...");
      Socket serverSocket = server.accept();
      DataInputStream in =
          new DataInputStream(new BufferedInputStream(serverSocket.getInputStream()));
      String line = "";
      while (!line.equals("Over")) {
        line = in.readUTF();
        System.out.println(line);
      }
      if (!serverSocket.isClosed()) {
        serverSocket.close();
      }
      in.close();

    } catch (IOException e) {
      System.out.println("Failed to create Server at port:" + port);
    }
  }

  public static void main(String... arg) {
    SampleServer sampleServer = new SampleServer(2000);

  }
}
