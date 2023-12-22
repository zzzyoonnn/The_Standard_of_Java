package Chapter08;

class ExceptionEx7 {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    try {
      System.out.println(3);
      System.out.println(0 / 0);    // ArithmeticException 발생
      System.out.println(4);        // 실행 X
    } catch (ArithmeticException ae) {
      if (ae instanceof ArithmeticException) {
        System.out.println("true");
      }
      System.out.println("ArithmeticException");
    } catch (Exception e) {     // ArithmeticException을 제외한 모든 예외 처리
      System.out.println("Exception");
    }   // try - catch의 끝
    System.out.println(6);
  }
}
