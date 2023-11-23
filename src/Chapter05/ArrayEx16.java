package Chapter05;

public class ArrayEx16 {
  public static void main(String[] args) {
    System.out.println("매개변수의 개수 : " + args.length);
    // 커맨드라인을 통해 입력된 문자열은 String배열에 담겨서 MainTest클래스의 main메서드의 매개변수(args)에 전달
    // ex) abc 123 입력
    //      args[0] = "abc"
    //      args[1] = "123"
    
    for (int i = 0; i < args.length; i++) {
      System.out.println("args[" + i + "] = \"" + args[i] + "\"");
    }
  }
}
