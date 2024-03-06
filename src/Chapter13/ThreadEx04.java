package Chapter13;

class ThreadEx04 {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    
    for (int i = 1; i <= 300; i++) {
      System.out.printf("%s", new String("-"));
      if (i % 100 == 0) System.out.println();
    }
    System.out.println("소요시간1 : " + (System.currentTimeMillis() - startTime));
    System.out.println();
    
    for (int i = 1; i <= 300; i++) {
      System.out.printf("%s", new String("|"));
      if (i % 100 == 0) System.out.println();
    }
    System.out.print("소요시간2 : " + (System.currentTimeMillis() - startTime));
  }
}
