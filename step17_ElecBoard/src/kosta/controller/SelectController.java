package kosta.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;


public class SelectController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			List<Electronics> list = ElectronicsService.selectAll();
			request.setAttribute("list", list);
			
		ModelAndView mv = new ModelAndView("elecView/list.jsp", false);
		return mv;
	}
}
