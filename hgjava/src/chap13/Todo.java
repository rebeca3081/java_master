package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	// 필드
	private String todo;
	private Date dueDate;

	// 생성자-1
	Todo(String todo) {
		this.todo = todo;
		this.dueDate = new Date(); // 년도, 월, 일, 시:분:초
	}

	// 생성자-2
	Todo(String todo, Date dueDate) {
		this.todo = todo;
		this.dueDate = dueDate;
	}

	// toString 재정의
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return todo + "  " + sdf.format(dueDate);
	}
}
