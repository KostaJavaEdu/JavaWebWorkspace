package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//넘어오는 값 모두 받기(모델번호, 가격, 모델이름, 내용, 비밀번호)
		String modelNum = request.getParameter("modelNum");
		int price = Integer.parseInt(request.getParameter("price"));
		String modelName = request.getParameter("model_name");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		Electronics elec = new Electronics(modelNum, modelName, price, description, password);
		//수정하기로 이동
		ElectronicsService.update(elec);
		
		//수정완료된 후 -> read.jsp이동
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elec?command=read&modelNum="+modelNum+"&flag=1");
		mv.setRedirect(true);
		return mv;
	}

}
