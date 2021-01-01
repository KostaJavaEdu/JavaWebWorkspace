package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�𵨹�ȣ �ޱ�
		String modelNum = request.getParameter("modelNum");
		Electronics elec = ElectronicsService.selectByModelnum(modelNum, false);
		request.setAttribute("elec",elec);
		
		//update.jsp�̵�
		ModelAndView mv = new ModelAndView("elecView/update.jsp", false);
		
		return mv;
	}
}
