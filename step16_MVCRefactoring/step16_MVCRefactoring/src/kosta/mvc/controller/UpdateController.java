package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UpdateController ȣ���...");
		//�������
		request.setAttribute("message", "������ �Ŀ� select page�� �Ծ��");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=select");
		
		return mv;
	}

}
