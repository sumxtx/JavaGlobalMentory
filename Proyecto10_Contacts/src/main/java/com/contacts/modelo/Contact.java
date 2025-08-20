package com.contacts.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id_contact;
    String contactName;
    String contactNumber;
    String contactMail;


    public void setIdContact(int idContact) {
        this.id_contact = idContact;
    }
}
