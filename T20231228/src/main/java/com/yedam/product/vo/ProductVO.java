package com.yedam.product.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode; // P2023-01
	private String productName;
	private String productDesc;
	private int originPrice;
	private int salePrice;
	private int likeIt; // 추천수 (5 ~ 1)
	private String image;
	
	
}
