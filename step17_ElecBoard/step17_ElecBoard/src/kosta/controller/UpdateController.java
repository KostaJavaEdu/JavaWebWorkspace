package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�Ѿ���� �� ��� �ޱ�(�𵨹�ȣ, ����, ���̸�, ����, ��й�ȣ)
		String modelNum = request.getParameter("modelNum");
		int price = Integer.parseInt(request.getParameter("price"));
		String modelName = request.getParameter("model_name");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		Electronics elec = new Electronics(modelNum, modelName, price, description, password);
		//�����ϱ�� �̵�
		ElectronicsService.update(elec);
		
		//�����Ϸ�� �� -> read.jsp�̵�
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elec?command=read&modelNum="+modelNum+"&flag=1");
		mv.setRedirect(true);
		return mv;
	}

}
