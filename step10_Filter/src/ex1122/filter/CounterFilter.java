package ex1122.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "clickCounter.properties")
		})
public class CounterFilter implements Filter {

	Properties pro = new Properties();
	String fileName;
	String path;
	public void init(FilterConfig fConfig) throws ServletException {
		fileName = fConfig.getInitParameter("fileName");
		
		ServletContext application = fConfig.getServletContext();
		path = application.getRealPath("/");
		
		File file = new File(path+"/"+fileName);
		
		try {
		  if(!file.exists()) {
			file.createNewFile();
		  }
		  
		  //파일을 읽어서 Properties에 저장
		  pro.load(new FileInputStream(file));
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * -병렬처리 프로세스를 분산시켜 좀더 빠르게 작업을 수행할 수 있도록 하는 것
	 * jdk1.5에서 추가 : java.util.cocurrent.*;
	 * 
	 * Executor : 기본 스레드 제공
	 * 
	 * ExecutorService : Executor 인터페이스를 확장해서 
	 * 	스레드의 라이프사이클 관리를 담당함
	 *  (생성 ~ 소멸되기까지 관련된 메소드를 제공함)
	 * */
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청된 주소 가져오기
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURL().toString();
		
		service.execute(new Runnable() {
			@Override
			public void run() {
				
				//url(key)에 해당하는 value를 찾는다.
				String value = pro.getProperty(url);
				if(value==null) {
					pro.setProperty(url, "1"); //자료구조를 변경한거지 실제 파일을 변경한건 아냐
				}else {
					int count = Integer.parseInt(value)+1;
					pro.setProperty(url, count+"");
				}
				try {
					//파일에 최종 저장
					FileWriter fw = new FileWriter(path+"/"+fileName);
						pro.store(fw,"");
						fw.flush();
						fw.close();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
		chain.doFilter(request, response);
	}
	public void destroy() {
		
	}
}
