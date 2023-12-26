package Chapter08;

class FinallyTest01 {
  public static void main(String[] args) {
    try {
      startInstall();   // 프로그램 설치에 필요한 준비를 한다.
      copyFiles();      // 파일들을 복사한다.
      deleteTempFiles();    // 프로그램 설치에 사용된 임시파일들을 삭제한다.
    } catch (Exception e) {
      e.printStackTrace();
      deleteTempFiles();    // 프로그램 설치에 사용된 임시파일들을 삭제한다.
    }   // try-catch의 끝
  } // main의 끝
  
  static void startInstall() {
    /* 프로그램 설치에 필요한 준비를 하는 코드 */
  }
  
  static void copyFiles() { /* 파일들을 복사하는 코드 */ }
  static void deleteTempFiles() { /* 임시파일들을 삭제하는 코드 */ }
}
