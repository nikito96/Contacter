package com.nikito.contacter.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nikito.contacter.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
