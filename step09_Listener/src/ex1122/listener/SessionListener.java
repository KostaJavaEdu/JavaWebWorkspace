package ex1122.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	/**
	 * 세션 시작될때...
	 * */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated call...");
	}
	
	/**
	 * 세션 종료될때...
	 * 	: session timeout이 될 때 호출
	 * 	: session.invalidate() 했을 때 
	 *  : 브라우저 창을 닫았을 때는 호출되지 않는다.(바로 발생 안됨)
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed call...");
	}
}
