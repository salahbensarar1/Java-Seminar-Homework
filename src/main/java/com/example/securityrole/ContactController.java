package com.example.securityrole;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        // Add a new ContactForm object to the model
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contact"; // Return the form with validation errors
        }

        // Save the form data to the database
        ContactMessage message = new ContactMessage();
        message.setName(contactForm.getName());
        message.setEmail(contactForm.getEmail());
        message.setMessage(contactForm.getMessage());
        contactMessageRepository.save(message);

        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "redirect:/contact";
    }
}