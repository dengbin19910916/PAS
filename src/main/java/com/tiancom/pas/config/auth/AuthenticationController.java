package com.tiancom.pas.config.auth;

import com.tiancom.pas.config.auth.entity.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String index() {
        if(SecurityContextHolder.getContext().getAuthentication() instanceof UserPrincipal) {
            return "redirect:/";
        }
        return "auth/login";
    }
}
