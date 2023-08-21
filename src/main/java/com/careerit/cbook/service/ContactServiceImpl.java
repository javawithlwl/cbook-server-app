package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements  ContactService{

    private final ContactRepo contactRepo;
    @Override
    public Contact addContact(Contact contact) {
        Optional<Contact> optContact = contactRepo.findByMobile(contact.getMobile());
        if(optContact.isPresent()){
            throw new IllegalArgumentException("Contact with mobile number :"+contact.getMobile()+" already exists");
        }
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public boolean deleteContact(String id) {
        if(contactRepo.existsById(id)) {
            contactRepo.deleteById(id);
            return true;
        }
        throw new IllegalArgumentException("Contact with id :"+id+" not found");
    }

    @Override
    public Contact getContact(String id) {
        return contactRepo.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Contact with id :"+id+" not found"));
    }

    @Override
    public List<Contact> search(String str) {
        return contactRepo.search(str);
    }
}
