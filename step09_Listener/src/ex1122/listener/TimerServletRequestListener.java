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
    	
    	System.out.println(url + "총 걸린ns : " + (rd-ri));
    }
    
    /**
     * Dear 수녕
     * 안녕하세요 수녕씨?
     * 저는 아직도 당신의 첫인상을 기억합니다.
     * 처음에 이름표를 보고 '수녕'?? 거참 한충희씨 안되겠네...
     * 자꾸 사람들 이름을 틀리고 으휴...
     * 이랬었는데, 정말 당신의 이름이 수녕이라는 것을 알고
     * 오!! 세상은 참 넓구나!!! 라고 생각했습니다.
     * 수녕씨 수녕수녕수녕 우리 막둥이
     * 수녕이는 참 귀여워요 히히히히
     * 내 동생이 수녕이같으면 정말 내가 잘해줄텐데 ^^
     * 그놈은 맨날 집구석에만 있고... 어디 좀 안가나....
     * 히히히히히 
     * 언젠간 수녕씨가 저에게 편지써주는 날이 오겠죠? 히히히히
     * 이거 지우지마요
     * 그럼 귀요미 수녕씨 안뇨오오오옹옹~~~~~~~~~~~~~~~~~~~~~~~~~
     */
}
