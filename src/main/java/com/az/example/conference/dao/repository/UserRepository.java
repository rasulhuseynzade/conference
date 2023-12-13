package com.az.example.conference.dao.repository;

import com.az.example.conference.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<UserEntity, String> {
     UserEntity findByUsername(String username);
}
