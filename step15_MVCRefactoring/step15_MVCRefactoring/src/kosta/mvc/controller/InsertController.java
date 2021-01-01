package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController 호출됨...");
		//등록에 관련된 기능.. -> service -> dao
		
		ModelAndView mv = new ModelAndView("insertResult.jsp", true);
		return mv;
	}

}
