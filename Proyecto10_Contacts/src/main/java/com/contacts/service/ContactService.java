package com.contacts.service;

import com.contacts.modelo.Contact;
import com.contacts.repo.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService{

    @Autowired
    private IContactRepo contactRepo;

    @Override
    public List<Contact> listContacts() {
        return contactRepo.findAll();
    }

    @Override
    public Contact findContactById(Integer contactId) {
        Contact contact = contactRepo.findById(contactId).orElse(null);
        return contact;
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepo.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepo.delete(contact);
    }
}
