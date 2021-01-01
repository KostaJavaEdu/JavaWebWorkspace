package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController 호출...");
		
		//삭제기능 담당
		ModelAndView mv = new ModelAndView("index.html",true);
		
		return mv;
	}

}
