package com.SpringBoot.SpringBootDatabaseProject.repository;

import com.SpringBoot.SpringBootDatabaseProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
