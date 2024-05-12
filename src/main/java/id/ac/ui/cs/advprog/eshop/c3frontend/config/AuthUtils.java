package id.ac.ui.cs.advprog.eshop.c3frontend.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthUtils {

    public static synchronized Long getUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getId();
        }

        throw new RuntimeException("User is not authenticated");
    }

    public static synchronized String getEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getEmail();
        }

        throw new RuntimeException("User is not authenticated");
    }

    public static synchronized String getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getUsername();
        }

        throw new RuntimeException("User is not authenticated");
    }

    public static synchronized String getFirstName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getFirstName();
        }

        throw new RuntimeException("User is not authenticated");
    }

    public static synchronized String getLastName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getLastName();
        }

        throw new RuntimeException("User is not authenticated");
    }

    public static synchronized List<String> getRoles(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthInfo){
            return ((AuthInfo) principal).getAuthorities();
        }

        throw new RuntimeException("User is not authenticated");
    }
}