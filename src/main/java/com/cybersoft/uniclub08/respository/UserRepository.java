package com.cybersoft.uniclub08.respository;

import com.cybersoft.uniclub08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username); //new
}