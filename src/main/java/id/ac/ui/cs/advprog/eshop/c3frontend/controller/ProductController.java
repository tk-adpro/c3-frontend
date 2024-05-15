package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String homePage() {
        return "admin/ProductDashboard";
    }
    @GetMapping("/notifications")
    public String notificationPage() {
        return "admin/Notifications";
    }
    @GetMapping("/createProduct")
    public String productForm() {
        return "admin/CreateProduct";
    }
    @GetMapping("/ProductDetails/{productId}")
    public String viewDetails(@PathVariable("productId") String productId) {
        return "admin/ProductDetails";
    }
}
