package ex1122.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 서블릿 작성한후 등록
 *  1) web.xml
 *  2) @annotaion
 */

@WebServlet(
		urlPatterns = { "/loginCheck" }, 
		initParams = { 
				@WebInitParam(name = "dbId", value = "choi"), 
				@WebInitParam(name = "dbPwd", value = "1234")
		},
		loadOnStartup = 1)
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String dbId, dbPwd;
	public void init() throws ServletException {
		dbId = super.getInitParameter("dbId");
		dbPwd = super.getInitParameter("dbPwd");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 
		  request.setCharacterEncoding("UTF-8");
		  String userId = request.getParameter("userId");
		  String userPwd = request.getParameter("userPwd");
		  String userName = request.getParameter("userName");

		  if(dbId.equals(userId) && dbPwd.equals(userPwd)){
			  HttpSession session = request.getSession();
			  
			  session.setAttribute("id", userId);
			  session.setAttribute("name", userName);
			  session.setAttribute("loginTime", new Date().toLocaleString());
			  
			  //쿠키에 저장하기
			  Cookie co =new Cookie("cookieID", userId);
			  co.setMaxAge(60*60*24*365);
			  co.setPath("/");
			  response.addCookie(co);
			  
			 response.sendRedirect("user/LoginOk.jsp");
			 
		  }else{
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('"+userName+"님 정보를 확인해주세요.');");
			 out.println("history.back();");
			 out.println("</script>");
		  }

	
	}

}





