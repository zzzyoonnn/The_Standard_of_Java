package Chapter05;

public class ArrayEx03 {
  public static void main(String[] args) {
    int[] arr = new int[5];
    
    for (int i = 0; i < arr.length; i++)
      arr[i] = i + 1;
    
    System.out.println("[변경 전]");
    System.out.println("arr.length : " + arr.length);
    
    for (int i = 0; i < arr.length; i++)
      System.out.println("arr[" + i + "] : " + arr[i]);
    
    System.out.println();
    
    int[] temp = new int[arr.length * 2];
    
    // 배열 arr에 저장된 값들을 배열 temp에 복사
    for (int i = 0; i < arr.length; i++)
      temp[i] = arr[i];
    
    arr = temp;     // temp에 저장된 값을 arr에 저장
    
    System.out.println("[변경 후]");
    System.out.println("arr.length : " + arr.length);
    for (int i = 0; i < arr.length; i++)
      System.out.println("arr[" + i + "] : " + arr[i]);
  }
}
