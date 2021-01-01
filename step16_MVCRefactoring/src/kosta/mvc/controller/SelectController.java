package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController 호출됨..");
		
		//검색기능....
		request.setAttribute("message", "검색 성공했어요...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp");
		return mv;
	}

}
