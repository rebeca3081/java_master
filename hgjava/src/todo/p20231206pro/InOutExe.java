package todo.p20231206pro;

import java.util.ArrayList;

public class InOutExe {
	// 컬렉션 필드
	private ArrayList<InOut> inOuts;
	
	//생성자
	InOutExe(){
		inOuts = new ArrayList<>();
	}
	
	// 메소드
	
	
	// 1.추가
	boolean addInOut(InOut inout) {
		return inOuts.add(inout);
	}

	// 2.목록반환
	ArrayList<InOut> getInOuttList(){
		return inOuts;
	}
	
	// 기능3- 구매
	boolean doSale(String inOutCode, int count) {
		for(int i = 0; i <inOuts.size(); i++) {
			if(inOuts.get(i).getInOutCode().equals(inOutCode)) {
				inOuts.get(i).setCount(count);
				return true;
			}
		}
		return false;
	}

	// 가능4- 판매//-10이 아니라 재고에서 수량 만큼 빠져야하는데 재고를 어디서 만들어주지...? -> 구매를 한게 재고..!!
	
	// 기능5- 재고
	boolean showCount() {
		return true;
	}
}
