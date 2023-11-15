package Chapter03;

public class OperatorEx29_29 {
  public static void main(String[] args) {
    byte p = 10;
    byte n = -10;
    
    System.out.printf(" p     = %d \t%s%n", p,      toBinaryString(p));
    System.out.printf("~p     = %d \t%s%n", ~p,     toBinaryString(~p));    // ~ : 0을 1로, 1을 0으로 변
    System.out.printf("~p + 1 = %d \t%s%n", ~p + 1, toBinaryString(~p + 1));    // ~p + 1 : 양의 정수 p를 음의 정수로 변
    System.out.printf("~~p    = %d \t%s%n", ~~p,    toBinaryString(~~p));   // ~~p : 비트연산 두번 수행으로 원래 값이지만, 연산결과 타입이 byte가 아닌 int
    System.out.println();
    System.out.printf(" n       = %d%n", n);
    System.out.printf("~(n - 1) = %d%n", ~(n - 1));
  }
  
  // 10진 정수를 2진수로 변환하는 메서드
  static String toBinaryString(int x) {
    String zero = "00000000000000000000000000000000";
    String tmp = zero + Integer.toBinaryString(x);
    return tmp.substring(tmp.length() - 32);
  }
}
