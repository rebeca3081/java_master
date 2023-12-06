package todo.p20231206pro;

import java.util.ArrayList;

public class ProductExe {
	// 컬렉션 필드
	private ArrayList<Product> products;

	// 생성자
	ProductExe() {
		products = new ArrayList<>();
		// 초기값
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N002", "다이어리", 3000));
	}

	// 메소드
	// 1.추가
	boolean addProduct(Product pro) {
		return products.add(pro);
	}

	// 2.목록반환
	ArrayList<Product> getProductList(){
		return products;
	}
	// 3.수정
	boolean modifyProduct(String code, int price) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductCode().equals(code)) {
				products.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}

}
