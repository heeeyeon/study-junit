package com.dsa.vo;

/**
 * 학생 정보
 */
public class Student implements Comparable<Student>{

	private static final String ACADEMY = "DSA";	//아카데미명
	private static final int NUMBER = 46;			//기수
	private static int serialNum = 20241000;		//고유번호
	private String name;							//이름
	private int	stdNum;								//학번
	private Score score;							//점수
	
	{
		serialNum++;
	}
	
	public Student(String name, Score score) {
		this.stdNum = serialNum;
		this.name = name;
		this.score = score;
	}
	
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getStdNum() {
		return stdNum;
	}

	@Override
	public int hashCode() {
		return this.stdNum;
	}
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		if (stdNum != other.stdNum)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Student s) {
//		return this.name.compareTo(s.getName());
		
		int nameComparison = this.name.compareTo(s.getName());
	    if (nameComparison != 0) {
	        return nameComparison;
	    } else {
	        return Integer.compare(this.stdNum, s.getStdNum());
	    }
	}

	@Override
	public String toString() {
		String info = String.format(
			"[%s-%sth] 이름: %s, 학번: %d, 점수: " + score
			, ACADEMY, NUMBER, name, stdNum
		);
		return info;
	}
}
