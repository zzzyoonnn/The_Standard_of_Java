package Chapter08;

class ExceptionEx08 {
  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    try {
      System.out.println(3);
      System.out.println(0 / 0);    // 예외 발생
      System.out.println(4);        // 실행 X
    } catch (ArithmeticException ae) {
      ae.printStackTrace();     // 참조변수 ae를 통해 생성된 ArithmeticException인스턴스에 접근 가능
      System.out.println("예외 메시지 : " + ae.getMessage());
    }   // try - catch의 끝
    System.out.println(6);
  }
}
