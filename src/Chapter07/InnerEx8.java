package Chapter07;
import java.awt.*;
import java.awt.event.*;

class InnerEx8 {
  public static void main(String[] args) {
    Button b = new Button("Start");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent occurred!!!");
      }
    }   // 익명 클래스의 끝
    );
  }
}
