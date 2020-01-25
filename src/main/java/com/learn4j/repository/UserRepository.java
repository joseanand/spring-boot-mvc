/**
 * 
 */
package com.learn4j.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn4j.models.User;

/**
 * @author jose
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
