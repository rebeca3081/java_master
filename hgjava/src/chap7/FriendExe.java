package chap7;

public class FriendExe {
	// 필드
	Friend[] storage = new Friend[10]; // 배열선언

	// 1.등록 2.목록 3.조회

	// 등록 메소드
	public boolean addFriend(Friend friend) {
		// 배열에 추가
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = friend;
				return true;
			}
		}
		return false;
	}

	// 목록 메소드 => 클래스배열....
	public Friend[] friendList() {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				return storage;
			}
		}
		return null;
	}

	// 조회 메소드1 : 친구이름 중복제거
	// 결과값이 null여부로 체크(X)
	public Friend[] searchFriend(String name) {
		// 반환유형이 정해져있음.
		Friend[] result = new Friend[10]; // name만 있는 배열을 새로 담아줌
		int j = 0;
		// result에 값이 들어있는지 없는지 체크
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getName().equals(name)) {
				result[j++] = storage[i];
			}
		}
		return result;
	}

	// 조회 메소드2 : 연락처는 한 건만 반영
	// 결과값이 null여부로 체크.
	public Friend searchPhone(String phone) {
		for (Friend fnd : storage) {
			if (fnd != null && fnd.getPhone().equals(phone)) {
				return fnd;
			}
		}
		return null;
	}

}// end of class
