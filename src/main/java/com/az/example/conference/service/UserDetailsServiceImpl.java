package com.az.example.conference.service;

import com.az.example.conference.dao.repository.UserRepository;
import com.az.example.conference.dao.entity.AuthorityEntity;
import com.az.example.conference.dao.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = userRepository.findByUsername(username);
        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEnabled(),
                true, true, true,
                getAuthorities(userEntity)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserEntity userEntity) {
        List<AuthorityEntity> roles = userEntity.getAuthorityEntityList();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (AuthorityEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
}