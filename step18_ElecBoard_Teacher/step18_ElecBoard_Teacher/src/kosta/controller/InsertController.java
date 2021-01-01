package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;
/**
 * 등록하기(파일첨부)
 * */
public class InsertController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException  , IOException{
		
		ModelAndView mv = new ModelAndView();
		
		ServletContext application = request.getServletContext();
		String saveDir=application.getRealPath("/save");
	    int maxSize=1024*1024*100;//100M
	    String encoding="UTF-8";
		
		MultipartRequest m = 
				new MultipartRequest(request, saveDir, maxSize, 
						encoding, new DefaultFileRenamePolicy());
		//넘어오는 값 받기
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		
		description = description.replace("<", "&lt;");
				
				
		Electronics elec = new Electronics(modelNum, modelName,
				Integer.parseInt(price), description, password);
		
		//만약 파일첨부가 되었다면.... 파일이름, 파일크기를 저장
		if(m.getFilesystemName("file")!=null) {
			//파일이름
			elec.setFname(m.getFilesystemName("file"));
			//파일크기
			elec.setFsize((int)m.getFile("file").length() );
		}
			
	   ElectronicsService.insert(elec);
	   
	   mv.setViewName("elec");//
	   mv.setRedirect(true);
		
		return mv;
	}

}




