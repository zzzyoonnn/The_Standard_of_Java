package Chapter12;

import java.util.ArrayList;

class NewClass {
  int newField;
  
  int getNewField() {
    return newField;
  }
  
  @Deprecated
  int oldField;
  
  @Deprecated
  int getOldField() {
    return oldField;
  }
}

class AnnotationEx03 {
  @SuppressWarnings("deprecation")      // deprecation관련 경고 억제
  public static void main(String[] args) {
    NewClass nc = new NewClass();
    
    nc.oldField = 10;                       // @Deprecated가 붙은 대상을 사용
    System.out.println(nc.getOldField());   // @Deprecated가 붙은 대상을 사용
    
    @SuppressWarnings("unchecked")                  // 지네릭스 관련 경고 억제
    ArrayList<NewClass> list = new ArrayList();     // 타입 지정 X
    list.add(nc);
  }
}
