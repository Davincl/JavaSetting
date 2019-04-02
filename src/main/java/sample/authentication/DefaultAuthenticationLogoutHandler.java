package sample.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class DefaultAuthenticationLogoutHandler implements LogoutSuccessHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationLogoutHandler.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (authentication != null && authentication.getDetails() != null) {
			try {
				LOGGER.debug(request.getSession().toString());
				LOGGER.debug("User Successfully Logout");
            } catch (Exception e) {
            	LOGGER.error(e.getMessage());
            }
		}

		response.setStatus(HttpServletResponse.SC_OK);
	    response.sendRedirect("/");
		
	}

	
}
