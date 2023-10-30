package com.taxi.taxi.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.taxi.taxi.persistence.entities.UserEntity;

public interface UserCrud extends CrudRepository<UserEntity, Long> {
}