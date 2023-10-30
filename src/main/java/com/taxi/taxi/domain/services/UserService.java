package com.taxi.taxi.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taxi.taxi.domain.models.User;
import com.taxi.taxi.persistence.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
