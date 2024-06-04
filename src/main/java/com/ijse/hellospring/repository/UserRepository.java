package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hellospring.entity.User;

//same as DAO layer in layered architecture

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    //Advanced Custom Queries
}
