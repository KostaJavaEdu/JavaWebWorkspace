package kosta.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(1);
		String key = request.getParameter("key");
		//System.out.println(key);
		Controller con = null;
		if(key.equals("insert")) {
			//등록기능
			con = new InsertController();
		}else if(key.equals("select")) {
			//검색기능
			con = new SelectController();
		}else if(key.equals("delete")) {
			//삭제기능
			con = new DeleteController();
		}else if(key.equals("update")) {
			con = new UpdateController();
		}
		
		ModelAndView mv = con.handleRequest(request, response);
		if(mv.isRedirect()) { //Redirect방식
			response.sendRedirect(mv.getViewName());
		}else { //forward방식
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}
}
