package sample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			if(response.getContentType() == null){
				LOGGER.debug("servletPath:{}", request.getServletPath());
				LOGGER.debug("x-requested-with:{}", request.getHeader("x-requested-with"));
				
//				String path = request.getServletPath();
//				HttpSession session = request.getSession();
				
				// Session 메뉴 담기.
				
				// 접근 권한 체크 
				
				// 모바일 체크
			}
		} catch(Exception e){
			LOGGER.error(e.getMessage() + " : " + e.toString());
		}
		return true;
	}
}
