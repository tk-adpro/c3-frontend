package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RequestController {

    @Value("${backend.url}")
    private String backendUrl;

    @GetMapping("/requests")
    public String requestDashboard() {
        return "request/requestDashboard";
    }

    @GetMapping("/requests/{requestId}")
    public String requestDetails(@PathVariable Long requestId, Model model) {
        model.addAttribute("requestId", requestId);
        return "request/requestDetails";
    }

    @GetMapping("/requests/create")
    public String createRequest() {
        return "request/createRequest";
    }

    @GetMapping("/requests/edit/{requestId}")
    public String editRequest(@PathVariable Long requestId, Model model) {
        model.addAttribute("requestId", requestId);
        return "request/editRequest";
    }
}