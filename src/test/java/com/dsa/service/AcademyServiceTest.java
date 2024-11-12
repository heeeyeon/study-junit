package com.dsa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.dsa.service.Academy_Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

class AcademyServiceTest {

    @DisplayName("학생 등록 테스트 : ")
    @Test
    void testInsertStudentAndInsertScore() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n85\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            Academy_Service service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        assertTrue(output.contains("등록되었습니다."), "출력문이 다르거나, 학생 등록이 실패했습니다.");
    }

}
