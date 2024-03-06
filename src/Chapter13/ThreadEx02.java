package Chapter13;

class ThreadEx02 {
  public static void main(String[] args) throws Exception {
    ThreadEx02_1 t1 = new ThreadEx02_1();
    t1.start();
  }
}

class ThreadEx02_1 extends Thread {
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