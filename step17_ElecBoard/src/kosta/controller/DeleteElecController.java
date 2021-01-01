package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.service.ElectronicsService;

public class DeleteElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//비밀번호, modelNum 넘어옴
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		ElectronicsService.delete(modelNum, password);
		
		//삭제성공 후 list.jsp이동
		ModelAndView mv = new ModelAndView("elec",true);
		return mv;
	}

}
