package com.taxi.taxi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
}
