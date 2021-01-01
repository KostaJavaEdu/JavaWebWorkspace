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
		
		//keyField , keyWord�ޱ�
		String keyField =  request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
	//System.out.println(keyField);
	//System.out.println(keyWord);
		
		/* daoȣ���ϰ� �� ����� ������ ��
		 * (list�� �̸����� ���� �κΰ˻��� ��ü�˻� �� �� 
		 * �ѹ��� list�� �̸����� ������ֱ� ����) memberSelect.jsp�� �̵�*/	
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.searchByKeyWord(keyField, keyWord);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}
}
