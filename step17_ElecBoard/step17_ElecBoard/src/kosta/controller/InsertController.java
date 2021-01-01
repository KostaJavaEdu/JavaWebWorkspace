package kosta.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext application = request.getServletContext();
		String saveDir=application.getRealPath("/save");
		String encoding="UTF-8";
		int maxSize = 1024*1024*100; //100M
		MultipartRequest m = 
				new MultipartRequest(request, saveDir, maxSize, encoding, 
						new DefaultFileRenamePolicy());
		
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		int price = Integer.parseInt(m.getParameter("price"));
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		description.replace("<", "&lt;");
		
		
		Electronics elec = new Electronics(modelNum, modelName, price, description, password);
		
		//만약 파일 첨부가 되었다면
		if(m.getFilesystemName("file")!=null) {
			elec.setFname(m.getFilesystemName("file"));
			elec.setFsize((int)m.getFile("file").length());
		}
		ElectronicsService.insert(elec);
		
		ModelAndView mv = new ModelAndView("elec", true);
		return mv;
	}
}
