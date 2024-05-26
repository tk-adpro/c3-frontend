package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class RequestController {

    private final RestTemplate restTemplate;
    private final String backendUrl;

    public RequestController(RestTemplate restTemplate, @Value("${backend.url}") String backendUrl) {
        this.restTemplate = restTemplate;
        this.backendUrl = backendUrl;
    }

    @GetMapping("/requests")
    public String requestDashboard(Model model) {
        List<Map<String, Object>> requests = restTemplate.getForObject(backendUrl + "/api/requests", List.class);
        System.out.println("Requests received: " + requests); // Logging
        model.addAttribute("requests", requests);
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
    public String editRequest(@PathVariable UUID requestId, Model model) {
        model.addAttribute("requestId", requestId);
        return "request/editRequest";
    }

}