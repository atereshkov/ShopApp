package com.github.handioq.shopapp.repository;

import com.github.handioq.shopapp.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthRepository extends CrudRepository<User, Long> {



}
