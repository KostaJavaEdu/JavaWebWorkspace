package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;


@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao를 호출하고 그 결과를 받아서 저장한 후 뷰로 이동
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.selectAll();
		
		//scope영역에 저장
		request.setAttribute("list", list);
		
		//이동
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}
}
