package ex1122_homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *   ������ �����ϸ�  �̵��Ѵ�. (index.jsp�̵��Ѵ�)
         <script>
            top.location.href="index.jsp";
         </script>
 * */
public class LoginServlet extends HttpServlet{
	 String [][] mems={
			   {"choi","1234"},
		       {"sn0716","1234"},
		       {"suoung0716","1234"}};
	 
	 
	 @Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String userId = request.getParameter("userId");
		  String userPwd = request.getParameter("userPwd");
		  String userName = request.getParameter("userName");
		  
		  boolean state=false; //true�̸� ��ġ false�̸� ����ġ
		  for(int i=0; i<mems.length;i++) {
			  if(mems[i][0].equals(userId)&& mems[i][1].equals(userPwd)) {
				  
				  state=true;
				  break;
			  }
		  }
		  
		  if(state) {
			  HttpSession session = request.getSession();
				 session.setAttribute("id", userId);
				 session.setAttribute("name", userName);
				 session.setAttribute("loginTime", new Date().toLocaleString());
				 
				 PrintWriter out = response.getWriter();
				 out.println("<script>");
				 out.println("top.location.href='index.jsp';");   
		         out.println("</script>");
		  }else {
			  PrintWriter out = response.getWriter();
			  out.println("<script>");
			  out.println("alert('"+userName+"�� ������ Ȯ�����ּ���.');");
			  out.println("history.back();");
			  out.println("</script>");
		  }
 
		}
}
