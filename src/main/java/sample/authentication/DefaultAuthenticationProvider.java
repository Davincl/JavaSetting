package sample.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DefaultAuthenticationProvider implements AuthenticationProvider{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationProvider.class);
	
	
	@Resource(name="passwordEncoder")
	private ShaPasswordEncoder passwordEncoder;


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String loginId = (String)authentication.getPrincipal();
		String loginPw = (String)authentication.getCredentials();
		
		// 아이디 값 체크
		if(null == loginId || "".equals(loginId.trim())) {
			LOGGER.debug("invalid login id");
			throw new BadCredentialsException("Login Failed");
		}
		
		// 패스워드 값 체크
		if(null == loginPw || "".equals(loginPw.trim())) {
			LOGGER.debug("invalid login pw");
			throw new BadCredentialsException("Login Failed");
		}
		
		// 패스워드 암호화
		String encryptedLoginPw = null;
    	try {
			encryptedLoginPw = passwordEncoder.encodePassword(loginPw, null);
    	} catch (Exception e) {
			LOGGER.debug("exception in encrypting login_pw ");
			throw new BadCredentialsException("Login failed");
		}
    	
    	// 로그인 아이디로 회원 데이터 로드
    	
    	// 회원 데이터 Null 체크
    	
    	// 삭제 여부 체크
    	
    	// 아이피 확인 : 아이피 접속제한 등에 사용
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		LOGGER.debug("userIp : {}", request.getRemoteAddr());
		
		
		// 아이디 및 암호화된 비밀번호 일치 확인.
		if(true){
			LOGGER.info("login success...");

			// add authorities
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			String memberVo = null; // 회원 데이터 Vo 
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(memberVo, null, authorities);
			authenticationToken.setDetails(memberVo);

			return authenticationToken;
		} else {
			throw new BadCredentialsException("Login failed");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		LOGGER.debug("supports() called...");
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	

}
