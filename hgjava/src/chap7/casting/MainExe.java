package chap7.casting;

public class MainExe {

	public static void main(String[] args) {
		
		double d1 = 100; // 8byte = 4byte
		int n1 = (int) 100.0;
		
		// promotion : 자동형변환 -> 부모클래스 = 자식클래스를 담을 수 있음
		Parent p1 = new Child(); // Parent p1 = (Parent) new Child();

		// casting : 강제형변환 -> 자식클래스 = 부모클래스를 담을 때는 자식클래스로 강제형변환 필요
		// Child c1 = (Child) new Parent();
		
		// 강제형변환
		// 자식인스턴스는 강제형변환 OK
		// 부모인스컨스는 강제형변환 NG...ㅋ
		// 에러: 컴파일에러/ 실행에러
		Parent p2 = new Parent();
		Child c2 =  new Child();
		
		// p2 = c2; // 자동형변환
		// ★형변환 하기전에 인스턴스 유형을 체크!
		if(p2 instanceof Child) { //(객체 instanceof 타입)
			Child c3 = (Child) p2;			
		}
		
		System.out.println("end of prog");

	}

}
