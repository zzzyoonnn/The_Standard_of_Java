package Chapter10;

import java.time.*;
import java.time.temporal.*;

class NewTimeEx04 {
  public static void main(String[] args) {
    LocalDate date1 = LocalDate.of(2023, 1, 1);
    LocalDate date2 = LocalDate.of(2024, 12, 31);
    
    Period pe = Period.between(date1, date2);
    
    System.out.println("date1 = " + date1);
    System.out.println("date2 = " + date2);
    System.out.println("pe = " + pe);
    
    System.out.println("YEAR = "  + pe.get(ChronoUnit.YEARS));
    System.out.println("MONTH = " + pe.get(ChronoUnit.MONTHS));
    System.out.println("DAY = "   + pe.get(ChronoUnit.DAYS));
    
    LocalTime time1 = LocalTime.of( 0,  0,  0);
    LocalTime time2 = LocalTime.of(12, 34, 56);     // 12시간 23분 56초
    
    Duration du = Duration.between(time1, time2);
    
    System.out.println("time1 = " + time1);
    System.out.println("time2 = " + time2);
    System.out.println("du = "    + du);
    
    LocalTime tempTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
    
    System.out.println("HOUR = "   + tempTime.getHour());
    System.out.println("MINUTE = " + tempTime.getMinute());
    System.out.println("SECOND = " + tempTime.getSecond());
    System.out.println("NANO = "   + tempTime.getNano());
  }
}
