package ex1122.listener;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener를 구현 한 후 반드시 등록한다.
 * 	1) web.xml
 * 	2) @annotation
 * */
public class AppListener implements ServletContextListener {

	/**
	 * ServletContext가 생성될 때 호출됨
	 * 	: tomcat start될때 호출된다.
	 * */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("contextInitialized호출됨...");
		
		//각 나라별 국가코드 관리
		Map<String,String> map = new HashMap<String, String>();
		map.put("kr","대한민국");
		map.put("us","미국");
		map.put("jp","일본");
		map.put("cn","중국");
		map.put("fr","프랑스");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);

	}
	
	/**
	 * ServletContext가 소멸될 때 호출됨
	 * 	: tomcat stop될 때 호출된다. or 소스가 변경될때..
	 * */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed호출됨...");
	}
}
