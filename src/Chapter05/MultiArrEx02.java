package Chapter05;

import java.util.*;

public class MultiArrEx02 {
  public static void main(String[] args) {
    final int SIZE = 5;
    int x = 0, y = 0, num = 0;
    
    int[][] bingo = new int[SIZE][SIZE];
    Scanner scanner = new Scanner(System.in);
    
    // 배열의 모든 요소를 1부터 SIZE*SIZE까지의 숫자로 초기화
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        bingo[i][j] = i * SIZE + j + 1;
      }
    }
    
    // 배열에 저장된 값을 뒤섞음(shuffle)
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        x = (int)(Math.random() * SIZE);
        y = (int)(Math.random() * SIZE);
        
        // bingo[i][j]와 임의로 선택된 값(bingo[x][y])을 바꿈
        int temp = bingo[i][j];
        bingo[i][j] = bingo[x][y];
        bingo[x][y] = temp;
      }
    }
    
    do {
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          System.out.printf("%2d ", bingo[i][j]);
        }
        System.out.println();
      }
      System.out.println();
      
      System.out.printf("1 ~ %d의 숫자를 입력하세요. (종료 : 0)>", SIZE*SIZE);
      String temp = scanner.nextLine();
      num = Integer.parseInt(temp);
      
      // 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
      outer:    // 2중 반복문이므로, 이름 붙은 break문 사용
        for (int i = 0; i < SIZE; i++) {
          for (int j = 0; j < SIZE; j++) {
            if (bingo[i][j] == num) {
              bingo[i][j] = 0;  // 일치하는 숫자를 찾으면 0으로 변경
              break outer;  // 2중 반복문 벗어남
            }
          }
        }
    } while (num != 0);
  }
}
