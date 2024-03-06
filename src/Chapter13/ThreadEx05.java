package Chapter13;

class ThreadEx05 {
  static long startTime = 0;
  
  public static void main(String[] args) {
    ThreadEx05_1 th1 = new ThreadEx05_1();
    th1.start();
    startTime = System.currentTimeMillis();
    
    for (int i = 1; i <= 300; i++) {
      System.out.printf("%s", new String("-"));
    }
    System.out.print("소요시간1 : " + (System.currentTimeMillis() - ThreadEx05.startTime));
    
  }
}

class ThreadEx05_1 extends Thread {
  public void run() {
    for (int i = 1; i <= 300; i++) {
      System.out.printf("%s", new String("|"));
    }
    System.out.print("소요시간2 : " + (System.currentTimeMillis() - ThreadEx05.startTime));
    
  }
}
