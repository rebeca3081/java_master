package com.yedam;

public class Comment {
	// 필드
	private int commentNo;
	private String commntCon;
	private String commentWriter;
	private String commentDate;
	
	
	// 생성자
	public Comment() {
		
	}
	public Comment(int commentNo, String commntCon, String commentWriter, String commentDate) {
		this.commentNo = commentNo;
		this.commntCon = commntCon;
		this.commentWriter = commentWriter;
		this.commentDate = commentDate;
	}
	
	// 메소드
	public void showComentInfo() {
		System.out.printf("%4d   \t  %s   \t%s \t%s \n", commentNo, commntCon, commentWriter, commentDate);
	}

	// getter,setter
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommntCon() {
		return commntCon;
	}

	public void setCommntCon(String commntCon) {
		this.commntCon = commntCon;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
		
	
} //end of class
