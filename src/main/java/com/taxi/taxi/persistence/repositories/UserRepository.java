package com.taxi.taxi.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taxi.taxi.domain.interfaces.IUserRepository;
import com.taxi.taxi.domain.models.User;
import com.taxi.taxi.persistence.crud.UserCrud;
import com.taxi.taxi.persistence.entities.UserEntity;
import com.taxi.taxi.persistence.mappers.UserMapper;

@Repository
public class UserRepository implements IUserRepository {
    private final UserCrud userCrud;

    @Autowired
    private UserMapper mapper;

    public UserRepository(UserCrud userCrud) {
        this.userCrud = userCrud;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = (List<UserEntity>) userCrud.findAll();

        return mapper.toUsers(userEntities);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userCrud.save(mapper.toUserEntity(user));

        return mapper.toUser(userEntity);
    }

    @Override
    public Optional<User> findById(long id) {
        return userCrud.findById(id).map(entity -> mapper.toUser(entity));
    }
}
