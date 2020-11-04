package com.gonzalezait.customer.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gonzalezait.customer.entities.model.Slogan;
import com.gonzalezait.customer.entities.model.User;

public interface SloganRepository extends CrudRepository<Slogan, Long>{

	List<Slogan> getByUser(User user);
}
