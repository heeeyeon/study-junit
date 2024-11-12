package com.dsa.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.dsa.vo.Score;
import com.dsa.vo.Student;

public class Academy_Service {

	private TreeSet<Student> studentList;
	private Scanner scan;

	public Academy_Service() {
		studentList = new TreeSet<>();
		scan = new Scanner(System.in);

		while (true) {
			mainMenu();

			int num = scan.nextInt();

			switch (num) {
				case 1 -> insertStudent();
				case 2 -> insertScore();
				case 3 -> selectStudent();
				case 4 -> selectScore();
				case 5 -> selectRank();
				case 0 -> System.exit(0);
			}
		}
	}

	// ---------------------------------------------------

	// 메인메뉴
	public void mainMenu() {
		System.out.println();
		System.out.println("[ DSA_ACADEMY ]");
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 성적 조회");
		System.out.println("5. 순위 조회");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
	}

	// 학생등록
	public void insertStudent() {
		System.out.println("\n[ 학생등록 ]");
		System.out.print("이름 입력 > ");
		String name = scan.next();
		int java = 0, db = 0, web = 0;
		while (true) {
			System.out.print("*Java : ");
			java = scan.nextInt();
			System.out.print("*DB   : ");
			db = scan.nextInt();
			System.out.print("*WEB  : ");
			web = scan.nextInt();
			if ((0 <= java && java <= 100) &&
					(0 <=   db && db   <= 100) &&
					(0 <=  web && web  <= 100)
			) {
				break;
			}
			System.out.println("점수는 0~100 점 이내로 입력하세요.");
		}
		Score score = new Score(java, db, web);

		Student student = new Student(name, score);
		boolean result = studentList.add(student);

		if (result)	System.out.println("등록되었습니다.");
		else		System.out.println("이미 등록된 정보입니다.");

//		for (Student s : studentList) {
//			System.out.println(s);
//		}
	}

	// 성적수정
	public void insertScore() {
		System.out.println("\n[ 성적수정 ]");
		System.out.print("학번 입력 > ");
		int stdNum = scan.nextInt();

		Iterator<Student> it = studentList.iterator();
		while (it.hasNext()) {
			Student info = it.next();
			if (info.getStdNum() == stdNum) {
				int java = 0, db = 0, web = 0;
				while (true) {
					System.out.print("*Java : ");
					java = scan.nextInt();
					System.out.print("*DB   : ");
					db = scan.nextInt();
					System.out.print("*WEB  : ");
					web = scan.nextInt();
					if ((0 <= java && java <= 100) &&
							(0 <=   db && db   <= 100) &&
							(0 <=  web && web  <= 100)
					) {
						break;
					}
					System.out.println("점수는 0~100 점 이내로 입력하세요.");
				}
				Score score = new Score(java, db, web);
				info.setScore(score);
				System.out.println("수정되었습니다.");
				return;
			}
		}
		System.out.println("학생정보가 없습니다.");
	}

	// 학생조회
	public void selectStudent() {
		System.out.println("\n[ 학생조회 ]");
		System.out.print("이름 입력 > ");
		String name = scan.next();

		ArrayList<Student> searchList = new ArrayList<>();
		Iterator<Student> it = studentList.iterator();
		while (it.hasNext()) {
			Student info = it.next();
			if (info.getName().equals(name)) {
				searchList.add(info);
			}
		}

		if (searchList.isEmpty()) {
			System.out.println("학생정보가 없습니다.");
		} else {
			for (Student student : searchList) {
				System.out.println(student);
			}
		}
	}

	// 성적조회
	public void selectScore() {
		System.out.println("\n[ 성적조회 ]");
		System.out.print("학번 입력 > ");
		int stdNum = scan.nextInt();

		Iterator<Student> it = studentList.iterator();
		while (it.hasNext()) {
			Student info = it.next();
			if (info.getStdNum() == stdNum) {
				System.out.printf("==== %s(%d) ====\n"
						, info.getName(), info.getStdNum());
				String scoreInfo = String.format(
						"> [평균: %3.2f] 합계: %d - JAVA(%3d), DB(%3d), WEB(%3d)"
						, info.getScore().getAvg()
						, info.getScore().getSum()
						, info.getScore().getJava()
						, info.getScore().getDatabase()
						, info.getScore().getWeb());
				System.out.println(scoreInfo);
				return;
			}
		}
		System.out.println("학생정보가 없습니다.");
	}

	// 순위조회
	public void selectRank() {
		TreeSet<Student> sortSet = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.getScore().getSum() - s2.getScore().getSum()) * -1;
			}
		});
		sortSet.addAll(studentList);

		ArrayList<Student> sortList = new ArrayList<Student>(sortSet);

		if (sortList.isEmpty()) {
			System.out.println("학생정보가 없습니다.");
			return;
		}

		for (int i = 0; i < sortList.size(); i++) {
			String info = String.format(
					"[%2d위] %s_%d : 합계(%3d), 평균(%6.2f)"
					, i + 1
					, sortList.get(i).getName()
					, sortList.get(i).getStdNum()
					, sortList.get(i).getScore().getSum()
					, sortList.get(i).getScore().getAvg());
			System.out.println(info);
		}
	}
}
