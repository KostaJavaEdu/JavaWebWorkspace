package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;


@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAOImpl();
		Member member = dao.searchById(id);
		
		if(member==null) {
			request.setAttribute("errMsg", "찾는정보가 없습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			request.setAttribute("searchById", member);
			request.getRequestDispatcher("read.jsp").forward(request, response);
		}
	}
}
