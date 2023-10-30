package com.taxi.taxi.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.taxi.taxi.persistence.entities.UserEntity;

interface UserCrud extends CrudRepository<UserEntity, Long> {
}