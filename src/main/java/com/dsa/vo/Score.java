package com.dsa.vo;

/**
 * 성적 정보
 */
public class Score {

	private int java;			//JAVA 점수
	private int database;		//DB 점수
	private int web;			//WEB 점수
	private int sum;			//점수 총합
	private double avg;			//세 과목의 평균점수

	public Score(int java, int database, int web) {
		this.java = java;
		this.database = database;
		this.web = web;
		this.sum = this.java + this.database + this.web;
		this.avg = this.sum / 3.0;
	}

	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getDatabase() {
		return database;
	}
	public void setDatabase(int database) {
		this.database = database;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}

	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}

	@Override
	public String toString() {
		return String.format(
				"JAVA(%3d), DB(%3d), WEB(%3d)"
				, this.java, this.database, this.web);
	}
}
