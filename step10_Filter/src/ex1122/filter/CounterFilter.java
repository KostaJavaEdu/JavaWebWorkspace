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
		  
		  //������ �о Properties�� ����
		  pro.load(new FileInputStream(file));
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * -����ó�� ���μ����� �л���� ���� ������ �۾��� ������ �� �ֵ��� �ϴ� ��
	 * jdk1.5���� �߰� : java.util.cocurrent.*;
	 * 
	 * Executor : �⺻ ������ ����
	 * 
	 * ExecutorService : Executor �������̽��� Ȯ���ؼ� 
	 * 	�������� ����������Ŭ ������ �����
	 *  (���� ~ �Ҹ�Ǳ���� ���õ� �޼ҵ带 ������)
	 * */
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��û�� �ּ� ��������
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURL().toString();
		
		service.execute(new Runnable() {
			@Override
			public void run() {
				
				//url(key)�� �ش��ϴ� value�� ã�´�.
				String value = pro.getProperty(url);
				if(value==null) {
					pro.setProperty(url, "1"); //�ڷᱸ���� �����Ѱ��� ���� ������ �����Ѱ� �Ƴ�
				}else {
					int count = Integer.parseInt(value)+1;
					pro.setProperty(url, count+"");
				}
				try {
					//���Ͽ� ���� ����
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
