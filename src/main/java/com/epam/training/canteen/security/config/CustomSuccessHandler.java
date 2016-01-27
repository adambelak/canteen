package com.epam.training.canteen.security.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy;

	public CustomSuccessHandler() {
		redirectStrategy = new DefaultRedirectStrategy();
	}
	
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = getRedirectUrl(authentication.getAuthorities());

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        
        request.getSession().setAttribute("isAdmin", targetUrl.endsWith("/admin"));
        request.getSession().setAttribute("user", authentication.getName());
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    
    private String getRedirectUrl(Collection<? extends GrantedAuthority> authorities) {
        String url = "/access_denied";
    	if (isAdmin(authorities)) {
        	url = "/admin";
        } else if (isUser(authorities)) {
        	url = "/home";
        }
    	return url;
    }
    
    private boolean isAdmin(Collection<? extends GrantedAuthority> authorities) {
    	return hasAuthority(authorities, "ADMIN");
    }

    private boolean isUser(Collection<? extends GrantedAuthority> authorities) {
    	return hasAuthority(authorities, "USER");
    }
    
	private boolean hasAuthority(Collection<? extends GrantedAuthority> authorities, String authority) {
		return authorities.stream()
        		.filter(a -> authority.equals(a.getAuthority()))
        		.findAny()
        		.isPresent();
	}

}
