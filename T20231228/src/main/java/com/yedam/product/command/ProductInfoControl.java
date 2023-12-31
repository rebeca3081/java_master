package com.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 상세정보
		String pno = req.getParameter("pno");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(pno);
		
		req.setAttribute("vo", vo);
		
		//
		List<ProductVO> topList = svc.productLikeList();
		req.setAttribute("productTopList", topList);
		
		
		try {
			req.getRequestDispatcher("product/productInfo.tiles").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
