package com.example.datingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.datingapp.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByGenderNot(String gender);
}