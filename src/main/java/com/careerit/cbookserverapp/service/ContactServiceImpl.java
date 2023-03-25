package com.careerit.cbookserverapp.service;

import com.careerit.cbookserverapp.domain.Contact;
import com.careerit.cbookserverapp.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactRepo contactRepo;

  @Override
  public Contact addContact(Contact contact) {
    Assert.notNull(contact, "Contact can not be null");
    Assert.notNull(contact.getMobile(), "Mobile can not be null");
    // Validation
    Contact savedContact = contactRepo.save(contact);
    log.info("Contact is created with id :{}", savedContact.getId());
    return savedContact;
  }

  @Override
  public Contact updateContact(Contact contact) {
    return null;
  }

  @Override
  public Page<Contact> list(Pageable pageable) {
    log.info("Page size : {} number :{}", pageable.getPageSize(), pageable.getPageNumber());
    Page<Contact> page = contactRepo.findAll(pageable);
    log.info("Response contains {} contacts", page.getNumber());
    return page;
  }

  @Override
  public Page<Contact> search(Pageable pageable, String searchStr) {
    return null;
  }

  @Override
  public Optional<Contact> getContact(String id) {
    return Optional.empty();
  }

  @Override
  public boolean deleteContact(String id) {
    return false;
  }

  @Override
  public void exportContact() {

  }

  @Override
  public List<Contact> addContacts(List<Contact> list) {
    log.info("Total contacts in list :{}", list.size());
    List<Contact> contactList = contactRepo.saveAll(list);
    log.info("Total {} contacts are added", list.size());
    return contactList;
  }
}
