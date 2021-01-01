package kosta.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.service.ElectronicsService;

public class DeleteElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException{
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		
		String path = request.getServletContext().getRealPath("/save");
		ElectronicsService.delete(modelNum, password, path );
		
		//삭제성공후에 list.jsp이동
		ModelAndView mv = new ModelAndView("elec" , true);
		
		return mv;
	}

	

}
