package id.ac.ui.cs.advprog.eshop.c3frontend.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RestTemplate template;

    @Value("${app.mcs.authentication.domain}")
    private String authDomain;

    @Value("${app.mcs.authentication.checktoken.route}")
    private String checkTokenRoute;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie tokenCookie = WebUtils.getCookie(request, "bearer");
        if (tokenCookie != null && !tokenCookie.getValue().isBlank()) {
            String token = tokenCookie.getValue();
            UsernamePasswordAuthenticationToken auth = validateToken(token);

            if (auth != null) SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken validateToken(String token){
        try {
            //REST call to AUTH service
            TokenCheckRequest requestObject = new TokenCheckRequest();
            requestObject.setToken(token);

            HttpEntity<TokenCheckRequest> request = new HttpEntity<>(requestObject);

            ResponseEntity<TokenCheckResponse> response = template.exchange(authDomain + checkTokenRoute, HttpMethod.POST, request, TokenCheckResponse.class);

            TokenCheckResponse responseObject = response.getBody();
            assert responseObject != null;
            if (responseObject.getData() != null) {
                ObjectMapper mapper = new ObjectMapper();
                AuthInfo authInfo = mapper.convertValue(responseObject.getData(), AuthInfo.class);
                List<GrantedAuthority> authorities = authInfo.getAuthorities().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
                return UsernamePasswordAuthenticationToken.authenticated(
                        authInfo, null, authorities
                );
            }
        } catch (Exception e){
            throw new RuntimeException("Unauthorized access");
        }
        return null;
    }
}

@Getter
@Setter
class TokenCheckResponse{
    @JsonProperty
    private String message;
    @JsonProperty
    private Object data;
}

@Getter
@Setter
class TokenCheckRequest{
    @JsonProperty
    private String token;
}