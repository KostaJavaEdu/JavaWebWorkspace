package ex1122.listener;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener�� ���� �� �� �ݵ�� ����Ѵ�.
 * 	1) web.xml
 * 	2) @annotation
 * */
public class AppListener implements ServletContextListener {

	/**
	 * ServletContext�� ������ �� ȣ���
	 * 	: tomcat start�ɶ� ȣ��ȴ�.
	 * */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("contextInitializedȣ���...");
		
		//�� ���� �����ڵ� ����
		Map<String,String> map = new HashMap<String, String>();
		map.put("kr","���ѹα�");
		map.put("us","�̱�");
		map.put("jp","�Ϻ�");
		map.put("cn","�߱�");
		map.put("fr","������");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);

	}
	
	/**
	 * ServletContext�� �Ҹ�� �� ȣ���
	 * 	: tomcat stop�� �� ȣ��ȴ�. or �ҽ��� ����ɶ�..
	 * */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyedȣ���...");
	}
}
