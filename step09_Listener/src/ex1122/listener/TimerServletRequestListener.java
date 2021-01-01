package ex1122.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


@WebListener
public class TimerServletRequestListener implements ServletRequestListener {

	long ri, rd;
	public void requestInitialized(ServletRequestEvent arg0)  { 
        // System.out.println("requestInitialized call...");
         ri = System.nanoTime();
	    }
	
    public void requestDestroyed(ServletRequestEvent e)  { 
    	//System.out.println("ServletRequestEvent call..."); 
    	rd = System.nanoTime();
    	
    	ServletRequest sr = e.getServletRequest();
    	HttpServletRequest request = (HttpServletRequest)sr;
    	String url = request.getRequestURL().toString();
    	
    	System.out.println(url + "�� �ɸ�ns : " + (rd-ri));
    }
    
    /**
     * Dear ����
     * �ȳ��ϼ��� ���羾?
     * ���� ������ ����� ù�λ��� ����մϴ�.
     * ó���� �̸�ǥ�� ���� '����'?? ���� ������ �ȵǰڳ�...
     * �ڲ� ����� �̸��� Ʋ���� ����...
     * �̷����µ�, ���� ����� �̸��� �����̶�� ���� �˰�
     * ��!! ������ �� �б���!!! ��� �����߽��ϴ�.
     * ���羾 ���������� �츮 ������
     * �����̴� �� �Ϳ����� ��������
     * �� ������ �����̰����� ���� ���� �������ٵ� ^^
     * �׳��� �ǳ� ���������� �ְ�... ��� �� �Ȱ���....
     * ���������� 
     * ������ ���羾�� ������ �������ִ� ���� ������? ��������
     * �̰� ����������
     * �׷� �Ϳ�� ���羾 �ȴ��������˿�~~~~~~~~~~~~~~~~~~~~~~~~~
     */
}
