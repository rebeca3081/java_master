package com.yedam.common;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.book.service.BookService;
import com.yedam.book.serviceImpl.BookServiceImpl;
import com.yedam.book.vo.BookVO;

public class MainExe {

	public static void main(String[] args) {
BookService svc = new BookServiceImpl();
		
		List<BookVO> list = svc.bookList();
		
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));

	}

}
