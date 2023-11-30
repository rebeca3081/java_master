package todo.p20231128;

public class MainExe {

	public static void main(String[] args) {
		BoardApp app = BoardApp.getInstance(); // 싱글톤기법
		app.start();
		
		int num = 10;
		num = 20;
	}

}
