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
	       //샘플 3개 게시물 초기치 만들기
	       list.add(new BoardDTO("주말", "수녕", new Date() ));
	       list.add(new BoardDTO("안녕", "메롱", new Date()));
	       list.add(new BoardDTO("평일", "굿굿", new Date()));
	        
	        //여기서 application객체를 어떻게 구해??? 
	         application = super.getServletContext();
	        //list를 application에 저장한다.
	         application.setAttribute("boarList", list);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardDTO> list = (List<BoardDTO>)application.getAttribute("boarList");
		
		HttpSession session = request.getSession();
		//넘어오는 값받아서... -> DTO생성한후 
        //application에 있는 list에 추가한다.
		list.add(new BoardDTO(request.getParameter("content"), 
					session.getAttribute("id").toString(), new Date()));
		//application.setAttribute("boarList", list);
        //이동한다. (index.jsp이동한다)
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("top.location.href='index.jsp';");
		out.println("</script>");
	}
}
