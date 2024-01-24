package com.serv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 람다식
 */
public class Lambda {
	
	public static void main(String[] args) {
		
		List<ReviewVO> review = new ArrayList<>();
		review.add(new ReviewVO("리뷰1","강산"));
		review.add(new ReviewVO("리뷰2","효은"));
		review.add(new ReviewVO("리뷰3","영민"));
		
		// 정렬
		review.sort(new ReviewCompare());
		System.out.println(review);
	}
}

class ReviewCompare implements Comparator<ReviewVO> {

	//Comparator<ReviewVO> interface의 메소드를 구현해서 관계성을 유지해야함
	@Override
	public int compare(ReviewVO o1, ReviewVO o2) {
		return o1.getContent().compareTo(o2.getContent()); // o1에 있는 이름와 o2에 이름을 비교해서 
	}
	
}