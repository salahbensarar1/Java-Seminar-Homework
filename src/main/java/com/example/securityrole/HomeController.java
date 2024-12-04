package com.example.securityrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private DataService dataService;
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
    @GetMapping("/admin/dashboard")
    public String admin() {
        return "adminDashboard";
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
//****************************************************************************************************
//****************************************************************************************************

@GetMapping("/matches")
public String showMatches(Model model) {
    model.addAttribute("matches", dataService.getAllMatches());
    return "matches";
}
//****************************************************************************************************
@GetMapping("/admin/home")
public String adminHome(Model model) {
    // Fetch data
    List<Match> matches = dataService.getAllMatches();
    List<Entry> entries = dataService.getAllEntries();
    List<Spectator> spectators = dataService.getAllSpectators();

    // Debug logging
    System.out.println("Matches: " + matches);
    System.out.println("Entries: " + entries);
    System.out.println("Spectators: " + spectators);

    // Add data to the model
    model.addAttribute("matches", matches);
    model.addAttribute("entries", entries);
    model.addAttribute("spectators", spectators);

    return "admin"; // Ensure this matches your `admin.html` file
}
//****************************************************************************************************

    @GetMapping("/entries")
    public String showEntries(Model model) {
        model.addAttribute("entries", dataService.getAllEntries());
        return "entries";
    }
//****************************************************************************************************

    @GetMapping("/spectators")
    public String showSpectators(Model model) {
        model.addAttribute("spectators", dataService.getAllSpectators());
        return "spectators";
    }
//****************************************************************************************************

}
