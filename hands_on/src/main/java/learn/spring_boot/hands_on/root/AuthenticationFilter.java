package learn.spring_boot.hands_on.root;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learn.spring_boot.hands_on.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String jwts = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (jwts != null){
                String user = jwtService.getAuthUser(request);
                Authentication authentication = new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

        filterChain.doFilter(request,response);
    }
}
