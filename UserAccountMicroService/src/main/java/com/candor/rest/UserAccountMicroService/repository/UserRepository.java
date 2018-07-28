package com.candor.rest.UserAccountMicroService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candor.rest.UserAccountMicroService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
