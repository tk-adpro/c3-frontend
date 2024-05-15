package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import id.ac.ui.cs.advprog.eshop.c3frontend.config.AuthUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        if (AuthUtils.isAuthenticated()){
            return "redirect:/profile";
        }
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping("/auth/logout")
    public String logoutPage(){
        return "logout";
    }

    @GetMapping("/signup")
    public String signupPage(){
        if (AuthUtils.isAuthenticated()){
            return "redirect:/profile";
        }
        return "signup";
    }


}
