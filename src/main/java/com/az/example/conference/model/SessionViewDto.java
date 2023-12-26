package com.az.example.conference.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SessionViewDto {

    private Long id;
    private String name;
    private LocalDateTime updateAt;
}
