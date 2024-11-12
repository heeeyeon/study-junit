package com.dsa.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ScoreTest {

    private Score score;

    @BeforeEach
    public void setUp() {
        // 예제 점수 입력 (JAVA: 85, DB: 90, WEB: 95)
        score = new Score(85, 90, 95);
    }

    @DisplayName("필드 변수명 접근제한자 static 여부 확인 : ")
    @Test
    public void testFieldNamesModifiersAndTypes() {
        Class<?> clazz = Score.class;

        // 필드명, 접근 제한자, 자료형을 정의한 배열
        Object[][] expectedFields = {
                {"java", Modifier.PRIVATE, int.class},
                {"database", Modifier.PRIVATE, int.class},
                {"web", Modifier.PRIVATE, int.class},
                {"sum", Modifier.PRIVATE, int.class},
                {"avg", Modifier.PRIVATE, double.class}
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

    @DisplayName("자바점수 getter Test")
    @Test
    public void testGetJavaScore() {
        // JAVA 점수가 올바르게 반환되는지 확인
        assertEquals(85, score.getJava());
    }

    @DisplayName("자바점수 setter Test")
    @Test
    public void testSetJavaScore() {
        // JAVA 점수를 변경하고 제대로 반영되는지 확인
        score.setJava(75);
        assertEquals(75, score.getJava());
    }

    @DisplayName("DB 점수 getter Test")
    @Test
    public void testGetDatabaseScore() {
        // DB 점수가 올바르게 반환되는지 확인
        assertEquals(90, score.getDatabase());
    }

    @DisplayName("DB 점수 setter Test")
    @Test
    public void testSetDatabaseScore() {
        // DB 점수를 변경하고 제대로 반영되는지 확인
        score.setDatabase(80);
        assertEquals(80, score.getDatabase());
    }

    @DisplayName("Web 점수 getter Test")
    @Test
    public void testGetWebScore() {
        // WEB 점수가 올바르게 반환되는지 확인
        assertEquals(95, score.getWeb());
    }

    @DisplayName("Web 점수 setter Test")
    @Test
    public void testSetWebScore() {
        // WEB 점수를 변경하고 제대로 반영되는지 확인
        score.setWeb(85);
        assertEquals(85, score.getWeb());
    }

    @DisplayName("점수합계 getter Test")
    @Test
    public void testSumCalculation() {
        // sum이 세 과목의 점수 합과 일치하는지 확인
        int expectedSum = 85 + 90 + 95;
        assertEquals(expectedSum, score.getSum());
    }

    @DisplayName("점수평균 getter Test")
    @Test
    public void testAverageCalculation() {
        // avg가 세 과목의 점수 평균과 일치하는지 확인
        double expectedAvg = (85 + 90 + 95) / 3.0;
        assertEquals(expectedAvg, score.getAvg(), 0.01); // 소수점 2자리까지 허용 오차 설정
    }

    @DisplayName("출력문 검증")
    @Test
    public void testToString() {
        // toString 메서드의 출력이 예상과 일치하는지 확인
        String expectedString = "JAVA( 85), DB( 90), WEB( 95)";
        assertEquals(expectedString, score.toString());
    }

    @DisplayName("점수합계 setter 부재 Test")
    @Test
    public void testNoSetSumMethod() {
        // Score 클래스에 setSum 메서드가 없는지 확인
        Method[] methods = Score.class.getDeclaredMethods();
        boolean hasSetSum = false;
        for (Method method : methods) {
            if (method.getName().equals("setSum")) {
                hasSetSum = true;
                break;
            }
        }
        assertFalse(hasSetSum, "Score 클래스에는 setSum 메서드가 없어야 합니다.");
    }

    @DisplayName("점수평균 setter 부재 Test")
    @Test
    public void testNoSetAvgMethod() {
        // Score 클래스에 setAvg 메서드가 없는지 확인
        Method[] methods = Score.class.getDeclaredMethods();
        boolean hasSetAvg = false;
        for (Method method : methods) {
            if (method.getName().equals("setAvg")) {
                hasSetAvg = true;
                break;
            }
        }
        assertFalse(hasSetAvg, "Score 클래스에는 setAvg 메서드가 없어야 합니다.");
    }
}
