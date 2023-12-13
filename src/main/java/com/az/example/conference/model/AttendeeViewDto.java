package com.az.example.conference.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendeeViewDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
}
