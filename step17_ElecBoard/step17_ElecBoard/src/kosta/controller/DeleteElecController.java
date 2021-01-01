package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.service.ElectronicsService;

public class DeleteElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//��й�ȣ, modelNum �Ѿ��
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		ElectronicsService.delete(modelNum, password);
		
		//�������� �� list.jsp�̵�
		ModelAndView mv = new ModelAndView("elec",true);
		return mv;
	}

}
