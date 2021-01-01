package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;
/**
 * ��ü�˻�
 * */
public class SelectController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException {
			//���� -> dao -> �� ��� list�� �����ϰ� list.jsp�̵�
	  List<Electronics>  list = 
					ElectronicsService.selectAll();
	   request.setAttribute("list", list);
		
	   ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/list.jsp");
		
		return mv;
		
	}


}
