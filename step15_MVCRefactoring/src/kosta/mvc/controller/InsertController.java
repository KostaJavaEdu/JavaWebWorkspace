package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController ȣ���...");
		//��Ͽ� ���õ� ���.. -> service -> dao
		
		ModelAndView mv = new ModelAndView("insertResult.jsp", true);
		return mv;
	}

}
