package com.careerit.cbookserverapp.service;

import com.careerit.cbookserverapp.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService {

  Contact addContact(Contact contact);
  Contact updateContact(Contact contact);
  Page<Contact> list(Pageable pageable);
  Page<Contact> search(Pageable pageable,String searchStr);
  Optional<Contact> getContact(String id);
  boolean deleteContact(String id);
  void exportContact();
  List<Contact> addContacts(List<Contact> list);
}
