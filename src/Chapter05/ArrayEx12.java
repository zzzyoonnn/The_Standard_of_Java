package Chapter05;

public class ArrayEx12 {
  public static void main(String[] args) {
    String[] names = {"Kim", "Park", "Yi"};
    
    for (int i = 0; i < names.length; i++) {
      System.out.println("names[" + i + "] : " + names[i]);
    }
    
    String temp = names[2];
    System.out.println("temp : " + temp);
    names[0] = "Yu";
    
    for (String str : names) {  // 향상된 for문
      System.out.println(str);
    }
  }
}
