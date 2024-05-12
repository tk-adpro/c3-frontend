package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/profile")
    public String profilePage(HttpServletRequest request){
        return "profile";
    }

    @GetMapping("auth/logout")
    public String logoutPage(HttpServletRequest request){
        return "logout";
    }


}
