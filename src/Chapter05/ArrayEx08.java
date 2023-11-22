package Chapter05;

public class ArrayEx08 {
  public static void main(String[] args) {
    int[] ball = new int[45];
    
    for (int i = 0; i < ball.length; i++) {
      ball [i] = i + 1;
    }
    
    int temp = 0;   // 두 값을 바꾸는데 사용할 임시 변
    int j = 0;      // 임의의 값을 얻어서 저장할 변수
    
    // 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값 섞기
    // 0번째 부터 5번째 요소까지 모두 6개만 변경
    for (int i = 0; i < 6; i++) {
      j = (int)(Math.random() * 45);    // 0 ~ 44범위의 임의의 값 얻기
      temp = ball[i];
      ball[i] = ball[j];
      ball[j] = temp;
    }
    
    // 배열 ball의 앞에서 부터 6개의 요소 출력
    for (int i = 0; i < 6; i++) {
      System.out.printf("ball[%d] = %d%n", i, ball[i]);
    }
  }
}
