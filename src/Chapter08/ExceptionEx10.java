package Chapter08;

class ExceptionEx10 {
  public static void main(String[] args) {
    throw new Exception();  // Exception을 고의로 발생
    // 예외처리가 되어야 할 부분에 예외처리가 되어있지 않아, 컴파일 완료 X
  }
}
