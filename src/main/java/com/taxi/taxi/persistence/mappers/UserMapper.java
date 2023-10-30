package com.taxi.taxi.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.taxi.taxi.domain.models.User;
import com.taxi.taxi.persistence.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "email", target = "email")
    })
    User toUser(UserEntity userEntity);

    List<User> toUsers(List<UserEntity> usersEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
