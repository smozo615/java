package com.taxi.taxi.controllers.dtos;

import com.taxi.taxi.domain.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be greater than 0")
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setAge(this.age);
        user.setEmail(this.email);
        return user;
    }
}
