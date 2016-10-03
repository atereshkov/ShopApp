package com.github.handioq.shopapp.repository;

import com.github.handioq.shopapp.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */

    User findByEmail(String email);

    User findByUsername(String username);
}