package com.example.securityrole;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        // Get the currently authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Save the form data to the database
        ContactMessage message = new ContactMessage();
        message.setName(authentication != null && authentication.isAuthenticated() && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ANONYMOUS"))
                ? authentication.getName() : "Guest");
        message.setEmail(contactForm.getEmail());
        message.setMessage(contactForm.getMessage());
        message.setTimestamp(LocalDateTime.now());
        contactMessageRepository.save(message);

        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "redirect:/contact";
    }

    @GetMapping("/messages")
    public String viewMessages(Model model) {
        model.addAttribute("messages", contactMessageRepository.findAllByOrderByTimestampDesc());
        return "messages";
    }
}