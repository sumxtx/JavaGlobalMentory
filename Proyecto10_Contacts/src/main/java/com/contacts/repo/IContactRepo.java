package com.contacts.repo;

import com.contacts.modelo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepo extends JpaRepository<Contact, Integer> {

}
