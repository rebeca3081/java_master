package chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TodoExe {

	public static void main(String[] args) {
		// 순번, 할일(Todo), DueDate : key, value (Todo 라는 클래스)
		Map<Integer, Todo> todoList = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("번호 할일 기한>> ");
			String input = sc.nextLine(); // 20 장보기 23-12-08 (엔터)
			String[] inpAry = input.split(" "); // 입력받은값 공백을 기준으로 자르기
			
			// 걸러낼 조건.
			if(inpAry.length != 2 && inpAry.length != 3) { // [2],[3]이면 아래로, 없으면 다시 위로
				System.out.println("입력값을 확인하세요");
				continue; // 반복문의 첫번째 위치로 가세요~
			}
			String order = inpAry[0]; // 순번
			String title = inpAry[1]; // 할일제목

			Todo todo = null;
			if (inpAry.length == 2) {
				todo = new Todo(title);
			} else if (inpAry.length == 3) {
				String dueDate = inpAry[2]; // 날짜
				// Date -> String -> Date
				// 2023-10-23 => format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate)); // .parse():문자열을 Date로
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} // end of if

			todoList.put(Integer.parseInt(order), todo);

			if (todoList.size() == 3) { //3건만 넣고 끝내겠습니다
				break; // while 반복문을 빠져나오는 조건이 있어야 함
			}
		}
		// 순번, 할일 출력
		System.out.println("번호  할일  DueDate");
		System.out.println("==========================");
		Set<Entry<Integer, Todo>> entry = todoList.entrySet();
		for (Entry<Integer, Todo> ent : entry) {
			System.out.println(ent.getKey() + "번  " + ent.getValue().toString());
		}

		System.out.println("end of prog.");

	}

}
