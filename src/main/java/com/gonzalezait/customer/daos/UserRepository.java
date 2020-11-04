package com.gonzalezait.customer.daos;

import org.springframework.data.repository.CrudRepository;

import com.gonzalezait.customer.entities.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User getByEmailAddress(String emailAddress);
}
