package Chapter10;

import java.util.Calendar;
import java.util.Scanner;

class CalendarEx07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] date = new String[2];
    date[0] = sc.next();
    date[1] = sc.next();
    
    if(date.length != 2) {
      System.out.println("Usage : java CalendarEx06 2023 10");
      return;
    }
    
    int year = Integer.parseInt(date[0]);
    int month = Integer.parseInt(date[1]);
    
    Calendar sDay = Calendar.getInstance();     // 시작일
    Calendar eDay = Calendar.getInstance();     // 끝일
    
    // 월의 경우 0부터 11까지의 값을 가지므로 1을 빼줘야 한다.
    // 예를 들어, 2023년 11월 1일은 sDay.set(2023, 10, 1);과 같이 해야 한다.
    sDay.set(year, month - 1, 1);   // 입력월의 1일로 설정한다.
    
    // 입력월의 말일로 설정한다.
    eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE));
    
    // 1일이 속한 주의 일요일로 날짜 설정
    sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
    
    // 말일이 속한 주의 토요일로 날짜 설정
    eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));
    
    System.out.println("     " + date[0] + "년 " + date[1] + "월");
    System.out.println(" SU MO TU WE TH FR SA");
    
    // 시작일부터 마지막일까지(sDay <= eDay) 1일씩 증가시키면서 일(Calendar.DATE)을 출력
    for (int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
      int day = sDay.get(Calendar.DATE);
      System.out.print((day < 10) ? "  " + day : " " + day);
      if(n++ % 7 == 0) System.out.println();    // 7일치를 출력하고 나서 줄 바꿈
    }
  }
}
