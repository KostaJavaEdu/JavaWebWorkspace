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
			//��ϱ��
			con = new InsertController();
		}else if(key.equals("select")) {
			//�˻����
			con = new SelectController();
		}else if(key.equals("delete")) {
			//�������
			con = new DeleteController();
		}else if(key.equals("update")) {
			con = new UpdateController();
		}
		
		ModelAndView mv = con.handleRequest(request, response);
		if(mv.isRedirect()) { //Redirect���
			response.sendRedirect(mv.getViewName());
		}else { //forward���
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}
}
