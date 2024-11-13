package com.dsa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

class AcademyServiceTest {

    Academy_Service service;

    @DisplayName("학생 등록 테스트 : 정상계")
    @Test
    void testInsertStudent() {
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
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "등록되었습니다.";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계1")
    @Test
    void testFailInsertStudent1() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n85\n90\n-95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계2")
    @Test
    void testFailInsertStudent2() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n85\n-90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계3")
    @Test
    void testFailInsertStudent3() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n-85\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계4")
    @Test
    void testFailInsertStudent4() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n85\n90\n195\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계5")
    @Test
    void testFailInsertStudent5() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n85\n190\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 테스트 : 이상계6")
    @Test
    void testFailInsertStudent6() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String studentInput = "1\n홍길동\n185\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 정상계")
    @Test
    void testInsertStudentAndInsertScore() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n85\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
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
        assertTrue(output.contains("수정되었습니다."), "출력문이 다르거나, 성적 수정이 실패했습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계1")
    @Test
    void testFailInsertStudentAndInsertScore1() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n85\n90\n-95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계2")
    @Test
    void testFailInsertStudentAndInsertScore2() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n85\n-90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계3")
    @Test
    void testFailInsertStudentAndInsertScore3() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n-85\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계4")
    @Test
    void testFailInsertStudentAndInsertScore4() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n85\n90\n195\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계5")
    @Test
    void testFailInsertStudentAndInsertScore5() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n85\n190\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 등록 후 성적 수정 테스트 (등록번호가 20241001부터인 경우 : 이상계6")
    @Test
    void testFailInsertStudentAndInsertScore6() {
        // 학생 등록 메뉴선택\이름입력\자바점수\디비점수\웹점수\수정메뉴선택\학번입력\자바점수\디비점수\웹점수\마지막개행
        String studentInput = "1\n홍길동\n85\n90\n95\n2\n20241001\n185\n90\n95\n";  // 이름과 점수 입력
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(studentInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "점수는 0~100 점 이내로 입력하세요.\r\n*Java :";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

    @DisplayName("학생 조회 테스트 : 이름 일치 정보 가져오기")
    @Test
    void testSelectStudent() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String inputStr;
        String studentInput = "1\n홍길동\n85\n90\n95\n";  // 이름과 점수 입력
        String callSelectStudent = "3\n홍길동\n";  // 3번메뉴 호출
        inputStr = studentInput + callSelectStudent;
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage1 = "학생정보가 없습니다";
        assertFalse(output.contains(expectedMessage1),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage1 + "'가 포함되었습니다.");
    }

    @DisplayName("성적 조회 테스트 : 학번 일치 정보 가져오기")
    @Test
    void testSelectScore1() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String inputStr;
        String studentInput = "1\n홍길동\n85\n90\n95\n";  // 이름과 점수 입력
        String callSelectScore = "4\n20241001\n";  // 4번메뉴 호출
        inputStr = studentInput + callSelectScore;
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage1 = "학생정보가 없습니다";
        assertFalse(output.contains(expectedMessage1),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage1 + "'가 포함되었습니다.");
    }

    @DisplayName("성적 조회 테스트 : 출력형식 확인하기")
    @Test
    void testSelectScore2() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String inputStr;
        String studentInput = "1\n홍길동\n85\n90\n95\n";  // 이름과 점수 입력
        String callSelectScore = "4\n20241001\n";  // 4번메뉴 호출
        inputStr = studentInput + callSelectScore;
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage1 = "홍길동(20241001)";
        String expectedMessage2 = "> [평균: 90.00] 합계: 270 - JAVA( 85), DB( 90), WEB( 95)";
        assertTrue(output.contains(expectedMessage1),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage1 + "'가 포함되지 않았습니다.");
        assertTrue(output.contains(expectedMessage2),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage2 + "'가 포함되지 않았습니다.");
    }

    @DisplayName("순위 조회 테스트 : ")
    @Test
    void testSelectRank() {
        // 학생 등록 시 입력할 값 (학생 이름과 성적)
        String inputStr;
        String studentInput1 = "1\n홍길동1\n11\n11\n12\n";  // 이름과 점수 입력
        String studentInput2 = "1\n홍길동2\n22\n22\n23\n";  // 이름과 점수 입력
        String studentInput3 = "1\n홍길동3\n33\n33\n34\n";  // 이름과 점수 입력
        String studentInput4 = "1\n홍길동4\n44\n44\n45\n";  // 이름과 점수 입력
        String callSelectRank = "5\n";  // 5번메뉴 호출
        inputStr = studentInput1 + studentInput2 + studentInput3 + studentInput4 + callSelectRank;
        // 가짜 입력과 출력을 설정
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(in);  // System.in을 가짜 입력으로 설정
        System.setOut(new PrintStream(outputStream));  // System.out을 가짜 출력으로 설정
        try {
            // Academy_Service 객체 새로 생성
            service = new Academy_Service();
        } catch (NoSuchElementException e) {
            // 필요한 경우 예외 처리
        } finally {
            // 원래의 System.in과 System.out 복원
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        // 출력된 결과 확인
        String output = outputStream.toString();
        String expectedMessage = "[ 1위] 홍길동4_20241004 : 합계(133), 평균( 44.33)\r\n" +
                "[ 2위] 홍길동3_20241003 : 합계(100), 평균( 33.33)\r\n" +
                "[ 3위] 홍길동2_20241002 : 합계( 67), 평균( 22.33)\r\n" +
                "[ 4위] 홍길동1_20241001 : 합계( 34), 평균( 11.33)";
        assertTrue(output.contains(expectedMessage),
                "실패: 출력된 메시지 '" + output + "'에 '" + expectedMessage + "'가 포함되지 않았습니다.");
    }

}
