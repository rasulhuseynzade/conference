package com.az.example.conference.dao.repository;

import com.az.example.conference.dao.entity.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Long> {
}
