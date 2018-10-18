package com.security;

import com.entity.User;
import com.repository.UserRepository;
import com.util.supplier.ExceptionSupplier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(ExceptionSupplier.unsupportedOperation("Load user."));
        return new UserDetailsImpl(user);
    }

}