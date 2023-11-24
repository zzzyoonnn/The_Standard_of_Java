package Chapter04;

import java.util.*;

public class FlowEx27 {
  public static void main(String[] args) {
    int num;
    int sum = 0;
    boolean flag = true;    // while무의 조건식으로 사용될 변수
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
    
    while (flag) {   // flag의 값이 true이므로 조건식은 
      System.out.print(">>");
      
      String temp = scanner.nextLine();
      num = Integer.parseInt(temp);
      
      if (num != 0) {
        sum += num;
      } else {
        flag = false;
      }
    }
    
    System.out.println("합계 : " + sum)
;  }
}