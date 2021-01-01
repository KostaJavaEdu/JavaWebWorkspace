package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class ReadElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// �𵨹�ȣ �ޱ� �׿� �ش��ϴ� ���� ������ read.jsp�� �� 
		String modelNum = request.getParameter("modelNum");
		String flag = request.getParameter("flag");
		boolean state = flag==null ? true : false;
		
		
		Electronics elec = ElectronicsService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", elec);
		
		ModelAndView mv = new ModelAndView("elecView/read.jsp", false);
		return mv;
	}

}
