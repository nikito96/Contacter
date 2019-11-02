package com.nikito.contacter.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nikito.contacter.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
