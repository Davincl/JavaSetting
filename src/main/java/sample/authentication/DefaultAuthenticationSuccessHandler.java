package sample.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

public class DefaultAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		LOGGER.debug("onAuthenticationSuccess() Startd .... ");
		
		try { 
			// 아이디 저장
		} catch(Exception e) {
			LOGGER.debug("Exception Message : " + e.getMessage());
		}
		
		// 이동 URL 처리
		if(StringUtils.isEmpty(request.getParameter("returnUrl"))) { 
			HttpSession session = request.getSession();
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			if(null != savedRequest && StringUtils.isNotEmpty(savedRequest.getRedirectUrl())) {
				response.sendRedirect(savedRequest.getRedirectUrl());
			}
		} else {
			response.sendRedirect(request.getParameter("returnUrl"));
		}
		
	}
}
