package mate.academy.spring.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class PrintInfoSuccessHandler implements AuthenticationSuccessHandler {
    private static Logger logger = Logger.getLogger(PrintInfoSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp,
                                        Authentication auth)
            throws IOException, ServletException {
        String userName = auth.getName();
        logger.info("User " + userName + " was logged successfully with roles: ");
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            logger.info(grantedAuthority);
        }
        resp.sendRedirect("/");
    }
}
