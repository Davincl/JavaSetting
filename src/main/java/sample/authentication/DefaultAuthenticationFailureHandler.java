package sample.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		LOGGER.debug("Exception : " + exception.getMessage());
		if(exception.getClass() == BadCredentialsException.class) {
			if ("password_input_error_count_exceed".equals(exception.getMessage())) {
				response.sendRedirect("/login?err=2");
				return;
			}
		}
		response.sendRedirect("/login?err=1");
		return;
	}

}
