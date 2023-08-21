package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;

import java.util.List;

public interface ContactService {

    Contact addContact(Contact contact);
    List<Contact> getContacts();
    Contact updateContact(Contact contact);
    boolean deleteContact(String id);
    Contact getContact(String id);
    List<Contact> search(String str);
}
