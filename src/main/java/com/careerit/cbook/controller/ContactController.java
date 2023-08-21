package com.careerit.cbook.controller;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

        private final ContactService contactService;
        @PostMapping
        public ResponseEntity<Contact> addContact(Contact contact){
            return ResponseEntity.ok(contactService.addContact(contact));
        }
        @GetMapping("/all")
        public ResponseEntity<List<Contact>> getContacts(){
            return ResponseEntity.ok(contactService.getContacts());
        }
        @GetMapping("/search")
        public ResponseEntity<List<Contact>> search(@RequestParam("str") String str){
            return ResponseEntity.ok(contactService.search(str));
        }
        @PutMapping
        public ResponseEntity<Contact> updateContact(Contact contact){
            return ResponseEntity.ok(contactService.updateContact(contact));
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteContact(@PathVariable("id") String id){
            contactService.deleteContact(id);
            return ResponseEntity.ok("Contact deleted with id :"+id);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Contact> getContact(@PathVariable("id") String id){
            return ResponseEntity.ok(contactService.getContact(id));
        }

}
