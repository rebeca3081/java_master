package todo.p20231206pro;

import lombok.Data;

@Data
public class Product {
	// 필드
	private String productCode; // P001
	private String productName;
	private int price;
	
	// 생성자
	Product(String productCode, String productName, int price){
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
	}
	
	// 메소드
	public void showInfo() {
		System.out.println(productCode + "  " + productName + "  " + price);
	}
	
}
