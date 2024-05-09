package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/products")
    public String homePage() {
        return "ProductDashboard";
    }
}
