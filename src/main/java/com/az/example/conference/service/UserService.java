package com.az.example.conference.service;

import com.az.example.conference.dao.repository.UserRepository;
import com.az.example.conference.dao.entity.AuthorityEntity;
import com.az.example.conference.dao.entity.UserEntity;
import com.az.example.conference.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registration(UserDto userDto) {
        var user = UserEntity.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true)
                .build();

        List<AuthorityEntity> authorityEntityList = new ArrayList<>();

        userDto.getRoleList().forEach(
                role -> authorityEntityList.add(new AuthorityEntity(null, user, role.name()))

                );



        user.setAuthorityEntityList(authorityEntityList);

        userRepository.save(user);


    }
}
