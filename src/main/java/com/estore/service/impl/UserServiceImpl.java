package com.estore.service.impl;

import com.estore.entity.DefaultUser;
import com.estore.entity.User;
import com.estore.repository.RoleRepository;
import com.estore.repository.UserRepository;
import com.estore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User getByUserName(Principal principal) {
        return null;
    }

    @Override
    public boolean checkUserExisting(DefaultUser theDefaultUser) {
        return false;
    }
}
