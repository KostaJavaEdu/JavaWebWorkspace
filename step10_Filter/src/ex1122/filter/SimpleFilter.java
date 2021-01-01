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
		System.out.println("SimpleFilter의 init call...");

	}
	


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//사전처리
		System.out.println("SimpleFilter의 사전처리중");
		chain.doFilter(request, response);//실제타겟대상이 호출
		
		
		//사후처리
		System.out.println("SimpleFilter의 사후처리중");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("SimpleFilter의 destroy call...");

	}
}
