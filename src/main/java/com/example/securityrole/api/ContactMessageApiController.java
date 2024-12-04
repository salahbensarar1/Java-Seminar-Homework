package com.example.securityrole.api;
import com.example.securityrole.ContactMessage;
import com.example.securityrole.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class ContactMessageApiController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    // Get all messages
    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    // Get a specific message by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessageById(@PathVariable Long id) {
        Optional<ContactMessage> message = contactMessageRepository.findById(id);
        return message.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new message
    @PostMapping
    public ResponseEntity<ContactMessage> createMessage(@RequestBody ContactMessage contactMessage) {
        contactMessage.setTimestamp(java.time.LocalDateTime.now());
        ContactMessage savedMessage = contactMessageRepository.save(contactMessage);
        return ResponseEntity.ok(savedMessage);
    }

    // Update an existing message
    @PutMapping("/{id}")
    public ResponseEntity<ContactMessage> updateMessage(@PathVariable Long id, @RequestBody ContactMessage contactMessageDetails) {
        Optional<ContactMessage> existingMessage = contactMessageRepository.findById(id);

        if (existingMessage.isPresent()) {
            ContactMessage message = existingMessage.get();
            message.setName(contactMessageDetails.getName());
            message.setEmail(contactMessageDetails.getEmail());
            message.setMessage(contactMessageDetails.getMessage());
            contactMessageRepository.save(message);
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a message
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        if (contactMessageRepository.existsById(id)) {
            contactMessageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}