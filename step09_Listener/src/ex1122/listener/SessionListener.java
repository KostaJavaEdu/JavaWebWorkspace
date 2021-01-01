package ex1122.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	/**
	 * ���� ���۵ɶ�...
	 * */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated call...");
	}
	
	/**
	 * ���� ����ɶ�...
	 * 	: session timeout�� �� �� ȣ��
	 * 	: session.invalidate() ���� �� 
	 *  : ������ â�� �ݾ��� ���� ȣ����� �ʴ´�.(�ٷ� �߻� �ȵ�)
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed call...");
	}
}
