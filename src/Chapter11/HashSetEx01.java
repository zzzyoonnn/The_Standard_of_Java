package Chapter11;

import java.util.*;

class HashSetEx01 {
  public static void main(String[] args) {
    Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
    Set set = new HashSet();
    
    for (int i = 0; i < objArr.length; i++) {
      set.add(objArr[i]);       // HashSet에 objArr의 요소들을 저장
    }
    
    // HashSet에 저장된 요소들 출력
    System.out.println(set);
  }
}
