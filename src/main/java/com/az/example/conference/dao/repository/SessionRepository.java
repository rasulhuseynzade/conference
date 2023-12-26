package com.az.example.conference.dao.repository;

import com.az.example.conference.dao.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

}
