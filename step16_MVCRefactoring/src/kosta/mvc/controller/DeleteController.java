package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController ȣ��...");
		
		//������� ���
		ModelAndView mv = new ModelAndView("index.html",true);
		
		return mv;
	}

}
