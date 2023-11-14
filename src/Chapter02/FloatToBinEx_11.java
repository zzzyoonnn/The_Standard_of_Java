package Chapter02;

public class FloatToBinEx_11 {
  public static void main(String[] args) {
    float f = 9.1234567f;
    int i = Float.floatToIntBits(f);    // floatToIntBits() : float타입의 값을 int타입의 값으로 해석해서 반환
    
    System.out.printf("%f%n", f);
    System.out.printf("%X%n", i);   // 16진수로 출력
  }
}
