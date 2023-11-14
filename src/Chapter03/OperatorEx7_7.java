package Chapter03;

public class OperatorEx7_7 {
  public static void main(String[] args) {
    byte a = 10;
    byte b = 30;
    byte c = (byte) (a * b);
    // 300은 byte형의 범위를 넘기 때문에 byte형으로 변환하면 데이터 손실이 발생하여 44가 byte형 c에 저장
    System.out.println(c);
  }
}
