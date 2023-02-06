package com.estore.service.impl;

import com.estore.entity.DefaultUser;
import com.estore.entity.Role;
import com.estore.entity.User;
import com.estore.repository.RoleRepository;
import com.estore.repository.UserRepository;
import com.estore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getByUserName(Principal principal) {
        return userRepository.findByUsername(principal.getName());
    }

    @Override
    @Transactional
    public boolean checkExistsUser(DefaultUser defaultUser) {
        String username = defaultUser.getUsername();
        log.debug("Processing registration form for: " + username);
        User existing = userRepository.findByUsername(username);
        if (existing != null) {
            log.debug("User name already exists.");
            return true;
        } else {
            createUser(defaultUser);
            log.debug("Successfully created user: " + username);
            return false;
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private void createUser(DefaultUser defaultUser) {
        User user = new User();
        user.setUsername(defaultUser.getUsername());
        user.setPassword(passwordEncoder.encode(defaultUser.getPassword()));
        user.setFirstname(defaultUser.getFirstName());
        user.setLastname(defaultUser.getLastName());
        user.setEmail(defaultUser.getEmail());
        user.setRoles(List.of(roleRepository.findByName("USER")));
        userRepository.save(user);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
