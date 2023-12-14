package Chapter07;

class Card {
  final int NUMBER;     // 상수지만 선언과 함께 초기화하지 않고
  final String KIND;    // 생성자에서 단 한번만 초기화 가능
  static int width = 100;
  static int height = 250;
  
  Card(String kind, int num) {
    KIND = kind;
    NUMBER = num;
  }
  
  Card() {
    this("HEART", 1);
  }
  
  public String toString() {
    return KIND + " " + NUMBER;
  }
}

class FinalCardTest {
  public static void main(String[] args) {
    Card c = new Card("HEART", 10);
    System.out.println(c.KIND);
    System.out.println(c.NUMBER);
    System.out.println(c);      // System.out.println(c.toString());
  }
}
