package ex1122_homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardServlet extends HttpServlet{

	
	ServletContext application=null;
	
	@Override
	public void init() throws ServletException {
		List<BoardDTO> list =new ArrayList<BoardDTO>();
	       //���� 3�� �Խù� �ʱ�ġ �����
	       list.add(new BoardDTO("�ָ�", "����", new Date() ));
	       list.add(new BoardDTO("�ȳ�", "�޷�", new Date()));
	       list.add(new BoardDTO("����", "�±�", new Date()));
	        
	        //���⼭ application��ü�� ��� ����??? 
	         application = super.getServletContext();
	        //list�� application�� �����Ѵ�.
	         application.setAttribute("boarList", list);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardDTO> list = (List<BoardDTO>)application.getAttribute("boarList");
		
		HttpSession session = request.getSession();
		//�Ѿ���� ���޾Ƽ�... -> DTO�������� 
        //application�� �ִ� list�� �߰��Ѵ�.
		list.add(new BoardDTO(request.getParameter("content"), 
					session.getAttribute("id").toString(), new Date()));
		//application.setAttribute("boarList", list);
        //�̵��Ѵ�. (index.jsp�̵��Ѵ�)
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("top.location.href='index.jsp';");
		out.println("</script>");
	}
}
