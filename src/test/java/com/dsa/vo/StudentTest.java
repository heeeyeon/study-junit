package com.dsa.vo;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student student1;
    private Student student2;
    private Score score;

    @BeforeEach
    public void setUp() {
        score = new Score(90, 80, 70);
        student1 = new Student("student1", score);
        student2 = new Student("student2", score);
    }
//
//    @DisplayName("고유번호 생성 여부 확인 : 2 실제 숫자 확인") // 테스트 실행 갯수에 따라 결과가 다르므로 생략함
//    @Test
//    public void testUniqueSerialNum2() {
//        // student1의 stdNum은 20241001, student2는 20241002 이어야 함을 테스트 (serialNum이 20241000에서 시작)
//        assertEquals(20241001, student1.getStdNum());
//        assertEquals(20241002, student2.getStdNum());
//
//    }

    @DisplayName("필드 변수명 접근제한자 static 여부 확인 : name")
    @Test
    public void testFieldNamesModifiersAndTypes() {
        Class<?> clazz = Student.class;

        // 필드명, 접근 제한자, 자료형을 정의한 배열
        Object[][] expectedFields = {
                {"ACADEMY", Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL, String.class},
                {"NUMBER", Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL, int.class},
                {"serialNum", Modifier.PRIVATE | Modifier.STATIC, int.class},
                {"name", Modifier.PRIVATE, String.class},
                {"stdNum", Modifier.PRIVATE, int.class},
                {"score", Modifier.PRIVATE, Score.class}
        };

        for (Object[] fieldData : expectedFields) {
            String fieldName = (String) fieldData[0];
            int expectedModifiers = (int) fieldData[1];
            Class<?> expectedType = (Class<?>) fieldData[2];
            boolean fieldExists = false;

            for (Field field : clazz.getDeclaredFields()) {
                if (field.getName().equals(fieldName)) {
                    fieldExists = true;

                    // 필드 접근 제한자 확인
                    assertEquals(expectedModifiers, field.getModifiers(),
                            "필드 " + fieldName + "의 접근 제한자가 예상과 다릅니다.");

                    // 필드 자료형 확인
                    assertEquals(expectedType, field.getType(),
                            "필드 " + fieldName + "의 자료형이 예상과 다릅니다.");
                    break;
                }
            }
            assertTrue(fieldExists, "필드 " + fieldName + "이(가) 존재하지 않습니다.");
        }

        // 총 필드 수 확인
        assertEquals(expectedFields.length, clazz.getDeclaredFields().length,
                "필드 수가 예상과 다릅니다.");
    }

    @DisplayName("필드 자료형 확인 : name")
    @Test
    public void testNameFieldType() {
        // name 필드는 String 타입이어야 한다.
        assertTrue(student1.getName() instanceof String);
    }

    @DisplayName("필드 자료형 확인 : score")
    @Test
    public void testScoreFieldType() {
        // score 필드는 Score 타입이어야 한다.
        assertTrue(student1.getScore() instanceof Score);
    }

    @DisplayName("필드 자료형 확인 : stdNum")
    @Test
    public void testStdNumFieldType() {
        // stdNum 필드는 int 타입이어야 한다.
        // 기본형 타입의 자료이므로 assertEquals를 사용하여 테스트한다.
        assertEquals(student1.getStdNum() > 0, true); // stdNum은 양수로 설정되어야 한다.
    }

    @DisplayName("생성자 확인 : ")
    @Test
    public void testStudentCreation() {
        // 주어진 이름과 점수로 Student 객체 생성
        Score score = new Score(90, 80, 70);
        Student student = new Student("John Doe", score);

        // 학생 이름, 학번, 점수 확인
        assertEquals("John Doe", student.getName());
        assertNotNull(student.getScore());
        assertEquals(90, student.getScore().getJava());
        assertEquals(80, student.getScore().getDatabase());
        assertEquals(70, student.getScore().getWeb());
    }

    @DisplayName("고유번호 생성 여부 확인 : 1 고유번호가 다른지 확인")
    @Test
    public void testUniqueSerialNum1() {
        // 각 객체의 stdNum이 다른지 확인하여 고유번호 생성 여부 테스트
        assertNotEquals(student1.getStdNum(), student2.getStdNum());
    }

    @DisplayName("고유번호 생성 여부 확인 : 3 고유번호가 1 차이나는지 확인")
    @Test
    public void testUniqueSerialNum3() {
        // 고유번호가 1 차이나는지 확인
        assertEquals(-1, student1.getStdNum()-student2.getStdNum());
    }

    @DisplayName("Equals() 동작 확인 : ")
    @Test
    public void testEqualsMethod() {
        // 다른 객체의 stdNum이 다르면 false를 반환하는지 테스트
        assertFalse(student1.equals(student2));

        // 같은 stdNum을 갖는 경우에는 true 반환 (예: 같은 student1 객체와 비교)
        assertTrue(student1.equals(student1));
    }

    @DisplayName("hashCode() 동작 확인 : ")
    @Test
    public void testHashCodeMethod() {
        // stdNum이 다르면 다른 해시코드를 반환하는지 테스트
        assertNotEquals(student1.hashCode(), student2.hashCode());

        // 같은 객체(student1)끼리의 해시코드가 동일한지 테스트
        assertEquals(student1.hashCode(), student1.hashCode());
    }

    @DisplayName("compareTo() 동작 확인 : ")
    @Test
    public void testCompareToMethod() {
        // 이름이 고정되어 있어 stdNum을 기준으로만 비교가 이뤄지는지 확인
        assertTrue(student1.compareTo(student2) < 0); // student1의 stdNum이 더 작으므로 음수 반환 기대
        assertTrue(student2.compareTo(student1) > 0); // student2의 stdNum이 더 크므로 양수 반환 기대
    }

    @DisplayName("출력문 확인 : ")
    @Test
    public void testToString() {
        Score score = new Score(90, 80, 70);
        Student student = new Student("John Doe", score);

        String expected = "[DSA-46th] 이름: John Doe, 학번: " + student.getStdNum() + ", 점수: " + score;
        assertEquals(expected, student.toString());
    }
}
