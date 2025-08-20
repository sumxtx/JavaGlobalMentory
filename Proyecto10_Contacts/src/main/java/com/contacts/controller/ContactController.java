package com.contacts.controller;

import com.contacts.modelo.Contact;
import com.contacts.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String init(ModelMap model){
        List<Contact> contacts = contactService.listContacts();
        contacts.forEach((contact) -> logger.info(contact.toString()));
        model.put("contacts", contacts);
        return "index";
    }

    @GetMapping("/add")
    public String showAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("contactForm")Contact contact){
        logger.info("Contact to add: " + contact);
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(value="id") int idContact, ModelMap model){
        Contact contact = contactService.findContactById(idContact);
        logger.info("Editing Contact: " + contact);
        model.put("contact", contact);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("contact") Contact contact){
        logger.info("Contact to save: " + contact );
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id") int id_contact){
        Contact contact = new Contact();
        contact.setIdContact(id_contact);
        contactService.deleteContact(contact);
        return "redirect:/";
    }
}
