package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UpdateController 호출됨...");
		//수정기능
		request.setAttribute("message", "수정한 후에 select page로 왔어요");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=select");
		
		return mv;
	}

}
