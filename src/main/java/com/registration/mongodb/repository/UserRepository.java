package com.registration.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.registration.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
