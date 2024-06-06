package com.ijse.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hellospring.entity.User;
import java.util.List;


//same as DAO layer in layered architecture

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    //Advanced Custom Queries
    Optional<User> findByUsername(String username);
}
