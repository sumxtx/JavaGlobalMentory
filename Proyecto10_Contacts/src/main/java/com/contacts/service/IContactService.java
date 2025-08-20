package com.contacts.service;

import com.contacts.modelo.Contact;

import java.util.List;

public interface IContactService {
    public List<Contact> listContacts();

    public Contact findContactById(Integer contactId);

    public void saveContact(Contact contact);

    public void deleteContact(Contact contact);


}
