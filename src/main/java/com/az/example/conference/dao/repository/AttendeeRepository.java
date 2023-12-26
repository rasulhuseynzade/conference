package com.az.example.conference.dao.repository;

import com.az.example.conference.dao.entity.AttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<AttendeeEntity, Long> {

}
