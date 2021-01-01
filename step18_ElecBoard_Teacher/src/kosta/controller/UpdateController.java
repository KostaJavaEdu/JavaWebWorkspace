package kosta.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException {
		 String modelNum = request.getParameter("modelNum");
		 String modelName = request.getParameter("model_name");
		 String price = request.getParameter("price");
		 String description = request.getParameter("description");
		 String password = request.getParameter("password");
		 
        Electronics elec = 
            new Electronics(modelNum, modelName, 
       		Integer.parseInt(price), description, password);
      
        ElectronicsService.update(elec);
        
        String url=null;
		try {
			url = "elec?command=read&modelNum="+URLEncoder.encode(modelNum,"UTF-8")+"&flag=1";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ModelAndView mv = new ModelAndView(url,true);
        
		return mv;
	}

}
