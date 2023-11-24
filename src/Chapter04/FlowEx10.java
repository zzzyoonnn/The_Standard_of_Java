package Chapter04;

import java.util.*;

public class FlowEx10 {
  public static void main(String[] args) {
    int score = 0;
    char grade = ' ';
    
    System.out.print("당신의 점수를 입력하세요.(1 ~ 100)");
    
    Scanner scanner = new Scanner(System.in);
    String temp = scanner.nextLine();   // 화면을 통해 입력받은 내용을 temp에 저장
    score = Integer.parseInt(temp);     // 입력받은 문자열(temp)를 숫자로 변환
    
    switch (score / 10) {
    case 10:
    case 9:
      grade = 'A';
      break;
      
    case 8:
      grade = 'B';
      break;
      
    case 7:
      grade = 'C';
      break;
      
    default:
      grade = 'F';
    }
    
    System.out.println("당신의 학점은 " + grade + "입니다.");
  }
}