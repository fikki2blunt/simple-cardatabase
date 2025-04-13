package learn.spring_boot.hands_on.controller;

import learn.spring_boot.hands_on.domain.AccountCredentials;
import learn.spring_boot.hands_on.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> getToken (@RequestBody AccountCredentials accountCredentials){
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(accountCredentials.username(), accountCredentials.password());
        Authentication auth = authenticationManager.authenticate(creds);

        String jwts = jwtService.getToken(auth.getName());

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,
        "Bearer " + jwts).header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization").build();
    }
}
