package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentPageController {

    @GetMapping("/payments")
    public String payments() {
        return "payments";
    }
}
