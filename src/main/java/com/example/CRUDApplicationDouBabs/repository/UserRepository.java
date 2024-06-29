package com.example.CRUDApplicationDouBabs.repository;

import com.example.CRUDApplicationDouBabs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
