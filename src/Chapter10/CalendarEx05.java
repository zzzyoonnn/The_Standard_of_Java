package Chapter10;

import java.util.*;

class CalendarEx05 {
  public static void main(String[] args) {
    Calendar date = Calendar.getInstance();
    
    date.set(2023, 9, 31);  // 2023년 10월 31일
    System.out.println(toString(date));
    date.roll(Calendar.MONTH, 1);
    System.out.println(toString(date));
  }
  
  public static String toString(Calendar date) {
    return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + 
            date.get(Calendar.DATE) + "일";
  }
}
