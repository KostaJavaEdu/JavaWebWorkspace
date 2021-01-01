package ex1122.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.glass.ui.Application;


@WebListener
public class UserCounterListener implements ServletContextListener, HttpSessionListener {
	public void contextDestroyed(ServletContextEvent sce)  {}
   
	/**
	 * application영역에 count를 저장한다.
	 * (type : AtomicInteger)
	 * 
	 * 현재 접속자 수 : 
	 * 		로그인 한 사람으로 볼 것인지, 그냥 방문자로 볼 것인지 로직 달라짐
	 * 회원접속자 수 만 증가시킬 경우 : sessionCreate가 제대로 동작되지 않을 수 있음
	 * 	-> 로그인 됐을 때 application불러와서 증가, 감소 시켜주면 돼
	 * 
	 * but loginForm.html로 하면 접속되자마자 증가하지는 않아 jsp에서만 증가!!
	 * */
	ServletContext appliaction;
	
	public void contextInitialized(ServletContextEvent sce)  { 
		appliaction = sce.getServletContext();
        appliaction.setAttribute("count", new AtomicInteger(0));
    }
	
	/**
	 * application에 저장되어 있는 count를 가져와서 1 증가시킨다.
	 * */
    public void sessionCreated(HttpSessionEvent se)  { 
    	AtomicInteger at = (AtomicInteger)appliaction.getAttribute("count");
    	int asc = at.incrementAndGet();
    	System.out.println("증가 후 값 : " + asc);
    }

    /**
	 * application에 저장되어 있는 count를 가져와서 1 감소시킨다.
	 * */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	AtomicInteger at = (AtomicInteger)appliaction.getAttribute("count");
    	int dec = at.decrementAndGet();
    	System.out.println("감소 후 값 : " + dec);
    }
}
