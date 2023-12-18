package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {
	// 필드
	private String gameNo;
	// private String scoreNo;
	private int score1G;
	private int score2G;
	private int score3G;
	private int avg;
	private Date bowlingDate;
	
	
	// 생성자
	public Score() {
		
	}
	
	public Score(String gameNo, int score1G, int score2G, int score3G, Date bowlingDate) {
		this.gameNo = gameNo;
		this.score1G = score1G;
		this.score2G = score2G;
		this.score3G = score3G;
		this.bowlingDate = bowlingDate;
	}

	// 메소드
	public void showScoreInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.printf("%s \t %d \t\t %d \t\t %d \t\t %d \t\t %s \n", gameNo, score1G, score2G, score3G, avg, sdf.format(bowlingDate));
	}

	// getter,setter
	public String getGameNo() {
		return gameNo;
	}

	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}

	public int getScore1G() {
		return score1G;
	}

	public void setScore1G(int score1g) {
		score1G = score1g;
	}

	public int getScore2G() {
		return score2G;
	}

	public void setScore2G(int score2g) {
		score2G = score2g;
	}

	public int getScore3G() {
		return score3G;
	}

	public void setScore3G(int score3g) {
		score3G = score3g;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public Date getBowlingDate() {
		return bowlingDate;
	}

	public void setBowlingDate(Date bowlingDate) {
		this.bowlingDate = bowlingDate;
	}
	
	
	
}// end of class
