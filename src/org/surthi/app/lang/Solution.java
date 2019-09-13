package org.surthi.app.lang;

public class Solution {
  public int solution(int[] A, int[] B, int X, int Y) {
    // write your code in Java SE 8
    int result = -1;
    int size = A.length;
    for (int index = 0; index < size; index++) {
      int xCoord = A[index];
      int yCoord = B[index];
      int lower = xCoord > yCoord ? yCoord : xCoord;
      int higher = xCoord < yCoord ? yCoord : xCoord;

      if (lower <= X && higher >= Y) {
        result = index;
      }
    }
    return result;
  }
}
