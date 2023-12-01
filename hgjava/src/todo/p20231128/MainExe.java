package todo.p20231128;

// 게시판app 실행 클래스
public class MainExe {

	public static void main(String[] args) {
		BoardApp app = BoardApp.getInstance(); // 싱글톤기법
		app.start();
	}

}
