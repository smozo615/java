package com.taxi.taxi.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.taxi.taxi.domain.models.User;
import com.taxi.taxi.persistence.entities.UserEntity;

@Mapper(componentModel = "spring", uses = { BillMapper.class })
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "bills", target = "bills")
    })
    User toUser(UserEntity userEntity);

    List<User> toUsers(List<UserEntity> usersEntities);

    @InheritInverseConfiguration
    @Mapping(target = "bills", ignore = true)
    UserEntity toUserEntity(User user);
}
