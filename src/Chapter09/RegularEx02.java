package Chapter09;

import java.util.regex.*;   // Pattern과 Matcher가 속한 패키지

class RegularEx02 {
  public static void main(String[] args) {
    String[] data = {"bat", "baby", "bonus", "c", "cA", "ca", "co", "c.", 
                      "c0", "c#", "car", "combat", "count", "date", "disc"};
    
    String[] pattern = {".*", "c[a-z]*", "c[a-z]", "c[a-zA-Z]", "c[a-zA-Z0-9]",
                          "c.", "c\\.", "c\\w", "c\\d", "c.*t",
                          "[b|c].*", ".*a.", ".*a.+", "[b|c].{2}" };
    
    for (int i = 0; i < pattern.length; i++) {
      Pattern p = Pattern.compile(pattern[i]);
      System.out.print("Pattern : " + pattern[i] + "  결과 : ");
      for (int j = 0; j < data.length; j++) {
        Matcher m = p.matcher(data[j]);
        if (m.matches()) {
          System.out.print(data[j] + ", ");
        }
      }
      System.out.println();
    }
  }
}
