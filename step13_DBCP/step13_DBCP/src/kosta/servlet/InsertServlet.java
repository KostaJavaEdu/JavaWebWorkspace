package kosta.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		//String date   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());

		if(id==null || name==null || pwd == null ||
				age == 0 || addr == null || phone == null ) {
			request.setAttribute("errMgs", "�Է°��� ������� �ʽ��ϴ�.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		
		//�Ѿ���� ������ �޾Ƽ� Member�� ����
		Member member = new Member(id, pwd, name, age, phone, addr, null);
		//��� ���� id �ߺ�üũ �Ѵ�.
		MemberDAO dao = new MemberDAOImpl();
		boolean result = dao.duplicateById(id);
		if(result) {//�ߺ��̴�.
			request.setAttribute("errMsg", id+"�� �̹� ������Դϴ�.");
			//error.jsp�̵�
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			//����ϱ�
			int reg = dao.insert(member);
			//System.out.println(result22);
			if(reg > 0 ) {
				response.sendRedirect("selectAll");
			}else {
				request.setAttribute("errMsg", "ȸ������ �����ϼ̽��ϴ�.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}
}
