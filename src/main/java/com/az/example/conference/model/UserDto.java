package com.az.example.conference.model;

import com.az.example.conference.model.enums.Role;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private String username;
    private String password;
    private List<Role> roleList;
}
