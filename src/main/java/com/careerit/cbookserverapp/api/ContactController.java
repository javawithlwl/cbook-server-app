package com.careerit.cbookserverapp.api;

import com.careerit.cbookserverapp.domain.Contact;
import com.careerit.cbookserverapp.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {


  private final ContactService contactService;

  @PostMapping
  public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
    Contact retContact = contactService.addContact(contact);
    return ResponseEntity.ok(retContact);
  }
  @GetMapping("/list")
  public ResponseEntity<Page<Contact>> getContacts( @SortDefault(sort = "name") @PageableDefault(size = 20) final Pageable pageable) {
    Page<Contact> page = contactService.list(pageable);
    return ResponseEntity.ok(page);

  }

  @PostMapping("/add-all")
  public ResponseEntity<List<Contact>> addContacts(@RequestBody List<Contact> list) {
    List<Contact> savedList = contactService.addContacts(list);
    return ResponseEntity.ok(savedList);
  }
}
