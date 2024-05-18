package id.ac.ui.cs.advprog.eshop.c3frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class C3FrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(C3FrontendApplication.class, args);
    }

}
