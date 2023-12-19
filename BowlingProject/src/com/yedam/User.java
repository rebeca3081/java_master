package com.yedam;

// 사용자 ID, PW에 관한 Class
public class User {
	// 필드
	private String userId;
	private int userPw;
	private String userName;
	
	// 생성자
	public User() {
		
	}
	public User(String uerId, int userPw, String userName) {
		this.userId = uerId;
		this.userPw = userPw;
		this.userName = userName;
	}
	public User(String uerId, int userPw) {
		this.userId = uerId;
		this.userPw = userPw;
	}

	// getter,setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserPw() {
		return userPw;
	}

	public void setUserPw(int userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
			
		
}
