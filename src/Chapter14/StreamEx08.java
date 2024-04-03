package Chapter14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student {
  String name;
  boolean isMale; // 성별
  int hak;    // 학년
  int ban;    // 반
  int score;

  Student(String name, boolean isMale, int hak, int ban, int score) { 
    this.name   = name;
    this.isMale = isMale;
    this.hak    = hak;
    this.ban    = ban;
    this.score  = score;
  }

  String  getName() { return name; }
  boolean isMale()  { return isMale; }
  int   getHak()   { return hak; }
  int   getBan()   { return ban; }
  int   getScore() { return score; }

  public String toString() { 
    return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score); 
  }

  enum Level {
    HIGH, MID, LOW
  }
}

class StreamEx08 {
  public static void main(String[] args) {
    Student[] stuArr = {
      new Student("나자바", true,  1, 1, 300),   
      new Student("김지미", false, 1, 1, 250),   
      new Student("김자바", true,  1, 1, 200),   
      new Student("이지미", false, 1, 2, 150),   
      new Student("남자바", true,  1, 2, 100),   
      new Student("안지미", false, 1, 2,  50),   
      new Student("황지미", false, 1, 3, 100),   
      new Student("강지미", false, 1, 3, 150),   
      new Student("이자바", true,  1, 3, 200),   

      new Student("나자바", true,  2, 1, 300),   
      new Student("김지미", false, 2, 1, 250),   
      new Student("김자바", true,  2, 1, 200),   
      new Student("이지미", false, 2, 2, 150),   
      new Student("남자바", true,  2, 2, 100),   
      new Student("안지미", false, 2, 2,  50),   
      new Student("황지미", false, 2, 3, 100),   
      new Student("강지미", false, 2, 3, 150),   
      new Student("이자바", true,  2, 3, 200)  
    };

    System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
    Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
                                                 .collect(groupingBy(Student::getBan));
    
    for(List<Student> ban : stuByBan.values()) {
      for(Student s : ban) {
        System.out.println(s);
      }
    }

    System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
    Map<Student.Level, List<Student>> stuByLevel = Stream.of(stuArr)
        .collect(groupingBy(s-> {
             if(s.getScore() >= 200)      return Student.Level.HIGH;
             else if(s.getScore() >= 100) return Student.Level.MID;
             else                         return Student.Level.LOW;
        }));

    TreeSet<Student.Level> keySet = new TreeSet<>(stuByLevel.keySet());

    for(Student.Level key : keySet) {
      System.out.println("[" + key + "]");

      for(Student s : stuByLevel.get(key))
        System.out.println(s);
      System.out.println();
    }

    System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
    Map<Student.Level, Long> stuCntByLevel = Stream.of(stuArr)
        .collect(groupingBy(s-> {
             if(s.getScore() >= 200)      return Student.Level.HIGH;
             else if(s.getScore() >= 100) return Student.Level.MID;
             else                         return Student.Level.LOW;
        }, counting()));

    for(Student.Level key : stuCntByLevel.keySet())
      System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
    System.out.println();
/*
    for(List<Student> level : stuByLevel.values()) {
      System.out.println();
      for(Student s : level) {
        System.out.println(s);
      }
    }
*/
    System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
    Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan =
      Stream.of(stuArr)
        .collect(groupingBy(Student::getHak,
             groupingBy(Student::getBan)
        ));

    for(Map<Integer, List<Student>> hak : stuByHakAndBan.values()) {
      for(List<Student> ban : hak.values()) {
        System.out.println();
        for(Student s : ban)
          System.out.println(s);
      }
    }

    System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
    Map<Integer, Map<Integer, Student>> topStuByHakAndBan = Stream.of(stuArr)
        .collect(groupingBy(Student::getHak,
             groupingBy(Student::getBan,
              collectingAndThen(
                maxBy(comparingInt(Student::getScore)),
                Optional::get
              )
            )
        ));

    for(Map<Integer, Student> ban : topStuByHakAndBan.values())
      for(Student s : ban.values())
        System.out.println(s);

    System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
    Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(stuArr)
      .collect(groupingBy(s-> s.getHak() + " - " + s.getBan(),
          mapping(s-> {
             if(s.getScore() >= 200)      return Student.Level.HIGH;
             else if(s.getScore() >= 100) return Student.Level.MID;
             else                         return Student.Level.LOW;
          } , toSet())
      ));

     Set<String> keySet2 = stuByScoreGroup.keySet();

    for(String key : keySet2) {
      System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
    }
  }  // main의 끝
}

/*
 * 실행 결과
1. 단순그룹화(반별로 그룹화)
[나자바, 남, 1학년 1반, 300점]
[김지미, 여, 1학년 1반, 250점]
[김자바, 남, 1학년 1반, 200점]
[나자바, 남, 2학년 1반, 300점]
[김지미, 여, 2학년 1반, 250점]
[김자바, 남, 2학년 1반, 200점]
[이지미, 여, 1학년 2반, 150점]
[남자바, 남, 1학년 2반, 100점]
[안지미, 여, 1학년 2반,  50점]
[이지미, 여, 2학년 2반, 150점]
[남자바, 남, 2학년 2반, 100점]
[안지미, 여, 2학년 2반,  50점]
[황지미, 여, 1학년 3반, 100점]
[강지미, 여, 1학년 3반, 150점]
[이자바, 남, 1학년 3반, 200점]
[황지미, 여, 2학년 3반, 100점]
[강지미, 여, 2학년 3반, 150점]
[이자바, 남, 2학년 3반, 200점]

2. 단순그룹화(성적별로 그룹화)
[HIGH]
[나자바, 남, 1학년 1반, 300점]
[김지미, 여, 1학년 1반, 250점]
[김자바, 남, 1학년 1반, 200점]
[이자바, 남, 1학년 3반, 200점]
[나자바, 남, 2학년 1반, 300점]
[김지미, 여, 2학년 1반, 250점]
[김자바, 남, 2학년 1반, 200점]
[이자바, 남, 2학년 3반, 200점]

[MID]
[이지미, 여, 1학년 2반, 150점]
[남자바, 남, 1학년 2반, 100점]
[황지미, 여, 1학년 3반, 100점]
[강지미, 여, 1학년 3반, 150점]
[이지미, 여, 2학년 2반, 150점]
[남자바, 남, 2학년 2반, 100점]
[황지미, 여, 2학년 3반, 100점]
[강지미, 여, 2학년 3반, 150점]

[LOW]
[안지미, 여, 1학년 2반,  50점]
[안지미, 여, 2학년 2반,  50점]


3. 단순그룹화 + 통계(성적별 학생수)
[MID] - 8명, [HIGH] - 8명, [LOW] - 2명, 

4. 다중그룹화(학년별, 반별)

[나자바, 남, 1학년 1반, 300점]
[김지미, 여, 1학년 1반, 250점]
[김자바, 남, 1학년 1반, 200점]

[이지미, 여, 1학년 2반, 150점]
[남자바, 남, 1학년 2반, 100점]
[안지미, 여, 1학년 2반,  50점]

[황지미, 여, 1학년 3반, 100점]
[강지미, 여, 1학년 3반, 150점]
[이자바, 남, 1학년 3반, 200점]

[나자바, 남, 2학년 1반, 300점]
[김지미, 여, 2학년 1반, 250점]
[김자바, 남, 2학년 1반, 200점]

[이지미, 여, 2학년 2반, 150점]
[남자바, 남, 2학년 2반, 100점]
[안지미, 여, 2학년 2반,  50점]

[황지미, 여, 2학년 3반, 100점]
[강지미, 여, 2학년 3반, 150점]
[이자바, 남, 2학년 3반, 200점]

5. 다중그룹화 + 통계(학년별, 반별 1등)
[나자바, 남, 1학년 1반, 300점]
[이지미, 여, 1학년 2반, 150점]
[이자바, 남, 1학년 3반, 200점]
[나자바, 남, 2학년 1반, 300점]
[이지미, 여, 2학년 2반, 150점]
[이자바, 남, 2학년 3반, 200점]

6. 다중그룹화 + 통계(학년별, 반별 성적그룹)
[1 - 3][MID, HIGH]
[1 - 2][MID, LOW]
[2 - 3][MID, HIGH]
[2 - 2][MID, LOW]
[1 - 1][HIGH]
[2 - 1][HIGH]
 */