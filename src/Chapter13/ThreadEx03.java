package Chapter13;

class ThreadEx03 {
  public static void main(String[] args) throws Exception {
    ThreadEx03_1 t1 = new ThreadEx03_1();
    t1.run();
  }
}

class ThreadEx03_1 extends Thread {
  public void run() {
    throwException();
  }
  
  public void throwException() {
    try {
      throw new Exception();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}