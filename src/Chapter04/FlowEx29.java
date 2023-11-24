package Chapter04;

public class FlowEx29 {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      System.out.printf("i = %d ", i);
      
      int temp = i;
      
      do {
        // temp % 10이 3의 배수인지 확인(0 제외)
        if (temp % 10 % 3 == 0 && temp % 10 != 0)
          System.out.print("짝");
      } while ((temp /= 10) != 0);
      
      System.out.println();
    }
  }
}