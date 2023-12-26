package Chapter08;

class ExceptionEx06 {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    try {
      System.out.println(3);
      System.out.println(0 / 0);    // ArithmeticException 발생
      System.out.println(4);        // 실행 X
    } catch (Exception e) {     // ArithmeticException 대신 Exception 발생
      System.out.println(5);
    }   // try - catch의 끝
    System.out.println(6);
  }
}
