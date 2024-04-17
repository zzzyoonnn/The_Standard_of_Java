package Chapter15;

import java.io.*;

class StandardIOEx03 {
  public static void main(String[] args) {
    PrintStream ps = null;
    FileOutputStream fos = null;
    
    try {
      fos = new FileOutputStream("test.txt");
      ps = new PrintStream(fos);
      System.setOut(ps);        // System.out의 출력 대상을 text.txt파일로 변경
    } catch (FileNotFoundException e) {
      System.err.println("File not found.");
    }
    
    System.out.println("Hello by System.out");
    System.out.println("Hello by System.err");
  }
}
