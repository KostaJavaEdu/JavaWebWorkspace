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
	 * application������ count�� �����Ѵ�.
	 * (type : AtomicInteger)
	 * 
	 * ���� ������ �� : 
	 * 		�α��� �� ������� �� ������, �׳� �湮�ڷ� �� ������ ���� �޶���
	 * ȸ�������� �� �� ������ų ��� : sessionCreate�� ����� ���۵��� ���� �� ����
	 * 	-> �α��� ���� �� application�ҷ��ͼ� ����, ���� �����ָ� ��
	 * 
	 * but loginForm.html�� �ϸ� ���ӵ��ڸ��� ���������� �ʾ� jsp������ ����!!
	 * */
	ServletContext appliaction;
	
	public void contextInitialized(ServletContextEvent sce)  { 
		appliaction = sce.getServletContext();
        appliaction.setAttribute("count", new AtomicInteger(0));
    }
	
	/**
	 * application�� ����Ǿ� �ִ� count�� �����ͼ� 1 ������Ų��.
	 * */
    public void sessionCreated(HttpSessionEvent se)  { 
    	AtomicInteger at = (AtomicInteger)appliaction.getAttribute("count");
    	int asc = at.incrementAndGet();
    	System.out.println("���� �� �� : " + asc);
    }

    /**
	 * application�� ����Ǿ� �ִ� count�� �����ͼ� 1 ���ҽ�Ų��.
	 * */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	AtomicInteger at = (AtomicInteger)appliaction.getAttribute("count");
    	int dec = at.decrementAndGet();
    	System.out.println("���� �� �� : " + dec);
    }
}
