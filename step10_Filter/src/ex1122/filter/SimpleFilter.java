package ex1122.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("SimpleFilter�� init call...");

	}
	


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//����ó��
		System.out.println("SimpleFilter�� ����ó����");
		chain.doFilter(request, response);//����Ÿ�ٴ���� ȣ��
		
		
		//����ó��
		System.out.println("SimpleFilter�� ����ó����");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("SimpleFilter�� destroy call...");

	}
}
