package com.yedam;

// 사용자 ID, PW에 관한 Class
public class User {
	// 필드
	private String userId;
	private String passwd;
	private String userName;
	
	// 생성자
		public User(String uerId, String passwd, String userName) {
			this.userId = uerId;
			this.passwd = passwd;
			this.userName = userName;
		}
		
		// getter
		public String getUserId() {
			return userId;
		}
		public String getPasswd() {
			return passwd;
		}
		public String getUserName() {
			return userName;
		}
}
