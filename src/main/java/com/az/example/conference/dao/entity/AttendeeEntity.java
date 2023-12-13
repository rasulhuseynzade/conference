package com.az.example.conference.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attendees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    @ManyToMany
    @JoinTable(name = "attendee_session",
            joinColumns = @JoinColumn(name = "attendee_id"),
            inverseJoinColumns = @JoinColumn(name = "sessions_id"))
    private List<SessionEntity> sessions;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime update_at;

}
