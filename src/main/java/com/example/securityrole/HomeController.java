package com.example.securityrole;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
//****************************************************************************************************
    @GetMapping("/")
    public String home() {
        return "index";
    }
//****************************************************************************************************
    @GetMapping("/home")
    public String user() {
        return "user";
    }
//****************************************************************************************************
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }
//****************************************************************************************************

@GetMapping("/visitor")
    public String visitor() {
        return "visitor";
}
//****************************************************************************************************
@GetMapping("/login")
public String loginPage() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()
            && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ANONYMOUS"))) {
        // Redirect authenticated users to their home page
        return "redirect:/home";
    }
    return "login"; // Show the login page for unauthenticated users
}
}
