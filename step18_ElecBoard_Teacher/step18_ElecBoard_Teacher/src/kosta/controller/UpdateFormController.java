package kosta.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateFormController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		//�𵨹�ȣ �ޱ�
		 String modelNum = request.getParameter("modelNum");
		 
		 Electronics elec =
		  ElectronicsService.selectByModelnum(modelNum, false);//
		  
		 request.setAttribute("elec", elec);
        
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/update.jsp");
		return mv;
	}

}
