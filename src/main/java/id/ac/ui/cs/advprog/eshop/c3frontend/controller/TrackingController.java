package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TrackingController {

    @Autowired
    private RestTemplate restTemplate;

    private String trackingUrl = "http://34.87.143.187";

    @GetMapping("admin/verify-payments")
    public String verifyPaymentPage(Model model) {
        String url = trackingUrl+"/shipping/admin/get-unverified-payments";
        List<List<Object>> payments = restTemplate.getForObject(url, List.class);
        model.addAttribute("payments", payments);
        return "admin/VerifyPayments";
    }


    @GetMapping("admin/get-orders-in-progress")
    public String inProgressOrderPage(Model model){
        String url = trackingUrl+"/shipping/admin/get-orders-in-progress";
        List<List<Object>> orders = restTemplate.getForObject(url, List.class);
        model.addAttribute("payments", orders);
        return "admin/OrdersInProgress";
    }

    @GetMapping("/public/client")
    public String clientTest(){
        return "client";
    }
}
