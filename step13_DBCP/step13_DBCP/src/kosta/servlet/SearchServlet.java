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


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//keyField , keyWord받기
		String keyField =  request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
	//System.out.println(keyField);
	//System.out.println(keyWord);
		
		/* dao호출하고 그 결과를 저장한 후
		 * (list란 이름으로 저장 부부검색과 전체검색 둘 다 
		 * 한번에 list란 이름으로 출력해주기 위해) memberSelect.jsp로 이동*/	
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.searchByKeyWord(keyField, keyWord);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}
}
