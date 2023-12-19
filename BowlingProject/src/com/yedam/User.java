package com.yedam;

// 사용자 ID, PW에 관한 Class
public class User {
	// 필드
	private String userId;
	private int userPw;
	private String userName;
	private String rights;
	private String approval;

	// 생성자
	public User() {

	}

	public User(String uerId, int userPw, String userName, String rights, String approval) {
		this.userId = uerId;
		this.userPw = userPw;
		this.userName = userName;
		this.rights = rights;
		this.approval = approval;
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

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

} // end of class
