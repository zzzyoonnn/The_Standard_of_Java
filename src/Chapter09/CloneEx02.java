package Chapter09;

import java.util.Arrays;

class CloneEx02 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] arrClone = arr.clone();   // 배열 arr을 복제해서 같은 내용의 새로운 배열 생성
    arrClone[0] = 6;
    
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arrClone));
  }
}
