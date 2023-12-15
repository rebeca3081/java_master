package com.yedam;

public class UserExe {
	// 필드
	private User[] users;
	
	
	// 생성자	
	UserExe(){
		users = new User[] {
				new User("jang", "1111", "장효은")
				, new User("kim", "2222", "김영민")
		};
	}
	
	// 메소드
	public User logIn(String id, String pw) {
		for(int i = 0; i < users.length; i++) {
			if (users[i] != null 
					&& users[i].getUserId().equals(id)
					&& users[i].getPasswd().equals(pw)) {
				return users[i];
			}
		}
		return null;
	} //end of login.

}
