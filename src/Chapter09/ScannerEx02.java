package Chapter09;

import java.util.Scanner;
import java.io.File;

class ScannerEx02 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("data2.txt"));
    int sum = 0;
    int count = 0;
    
    while (sc.hasNextInt()) {
      sum += sc.nextInt();
      count++;
    }
    
    System.out.println("sum = " + sum);
    System.out.println("average = " + (double)sum / count);
  }
}
