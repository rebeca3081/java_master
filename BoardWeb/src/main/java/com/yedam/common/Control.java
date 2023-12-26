package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {

	// execute() 정의
	public void execute(HttpServletRequest req, HttpServletResponse resp);
}
