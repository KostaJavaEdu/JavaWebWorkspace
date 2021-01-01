package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;


public class ReadElecController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException {
		String modelNum =  request.getParameter("modelNum");
		String flag = request.getParameter("flag");
         boolean state = flag==null ?  true : false;
      
         Electronics elec =
        	ElectronicsService.selectByModelnum(modelNum, state);//��ȸ������
		
         request.setAttribute("elec", elec);//�信�� ${elec.�Ӽ�}
		 
		 ModelAndView mv = new ModelAndView();
         mv.setViewName("elecView/read.jsp");
		 return mv;
	}

}
