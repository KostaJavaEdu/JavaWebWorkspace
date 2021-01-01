package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAOImpl();
		
		int result = dao.delete(id);
		if(result>0) {
			response.sendRedirect("selectAll");
		}else {
			request.setAttribute("errMgs", id + "삭제할 수 없습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
