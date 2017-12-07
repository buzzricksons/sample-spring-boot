package example.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SecurityRestController {
    @RequestMapping("/secret")
    public String secret(HttpSession session) {
        return "Secret Example!";
    }
}
