package com.taxi.taxi.domain.interfaces;

import java.util.List;
import java.util.Optional;

import com.taxi.taxi.domain.models.User;

public interface IUserRepository {
    List<User> findAll();

    User save(User user);

    Optional<User> findById(long id);
}
