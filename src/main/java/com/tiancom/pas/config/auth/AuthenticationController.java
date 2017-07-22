package com.tiancom.pas.config.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String index() {
//        if(SecurityContextHolder.getContext().getAuthentication() instanceof UserPrincipal) {
//            return "redirect:/";
//        }
        return "auth/login";
    }
}
