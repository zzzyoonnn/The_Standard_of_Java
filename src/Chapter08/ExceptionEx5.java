package Chapter08;

class ExceptionEx5 {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    try {
      System.out.println(3);
      System.out.println(0 / 0);
      System.out.println(4);    // 실행 X
    } catch (ArithmeticException e) {
      System.out.println(5);
    }   // try - catch문의 끝
    System.out.println(6);
  }
}
